package pojos;
// Generated Aug 7, 2019 11:50:32 PM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer studentId;
     private String studentCode;
     private String fullName;
     private boolean gender;
     private String cardNumber;

    public Student() {
    }

    public Student(String studentCode, String fullName, boolean gender, String cardNumber) {
       this.studentCode = studentCode;
       this.fullName = fullName;
       this.gender = gender;
       this.cardNumber = cardNumber;
    }
   
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getStudentCode() {
        return this.studentCode;
    }
    
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public boolean isGender() {
        return this.gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }




}

