package com.two95.sooraj.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.two95.sooraj.messanger.database.Database;
import com.two95.sooraj.messanger.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = Database.getAllProfiles();

	public ProfileService() {

		profiles.put("Sooraj", new Profile(1L, "Sooraj", "Sooraj", "Kdas"));
		profiles.put("Jane", new Profile(2L, "Jane", "Jane", "Ang"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getId()<=0){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile );
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
			
		
	}

}
