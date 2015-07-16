package com.laser.breedup.backend.models;

import java.util.Date;
import java.util.List;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class StatusUpdate {
    String id;
    String statusDescription;
    Photo statusPhoto;
    StatusType statusType;
    int statusLikeCount;
    List<Tag> statusTags;
    String statusLocation;
    Date createdTime;
    Date lastUpdatedTime;
    boolean isLocationAvailable;

    List<String> usersWhoLiked;
    List<String> usersWhoReportedSpam;
    List<Comment> userComments;


}
