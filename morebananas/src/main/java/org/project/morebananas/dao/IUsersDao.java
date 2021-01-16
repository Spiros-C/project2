package org.project.morebananas.dao;

import java.util.List;
import org.project.morebananas.entities.Users;

public interface IUsersDao {
    
    	Users findById(int userId);
	
	List<Users> findAllUsers();
	
	void save(Users user);
	//	void booleanUpdate(Users user);
	void deleteUserByUserId(int userId);
        boolean booleanDeleteUserByUserId(int userId);
}
