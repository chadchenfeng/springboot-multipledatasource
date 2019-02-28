package cf.dao;

import org.apache.ibatis.annotations.Mapper;

import cf.bean.User;
@Mapper
public interface Primary {

	public User getUser();
}
