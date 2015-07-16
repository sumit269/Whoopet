package models;

import java.util.Date;
import java.util.List;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class UserProfile {
    String userName;
    String password;
    Photo userProfilePhoto;
    String about;
    String firstName;
    String lastName;
    Date dateOfBirth;
    Sex sex;
    List<Language> userLanguages;
    RelationStatus userRelationShipStatus;

    List<Pet> pets;

    List<String> blockedUserIdList;
}
