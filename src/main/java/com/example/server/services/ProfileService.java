package com.example.server.services;

import com.example.server.dtos.ProfileDto;
import com.example.server.entities.ProfileEntity;
import com.example.server.repos.ProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private ProfileRepo profileRepo;

    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public ProfileEntity getProfile() {
        return profileRepo.findAll().stream().findFirst().orElse(null);
    }

    public ProfileEntity saveProfile(ProfileDto profileDto) {
        ProfileEntity profileEntity = getProfile() != null ? getProfile() : new ProfileEntity();
        if (profileDto.getName() != null) {
            profileEntity.setName(profileDto.getName());
        }
        if (profileDto.getEmail()!= null) {
            profileEntity.setEmail(profileDto.getEmail());
        }
        if (profileDto.getSex()!= null) {
            profileEntity.setSex(profileDto.getSex());
        }
        if (profileDto.getHrThreshold() != 0.0f) {
            profileEntity.setHrThreshold(profileDto.getHrThreshold());
        }
        if (profileDto.getSdnnThreshold()!= 0.0f) {
            profileEntity.setSdnnThreshold(profileDto.getSdnnThreshold());
        }
        if (profileDto.getRmssdThreshold()!= 0.0f) {
            profileEntity.setRmssdThreshold(profileDto.getRmssdThreshold());
        }

        return profileRepo.save(profileEntity);
    }
}
