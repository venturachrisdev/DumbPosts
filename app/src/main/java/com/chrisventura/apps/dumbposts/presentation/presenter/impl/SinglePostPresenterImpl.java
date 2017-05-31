package com.chrisventura.apps.dumbposts.presentation.presenter.impl;

import com.chrisventura.apps.dumbposts.domain.interactor.GetSinglePostInteractor;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.presenter.SinglePostPresenter;
import com.chrisventura.apps.dumbposts.presentation.ui.SinglePostView;
import com.chrisventura.apps.dumbposts.presentation.ui.base.BaseView;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by ventu on 31/5/2017.
 */

public class SinglePostPresenterImpl implements SinglePostPresenter {
    SinglePostView mView;
    Integer postId;
    GetSinglePostInteractor getSinglePostInteractor;

    public SinglePostPresenterImpl(GetSinglePostInteractor interactor) {
        this.getSinglePostInteractor = interactor;
    }

    @Override
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public void getSinglePost() {
        if (this.postId != null) {
            getSinglePostInteractor.execute(new DisposableObserver<Post>() {
                @Override
                public void onNext(@NonNull Post post) {
                    if (mView != null)
                        mView.showPost(post);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    e.printStackTrace();
                    if (mView != null)
                        mView.displayError(e.getMessage());
                }

                @Override
                public void onComplete() {
                    //TODO: call method {mView.hideProgress}
                }
            }, this.postId);
        }
    }

    @Override
    public void attach(BaseView view) {
        this.mView = (SinglePostView) view;
    }

    @Override
    public void onResume() {
        getSinglePost();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void dettach() {
        this.mView = null;
        getSinglePostInteractor.dispose();
    }
}
