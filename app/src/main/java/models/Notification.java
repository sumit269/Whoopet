package models;

import java.util.Date;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class Notification {
    String id;
    User from;
    User to;
    Date createdTime;
    String title;
    String description;
    String linkToRedirectTo;
    ReadStatus readStatus;
}
