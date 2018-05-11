package business;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import persistence.UserDAOImpl;

@Path("user")
public class UserResource {
	
	@POST
	@Path("login")
	@Produces(MediaType.TEXT_PLAIN)
	public String validateLogin(@QueryParam("email") String email, @QueryParam("password") String password){

		LoginUserDTO loginUserDTO = new LoginUserDTO();
		loginUserDTO.setEmail(email);
		loginUserDTO.setPassword(password);
		boolean status = new UserDAOImpl().validateLogin(loginUserDTO);
		
		return status?"success":"failure";
	}
	
	@PUT
	@Path("update/{username}/{phone}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(@PathParam("username") String username,
			@PathParam("phone") String phone){
		UpdatePhoneDTO updatePhoneDTO = new UpdatePhoneDTO();
		updatePhoneDTO.setNewPhoneNo(phone);
		updatePhoneDTO.setUserName(username);
		
		UserDAOImpl customerDAOImpl = new UserDAOImpl();
		boolean status =customerDAOImpl.updatePhoneNo(updatePhoneDTO);
		
		return status?"success":"failure";
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerCustomer(RegisterUserDTO registerUserDTO){
		
		if (!registerUserDTO.getPhoneNo().matches("^[7-9]{1}[0-9]{9}$"))
			return "failure";
		if (!registerUserDTO.getEmail().matches("^\\w*[@]{1}\\w+.com$"))
			return "failure";
		
		UserDAOImpl customerDAOImpl = new UserDAOImpl();
		boolean status = customerDAOImpl.registerNewUser(registerUserDTO);
		
		return status?"success":"failure";
	}
}