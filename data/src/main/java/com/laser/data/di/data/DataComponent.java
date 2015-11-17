package com.laser.data.di.data;

import com.laser.data.net.ApiEndpoints;

import dagger.Component;

@Component(modules = DataModule.class)
public interface DataComponent {
    ApiEndpoints endpoints();
}
