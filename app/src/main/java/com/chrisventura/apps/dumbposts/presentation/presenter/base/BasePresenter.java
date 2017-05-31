package com.chrisventura.apps.dumbposts.presentation.presenter.base;

import com.chrisventura.apps.dumbposts.presentation.ui.base.BaseView;

/**
 * Created by ventu on 29/5/2017.
 */

public interface BasePresenter {
    void attach(BaseView view);

    void onResume();
    void onPause();
    void onStop();

    void dettach();
}
