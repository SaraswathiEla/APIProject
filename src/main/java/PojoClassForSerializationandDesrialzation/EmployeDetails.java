package PojoClassForSerializationandDesrialzation;

public class EmployeDetails {
	String eName;
	String eID;
	int phno;
	String email;
	String Address;

	 
	public EmployeDetails(String eName, String eID, int ph, String email, String address) {
		super();
		this.eName = eName;
		this.eID = eID;
		this.phno = ph;
		this.email = email;
		Address = address;
	}
	public EmployeDetails(String string, String string2, int[] ph, String string3, String string4)
	{
		
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteID() {
		return eID;
	}

	public void seteID(String eID) {
		this.eID = eID;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
}
