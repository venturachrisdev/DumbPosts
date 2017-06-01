package com.chrisventura.apps.dumbposts.presentation.injection.modules;

import com.chrisventura.apps.dumbposts.domain.interactor.GetSinglePostInteractor;
import com.chrisventura.apps.dumbposts.presentation.presenter.SinglePostPresenter;
import com.chrisventura.apps.dumbposts.presentation.presenter.impl.SinglePostPresenterImpl;
import com.chrisventura.apps.dumbposts.presentation.ui.SinglePostView;
import com.chrisventura.apps.dumbposts.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ventu on 31/5/2017.
 */

@Module
@CustomScope
public class SinglePostViewModule {
    SinglePostView mView;

    public SinglePostViewModule(SinglePostView view) {
        this.mView = view;
    }


    @Provides
    @CustomScope
    SinglePostView providesSinglePostView() {
        return mView;
    }

    @Provides
    @CustomScope
    SinglePostPresenter providesSinglePostPresenter(
            GetSinglePostInteractor getSinglePostInteractor) {
        return new SinglePostPresenterImpl(getSinglePostInteractor);
    }

}
