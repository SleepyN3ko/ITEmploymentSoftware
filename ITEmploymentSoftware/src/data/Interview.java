package data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Interview {
	private String InterviewID;
	private String IntervieweeID;
	private String StaffName;
	private String Position;
	private LocalDate InterviewDate;
	private String Time;
    //parse the date into a date object
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	public Interview(String IntervieweeID,String StaffName,String Position, LocalDate InterviewDate,String Time){
		this.InterviewID = UUID.randomUUID().toString();
		this.IntervieweeID = IntervieweeID;
		this.StaffName = StaffName;
		this.Position = Position;
		this.InterviewDate = InterviewDate;
		this.Time = Time;
	}
    //create constructor with interviewID input
    public Interview(String InterviewID,String IntervieweeID,String StaffName,String Position, LocalDate InterviewDate,String Time){
        this.InterviewID = InterviewID;
        this.IntervieweeID = IntervieweeID;
        this.StaffName = StaffName;
        this.Position = Position;
        this.InterviewDate = InterviewDate;
        this.Time = Time;
    }
    //create a constructor to set the values of the variables from a csv string
    public Interview(String[] dataFromCSV){
    	this.InterviewID = dataFromCSV[0];
    	this.IntervieweeID = dataFromCSV[1];
    	this.StaffName = dataFromCSV[2];
    	this.Position = dataFromCSV[3];
        try {
            this.InterviewDate = LocalDate.parse(dataFromCSV[4],dtf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	this.Time = dataFromCSV[5];
    }
    //return the object parameters in csv format as string
    public String toCSV(){
    	return this.InterviewID + "," + this.IntervieweeID + "," + this.StaffName + "," + this.Position + "," + this.InterviewDate.format(dtf) + "," + this.Time;
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
    public LocalDate getInterviewDate() {
        return this.InterviewDate;
    }
    public void setInterviewDate(LocalDate InterviewDate) {
        this.InterviewDate = InterviewDate;
    }
    public String getTime() {
        return this.Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
}
