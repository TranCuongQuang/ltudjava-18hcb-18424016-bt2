package pojos;
// Generated Aug 7, 2019 11:50:32 PM by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private String password;

    public User() {
    }

    public User(String userName, String password) {
       this.userName = userName;
       this.password = password;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


