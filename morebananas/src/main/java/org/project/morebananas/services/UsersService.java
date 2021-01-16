package org.project.morebananas.services;

import java.math.BigDecimal;
import java.util.List;
import org.project.morebananas.dao.IUsersDao;
import org.project.morebananas.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UsersService implements IUsersService{
    
    @Autowired
    IUsersDao dao;

    @Override
    public Users findById(int userId) {
        return dao.findById(userId);
        }

    @Override
    public List<Users> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public void saveUser(Users user) {
        dao.save(user);
    }

    @Override
    public void deleteUserByUserId(int userId) {
        dao.deleteUserByUserId(userId);
    }
    @Override
    public boolean booleanDeleteUserByUserId(int userId){
        return(dao.booleanDeleteUserByUserId(userId));
    }

    @Override
    public void updateUser(Users user) {
        Users tempUser = findById(user.getUserId());
        if (tempUser != null) {
            tempUser.setUserName(user.getUserName());
            tempUser.setEmail(user.getEmail());
            tempUser.setPassword(user.getPassword());
            tempUser.setCreditLimit(user.getCreditLimit());
            tempUser.setUserProfiles(user.getUserProfiles());
    
        }
    }
    @Override
    public boolean booleanUpdate(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
