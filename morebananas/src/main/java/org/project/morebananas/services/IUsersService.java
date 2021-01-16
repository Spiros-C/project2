package org.project.morebananas.services;

import java.util.List;
import org.project.morebananas.entities.Users;

public interface IUsersService {
    
    Users findById(int userId);
    List<Users> findAllUsers();
    
    void saveUser(Users user);
    void updateUser(Users user);
    boolean booleanUpdate(Users user);
    void deleteUserByUserId(int userId);
    boolean booleanDeleteUserByUserId(int userId);
    
    
}
