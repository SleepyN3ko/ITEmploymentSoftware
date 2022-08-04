package data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Interview {
	private String InterviewID;
	private String IntervieweeID;
	private String StaffName;
	private String Position;
	private Date InterviewDate;
	private String Time;
	public Interview(String IntervieweeID,String StaffName,String Position, Date InterviewDate,String Time){
		this.InterviewID = UUID.randomUUID().toString();
		this.IntervieweeID = IntervieweeID;
		this.StaffName = StaffName;
		this.Position = Position;
		this.InterviewDate = InterviewDate;
		this.Time = Time;
	}
    //create and setter for all private variables
    public String getInterviewID() {
        return this.InterviewID;
    }
    public void setInterviewID(String InterviewID) {
        this.InterviewID = InterviewID;
    }
    public String getIntervieweeID() {
        return this.IntervieweeID;
    }
    public void setIntervieweeID(String IntervieweeID) {
        this.IntervieweeID = IntervieweeID;
    }
    public String getStaffName() {
        return this.StaffName;
    }
    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }
    public String getPosition() {
        return this.Position;
    }
    public void setPosition(String Position) {
        this.Position = Position;
    }
    public Date getInterviewDate() {
        return this.InterviewDate;
    }
    public void setInterviewDate(Date InterviewDate) {
        this.InterviewDate = InterviewDate;
    }
    public String getTime() {
        return this.Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    

	
}
