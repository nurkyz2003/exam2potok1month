package peaksoft.serviceImpl;

import peaksoft.dao.SocialMediaDao;
import peaksoft.daoImpl.SocialMediaDaoImpl;
import peaksoft.model.SocialMedia;
import peaksoft.service.SocialMediaService;

public class SocialMediaImpl implements SocialMediaService {
    private final SocialMediaDao socialMediaDao = new SocialMediaDaoImpl();

    @Override
    public void saveSocialMedia(SocialMedia socialMedia) {
        socialMediaDao.saveSocialMedia(socialMedia);
    }

    @Override
    public SocialMedia getSocialMediaById(Long id) {
        return socialMediaDao.getSocialMediaById(id);
    }

    @Override
    public void updateSocialMedia(Long id, SocialMedia socialMedia) {
        socialMediaDao.updateSocialMedia(id, socialMedia);
    }

    @Override
    public void deleteSocialMediaById(Long id) {
        socialMediaDao.deleteSocialMediaById(id);
    }
}
