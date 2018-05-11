package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import business.LoginUserDTO;
import business.RegisterUserDTO;
import business.UpdatePhoneDTO;

public class UserDAOImpl implements IUserDAO{

	SessionFactory sf;
	Session session;
	Transaction transaction;
	
	public boolean validateLogin(LoginUserDTO loginUserDTO) {
		
		boolean retValue = false;
		sf = HibernateUtility.getSessionFactory();
		session = sf.openSession();
		try{
		
		
		List list = session.createQuery("from CustomerDetails cd where cd.email='"+loginUserDTO.getEmail()
		+"' and cd.password='"+loginUserDTO.getPassword()+"'").list();
		System.out.println(list.size());
		if (list.size()>0)
			retValue = true;
		
		
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return retValue;
	}

	public boolean registerNewUser(RegisterUserDTO registerUserDTO) {
		
		boolean retValue = false;
		sf =HibernateUtility.getSessionFactory();
		session  = sf.openSession();
		try{
			
			UserEntity customerEntity = new UserEntity();
			customerEntity.setDepositAmount(registerUserDTO.getDepositAmount());
			customerEntity.setEmail(registerUserDTO.getEmail());
			customerEntity.setPassword(registerUserDTO.getPassword());
			customerEntity.setPermanentAddress(registerUserDTO.getPermanentAddress());
			customerEntity.setPhoneNo(registerUserDTO.getPhoneNo());
			customerEntity.setUserName(registerUserDTO.getUserName());
			
			
			transaction = session.beginTransaction();
			session.save(customerEntity);
			session.getTransaction().commit();
			
			retValue = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
		return retValue;
	}

	public boolean updatePhoneNo(UpdatePhoneDTO updatePhoneDTO) {
		
		boolean retValue = false;
		sf = HibernateUtility.getSessionFactory();
		session = sf.openSession();
		try{		
			
			
			transaction = session.beginTransaction();
			
			Query q = session.createQuery("update from CustomerDetails ce set ce.phoneNo='"+
			updatePhoneDTO.getNewPhoneNo()+"' where ce.userName='"+updatePhoneDTO.getUserName()+"'");
			
			q.executeUpdate();
			
			session.getTransaction().commit();
			retValue = true;
			
		}
		catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return retValue;
	}

}
