package cf.config.primarydatasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "cf.dao",sqlSessionFactoryRef = "primarysessionfactory")
public class PrimaryDatasource {

	@Bean(name="primarydatasource")
	@ConfigurationProperties("spring.datasource")
//	@Primary
	public DataSource primaryDatasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="primarysessionfactory")
//	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("primarydatasource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath*:mapper/primary/*.xml"));
		return sqlSessionFactoryBean.getObject();
		
	}
}
