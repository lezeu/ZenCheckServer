package com.example.server.controllers;

import com.example.server.dtos.ProfileDto;
import com.example.server.entities.ProfileEntity;
import com.example.server.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<?> getProfile() {
        ProfileEntity profileEntity = profileService.getProfile();

        if (profileEntity == null) {
            return new ResponseEntity<>(ResponseEntity.noContent().build(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(profileService.getProfile(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProfile(@RequestBody ProfileDto profileDto) {
        return new ResponseEntity<>(profileService.saveProfile(profileDto), HttpStatus.OK);
    }
}
