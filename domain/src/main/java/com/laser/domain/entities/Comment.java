package com.laser.domain.entities;

import java.util.List;

/**
 * Created by SumitBhatia on 7/06/15.
 */
public class Comment {

    String id;
    String userId;
    String commentText;
    List<Comment> replies;
}
