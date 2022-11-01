package peaksoft;

import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.model.SocialMedia;
import peaksoft.service.CarService;
import peaksoft.service.PersonService;
import peaksoft.service.SocialMediaService;
import peaksoft.serviceImpl.CarImpl;
import peaksoft.serviceImpl.PersonImpl;
import peaksoft.serviceImpl.SocialMediaImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final CarService carService = new CarImpl();
    public static final PersonService personService = new PersonImpl();
    public static final SocialMediaService socialMediaService = new SocialMediaImpl();

    public static void main( String[] args )
    {

        Person person1 = new Person("Nurkyz","Kasymova",19);
        Person person2 = new Person("Erzhigit","Kalmyzaev",22);
        Person person3 = new Person("Burulai","Urbaeva",27);

        Car car1 = new Car("Hyundai Creta","A 111 B","Black");
        Car car2 = new Car("Lada Granta","A 000 W","Pink");
        Car car3 = new Car("Kia Rio","Z 777 N","White");
        Car car4 = new Car("Lada Niva","A 123 A","Yellow");
        Car car5 = new Car("Renault Duster","L 888 L","Red");
        Car car6 = new Car("Hyundai Solaris","U 999 U","Grey");

        SocialMedia socialMedia1 = new SocialMedia("WhatsApp","January 2009","7");
        SocialMedia socialMedia2 = new SocialMedia("Instagram","October 2020","9");
        SocialMedia socialMedia3 = new SocialMedia("Twitter","March 2006","6");
        SocialMedia socialMedia4 = new SocialMedia("Facebook","February 2004","8");
        SocialMedia socialMedia5 = new SocialMedia("Odnoklassniki","March 2006","7");
        SocialMedia socialMedia6 = new SocialMedia("VK","October 2006","6");

//        personService.savePerson(person1);
//        personService.savePerson(person2);
//        personService.savePerson(person3);
//
//        carService.saveCar(1L,car1);
//        carService.saveCar(1L,car2);
//        carService.saveCar(2L,car3);
//        carService.saveCar(2L,car4);
//        carService.saveCar(3L,car5);
//        carService.saveCar(3L,car6);
//
//        socialMediaService.saveSocialMedia(socialMedia1);
//        socialMediaService.saveSocialMedia(socialMedia2);
//        socialMediaService.saveSocialMedia(socialMedia3);
//        socialMediaService.saveSocialMedia(socialMedia4);
//        socialMediaService.saveSocialMedia(socialMedia5);
//        socialMediaService.saveSocialMedia(socialMedia6);

//        System.out.println(carService.getCarById(1L));
//        carService.updateCar(1L,car3);
//        carService.deleteCarById(4L);
//        System.out.println(carService.getCarsByPersonId(1L));
//        System.out.println(carService.getCarsByPersonName("Erzhigit"));

//        System.out.println(personService.getPersonById(1L));
//        personService.updatePerson(1L,person2);
//        personService.deletePersonById(1L);

//        System.out.println(socialMediaService.getSocialMediaById(3L));
//        socialMediaService.updateSocialMedia(4L,socialMedia6);
//        socialMediaService.deleteSocialMediaById(5L);




    }
}
