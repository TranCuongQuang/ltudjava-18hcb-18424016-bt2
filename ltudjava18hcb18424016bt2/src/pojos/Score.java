package pojos;
// Generated Aug 15, 2019 11:25:08 PM by Hibernate Tools 4.3.1



/**
 * Score generated by hbm2java
 */
public class Score  implements java.io.Serializable {


     private Integer scoreId;
     private float scoreMid;
     private float scoreLast;
     private float scoreOther;
     private float scoreAvg;
     private String studentId;

    public Score() {
    }

    public Score(float scoreMid, float scoreLast, float scoreOther, float scoreAvg, String studentId) {
       this.scoreMid = scoreMid;
       this.scoreLast = scoreLast;
       this.scoreOther = scoreOther;
       this.scoreAvg = scoreAvg;
       this.studentId = studentId;
    }
   
    public Integer getScoreId() {
        return this.scoreId;
    }
    
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }
    public float getScoreMid() {
        return this.scoreMid;
    }
    
    public void setScoreMid(float scoreMid) {
        this.scoreMid = scoreMid;
    }
    public float getScoreLast() {
        return this.scoreLast;
    }
    
    public void setScoreLast(float scoreLast) {
        this.scoreLast = scoreLast;
    }
    public float getScoreOther() {
        return this.scoreOther;
    }
    
    public void setScoreOther(float scoreOther) {
        this.scoreOther = scoreOther;
    }
    public float getScoreAvg() {
        return this.scoreAvg;
    }
    
    public void setScoreAvg(float scoreAvg) {
        this.scoreAvg = scoreAvg;
    }
    public String getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }




}


