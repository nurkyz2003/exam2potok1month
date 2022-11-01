package peaksoft.dao;

import peaksoft.model.Car;
import peaksoft.model.SocialMedia;

import java.util.List;

public interface SocialMediaDao {
    void saveSocialMedia(SocialMedia socialMedia);

    SocialMedia getSocialMediaById(Long id);

    void updateSocialMedia(Long id,SocialMedia socialMedia);

    void deleteSocialMediaById(Long id);
}
