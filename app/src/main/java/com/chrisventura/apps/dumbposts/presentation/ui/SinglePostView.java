package com.chrisventura.apps.dumbposts.presentation.ui;

import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.ui.base.BaseView;

/**
 * Created by ventu on 31/5/2017.
 */

public interface SinglePostView extends BaseView {
    void showPost(Post post);
}
