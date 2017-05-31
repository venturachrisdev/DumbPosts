package com.chrisventura.apps.dumbposts.presentation.presenter;

import com.chrisventura.apps.dumbposts.presentation.presenter.base.BasePresenter;

/**
 * Created by ventu on 31/5/2017.
 */

public interface SinglePostPresenter extends BasePresenter {
    void setPostId(Integer postId);
    void getSinglePost();
}
