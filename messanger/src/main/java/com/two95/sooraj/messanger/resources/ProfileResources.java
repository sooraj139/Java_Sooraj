package com.two95.sooraj.messanger.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.two95.sooraj.messanger.model.Profile;
import com.two95.sooraj.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {
	public ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profileService.getAllProfiles());
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}

	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") long profileId, Profile profile) {
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}

	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}

}
