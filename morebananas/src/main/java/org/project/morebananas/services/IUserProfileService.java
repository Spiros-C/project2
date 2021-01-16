package org.project.morebananas.services;

import java.util.List;
import org.project.morebananas.entities.UserProfile;

public interface IUserProfileService {
    
    	UserProfile findByProfileId(int profileId);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
    
}
