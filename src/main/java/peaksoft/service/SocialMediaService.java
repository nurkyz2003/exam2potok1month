package peaksoft.service;

import peaksoft.model.SocialMedia;

public interface SocialMediaService {
    void saveSocialMedia(SocialMedia socialMedia);

    SocialMedia getSocialMediaById(Long id);

    void updateSocialMedia(Long id,SocialMedia socialMedia);

    void deleteSocialMediaById(Long id);
}
