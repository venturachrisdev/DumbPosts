package com.chrisventura.apps.dumbposts.presentation.presenter.impl;

import com.chrisventura.apps.dumbposts.domain.interactor.GetPostsInteractor;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.presenter.MainPresenter;
import com.chrisventura.apps.dumbposts.presentation.ui.MainView;
import com.chrisventura.apps.dumbposts.presentation.ui.base.BaseView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by ventu on 29/5/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    MainView mView;
    GetPostsInteractor getPostsInteractor;

    public MainPresenterImpl(GetPostsInteractor getPostsInteractor) {
        this.getPostsInteractor = getPostsInteractor;
    }

    @Override
    public void attach(BaseView view) {
        this.mView = (MainView) view;
    }

    @Override
    public void onResume() {
        getPosts();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getPosts() {

        getPostsInteractor.execute(new DisposableObserver<List<Post>>() {
            @Override
            public void onNext(@NonNull List<Post> posts) {
                mView.showPosts(posts);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                mView.displayError(e.getMessage());
            }

            @Override
            public void onComplete() {
                // TODO: Call view # hideProgress #
                mView.displayError("No error: complete");
            }
        }, null);
    }

}
