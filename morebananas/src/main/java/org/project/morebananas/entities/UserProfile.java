package org.project.morebananas.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


//@Data
//@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name="user_profile")
public class UserProfile {
    
    @Id
    @Column(name = "profileId")
    private Integer profileId;

    @NonNull
    @Column(name = "type", length = 15, unique=true)
    private String type = Profiles.USER.getType();

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   

}
