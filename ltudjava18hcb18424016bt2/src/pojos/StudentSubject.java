package pojos;
// Generated Aug 15, 2019 11:25:08 PM by Hibernate Tools 4.3.1

/**
 * StudentSubject generated by hbm2java
 */
public class StudentSubject implements java.io.Serializable {

    private Integer studentSubjectID;
    private String studentId;
    private String fullName;
    private String gender;
    private String cardNumber;
    private String class_;
    private String subjectId;

    public StudentSubject() {
    }

    public StudentSubject(Integer studentSubjectID, String studentId, String fullName, String gender, String cardNumber, String class_, String subjectId) {
        this.studentSubjectID = studentSubjectID;
        this.studentId = studentId;
        this.fullName = fullName;
        this.gender = gender;
        this.cardNumber = cardNumber;
        this.class_ = class_;
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentSubjectID() {
        return this.studentSubjectID;
    }

    public void setStudentSubjectID(Integer studentSubjectID) {
        this.studentSubjectID = studentSubjectID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getClass_() {
        return this.class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

}
