package com.chrisventura.apps.dumbposts.domain.injection.modules;

import com.chrisventura.apps.dumbposts.domain.interactor.GetPostsInteractor;
import com.chrisventura.apps.dumbposts.presentation.presenter.MainPresenter;
import com.chrisventura.apps.dumbposts.presentation.presenter.impl.MainPresenterImpl;
import com.chrisventura.apps.dumbposts.presentation.ui.MainView;
import com.chrisventura.apps.dumbposts.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ventu on 29/5/2017.
 */

@Module
public class MainViewModule {
    MainView mainView;

    public  MainViewModule(MainView view) {
        this.mainView = view;
    }

    @Provides
    @CustomScope
    MainView providesMainView() {
        return mainView;
    }

    @Provides
    @CustomScope
    MainPresenter providesMainPresenter(GetPostsInteractor getPostsInteractor) {
        return new MainPresenterImpl(getPostsInteractor);
    }

}
