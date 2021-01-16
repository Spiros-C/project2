package org.project.morebananas.services;

import java.util.List;
import org.project.morebananas.dao.IUserProfileDao;
import org.project.morebananas.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileService")
@Transactional
public class UserProfileService implements IUserProfileService{
    
    @Autowired
    IUserProfileDao dao;

    public UserProfile findByProfileId(int profileId) {
        return dao.findByProfileId(profileId);
    }

    public UserProfile findByType(String type) {
        return dao.findByType(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAllUserProfiles();
    }
}
