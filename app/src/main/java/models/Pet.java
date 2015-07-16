package models;

import android.location.Location;

import java.util.Date;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class Pet {

    String id;
    String petName;
    String petType;
    String petBreed;
    Sex petGender;
    Date dateOfBirth;
    boolean isAlive;
    Date dateOfDeath;

    int petAge;

    Location petAddress;
    boolean isSameAddressAsUser;

    String aboutPet;
    Timeline petTimeline;
    String favouriteFood;
    String favouriteToy;
    String favouritePlace;
    String specialAboutPet;

    Location petLocation;
    boolean isLost;
    boolean isFound;
}
