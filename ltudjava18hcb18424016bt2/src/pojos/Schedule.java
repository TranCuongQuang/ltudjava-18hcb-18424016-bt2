package pojos;
// Generated Aug 15, 2019 11:25:08 PM by Hibernate Tools 4.3.1



/**
 * Schedule generated by hbm2java
 */
public class Schedule  implements java.io.Serializable {


     private Integer scheduleId;
     private String subjectId;
     private String subjectName;
     private String room;
     private String class_;

    public Schedule() {
    }

    public Schedule(String subjectId, String subjectName, String room, String class_) {
       this.subjectId = subjectId;
       this.subjectName = subjectName;
       this.room = room;
       this.class_ = class_;
    }
   
    public Integer getScheduleId() {
        return this.scheduleId;
    }
    
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
    public String getSubjectId() {
        return this.subjectId;
    }
    
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getRoom() {
        return this.room;
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    public String getClass_() {
        return this.class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }
}


