package homework11;
/* Nathan Visser
 *  4/7/2021
 *  Needs to have name, phone number, date of birth, and email address.
 * 
 * 
 */

import java.io.Serializable;


public class person implements Serializable {

	private String name;
	private String phoneNumber;
	private String DOB;
	private String emailAddy;

	public person(String name, String phoneNumber, String DOB, String emailAddy) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.DOB = DOB;
		this.emailAddy = emailAddy;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getDOB() {
		return DOB;
	}



	public void setDOB(String dOB) {
		DOB = dOB;
	}



	public String getEmailAddy() {
		return emailAddy;
	}



	public void setEmailAddy(String emailAddy) {
		this.emailAddy = emailAddy;
	}



	@Override
	public String toString() {
		return "Name = " + name + ", Phone number = " + phoneNumber + ", DOB= " + DOB + ", E-mail = " + emailAddy + "\n";
	}
	
}
