package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Session Bean implementation class PersonBean
 */
@ManagedBean(name="personBean")
@RequestScoped
public class PersonBean {
	private String name;
    /**
     * Default constructor. 
     */
    public PersonBean() {
        // TODO Auto-generated constructor stub
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
