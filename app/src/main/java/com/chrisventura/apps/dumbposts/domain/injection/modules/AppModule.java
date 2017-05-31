package com.chrisventura.apps.dumbposts.domain.injection.modules;

import com.chrisventura.apps.dumbposts.DumbPostApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ventu on 29/5/2017.
 */

@Module
public class AppModule {

    DumbPostApplication application;

    public AppModule(DumbPostApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    DumbPostApplication providesApplication() {
        return application;
    }



}
