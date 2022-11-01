package peaksoft.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.SocialMediaDao;
import peaksoft.model.SocialMedia;
import peaksoft.util.Util;

public class SocialMediaDaoImpl implements SocialMediaDao {

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();
    private final SessionFactory sessionFactory = Util.createSessionFactory();
    @Override
    public void saveSocialMedia(SocialMedia socialMedia) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new SocialMedia(socialMedia.getName(), socialMedia.getCreatAt(), socialMedia.getRating()));
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public SocialMedia getSocialMediaById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            SocialMedia socialMedia = session.find(SocialMedia.class, id);
            session.getTransaction().commit();
            session.close();
            return socialMedia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateSocialMedia(Long id, SocialMedia socialMedia) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            SocialMedia updatedSocialMedia = session.find(SocialMedia.class, id);
            updatedSocialMedia.setName(socialMedia.getName());
            updatedSocialMedia.setPerson(socialMedia.getPerson());
            updatedSocialMedia.setCreatAt(socialMedia.getCreatAt());
            updatedSocialMedia.setRating(socialMedia.getRating());
            session.merge(updatedSocialMedia);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSocialMediaById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            SocialMedia socialMedia = session.find(SocialMedia.class, id);
            session.remove(socialMedia);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
