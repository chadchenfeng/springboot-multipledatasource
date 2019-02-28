package cf.bean;

import java.io.Serializable;

public class Menu implements Serializable {

	private static final long serialVersionUID = -5921288541385517484L;
	private String menuname;

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
}
