package business;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegisterUserDTO {
	private String userName;
	private String password;
	private String email;
	private String phoneNo;
	private String permanentAddress;
	private long depositAmount;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public long getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(long depositAmount) {
		this.depositAmount = depositAmount;
	}
	
}
