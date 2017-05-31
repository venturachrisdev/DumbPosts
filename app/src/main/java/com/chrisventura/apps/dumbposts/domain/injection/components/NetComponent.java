package com.chrisventura.apps.dumbposts.domain.injection.components;

import com.chrisventura.apps.dumbposts.DumbPostApplication;
import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;
import com.chrisventura.apps.dumbposts.domain.injection.modules.AppModule;
import com.chrisventura.apps.dumbposts.domain.injection.modules.NetModule;
import com.chrisventura.apps.dumbposts.domain.interactor.GetPostsInteractor;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by ventu on 29/5/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    DumbPostApplication application();
    GetPostsInteractor getPostsInteractor();
}
