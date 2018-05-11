package persistence;

import business.LoginUserDTO;
import business.RegisterUserDTO;
import business.UpdatePhoneDTO;

public interface IUserDAO {

	boolean validateLogin(LoginUserDTO loginUserDTO);
	boolean registerNewUser(RegisterUserDTO registerUserDTO);
	boolean updatePhoneNo(UpdatePhoneDTO updatePhoneDTO);
	
}
