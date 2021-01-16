package org.project.morebananas.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.project.morebananas.entities.UserProfile;
import org.springframework.stereotype.Repository;


@Repository("iUserProfileDao")
public class UserProfileDao extends AbstractDao<Integer, UserProfile> implements IUserProfileDao{
        
    @Override
        public UserProfile findByProfileId(int profileId){
            return getByKey(profileId);
        }
        
        @Override
        public UserProfile findByType(String type){
		//System.out.println("type: "+type);
		try{
			UserProfile userProfile = (UserProfile) getEntityManager()
					.createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type")
					.setParameter("type", type)
					.getSingleResult();
			return userProfile; 
		}catch(NoResultException exception){
			return null;
		}
	}
        
        
        @Override
        @SuppressWarnings("unchecked")
	public List<UserProfile> findAllUserProfiles(){
		List<UserProfile> userProfiles = getEntityManager()
				.createQuery("SELECT p FROM UserProfile p  ORDER BY p.type ASC")
				.getResultList();
		return userProfiles;
	}
	
    
}
