package com.chrisventura.apps.dumbposts.presentation.ui;

import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.ui.base.BaseView;

import java.util.List;

/**
 * Created by ventu on 29/5/2017.
 */

public interface MainView extends BaseView {

    void showPosts(List<Post> posts);

}
