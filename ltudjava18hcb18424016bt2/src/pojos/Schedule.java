package pojos;
// Generated Aug 7, 2019 11:50:32 PM by Hibernate Tools 4.3.1

/**
 * Schedule generated by hbm2java
 */
public class Schedule implements java.io.Serializable {

    private Integer scheduleId;
    private int subjectId;
    private String subjectName;
    private String classRoom;

    public Schedule() {
    }

    public Schedule(int subjectId, String subjectName, String classRoom) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.classRoom = classRoom;
    }

    public Integer getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

}
