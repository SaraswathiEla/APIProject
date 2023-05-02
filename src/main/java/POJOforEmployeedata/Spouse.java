package POJOforEmployeedata;

public class Spouse {
	
	String name;
	String emailId;
	int ph;
	public Spouse( )
	{
		 
	}

	
	public Spouse(String name,String emailId,int ph)
	{
		this.name=name;
		this.emailId=name;
		this.ph=ph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

}
