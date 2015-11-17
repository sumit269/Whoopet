package com.laser.domain.entities;

import java.util.Date;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class Message {
    String id;
    String messageDescription;
    String fromId;
    String toId;
    ReadStatus readStatus;
    Date sentTime;
}
