package com.laser.domain.scheduler;

import rx.Scheduler;

/**
 * Created by sumitbhatia on 2/10/15.
 */
public interface SubscribeOn {
    Scheduler getScheduler();
}
