package com.laser.breedup.backend.models;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class Privacy {
    String id;
    PrivacyStatus privacyStatus;

    protected enum PrivacyStatus {
        PUBLIC,
        PRIVATE,
        PETBUDDIES
    }
}
