package cf.config.seconddatasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "cf.dao2",sqlSessionFactoryRef = "secondsessionfactory")
public class SecondDatasource {

	@Bean(name="seconddatasource")
	@ConfigurationProperties("spring.datasourcesecond")
	public DataSource primaryDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondsessionfactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("seconddatasource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath*:mapper/second/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
}
