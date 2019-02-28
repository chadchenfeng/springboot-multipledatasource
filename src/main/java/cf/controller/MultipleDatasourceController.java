package cf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cf.bean.User;
import cf.dao.Primary;
import cf.dao2.Second;

@RestController
@RequestMapping("/multipledb")
public class MultipleDatasourceController {

	@Autowired
	private Primary primary;
	
	@Autowired
	private Second second;
	
	@RequestMapping("/primary")
	public User primaryDbTest() {
		User user = primary.getUser();
		return user;
	}
	
	@RequestMapping("/second")
	public String secondDbTest() {
		return second.getMenu();
	}
}
