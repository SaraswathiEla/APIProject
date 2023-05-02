package POJOforEmployeedata;

public class CreateEmp {
	String name;
	String[] emailId;
	int[] ph;
	int empid;
	Spouse spouse;
	
	
	public CreateEmp(int[] ph)
	{
		this.ph=ph;

	}
 
	public CreateEmp() {
		 
	}

	public CreateEmp(String name,String[] emailId,	int[] ph,int empid,Spouse spouse)
	{
		super();
		this.name=name;
		this.emailId=emailId;
		this.ph=ph;
		this.empid=empid;
		this.spouse=spouse;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getEmailId() {
		return emailId;
	}
	public void setEmailId(String[] emailId) {
		this.emailId = emailId;
	}
	public int[] getPh() {
		return ph;
	}
	public void setPh(int[] ph) {
		this.ph = ph;
	}
	public int getEmpaid() {
		return empid;
	}
	public void setEmpaid(int empaid) {
		this.empid = empaid;
	}
	public Spouse getSpouse() {
		return spouse;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	
	

}
