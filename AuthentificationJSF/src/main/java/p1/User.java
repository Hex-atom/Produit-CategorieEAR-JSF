package p1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean for user authentication.
 */
@ManagedBean(name = "user")
@RequestScoped
public class User {
    private String mail; // Email field
    private String password; // Password field

    // Default constructor
    public User() {
        super();
    }

    // Getter for mail
    public String getMail() {
        return mail;
    }

    // Setter for mail
    public void setMail(String mail) {
        this.mail = mail;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
