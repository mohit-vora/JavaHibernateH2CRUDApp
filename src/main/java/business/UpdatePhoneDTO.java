package business;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdatePhoneDTO {

	private String userName;
	public String getNewPhoneNo() {
		return newPhoneNo;
	}
	public void setNewPhoneNo(String newPhoneNo) {
		this.newPhoneNo = newPhoneNo;
	}
	private String newPhoneNo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
