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
	
}
