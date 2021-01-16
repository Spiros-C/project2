package org.project.morebananas.dao;

import java.util.List;
import org.project.morebananas.entities.UserProfile;

public interface IUserProfileDao {
    
    	UserProfile findByProfileId(int profileId);

	UserProfile findByType(String type);
	
	List<UserProfile> findAllUserProfiles();
    
}
