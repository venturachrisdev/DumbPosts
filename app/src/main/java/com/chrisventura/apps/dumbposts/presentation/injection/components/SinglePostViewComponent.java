package com.chrisventura.apps.dumbposts.presentation.injection.components;

import com.chrisventura.apps.dumbposts.presentation.injection.modules.SinglePostViewModule;
import com.chrisventura.apps.dumbposts.presentation.ui.activities.SinglePostActivity;
import com.chrisventura.apps.dumbposts.util.CustomScope;

import dagger.Component;

/**
 * Created by ventu on 31/5/2017.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = SinglePostViewModule.class)
public interface SinglePostViewComponent {
    SinglePostActivity inject(SinglePostActivity activity);
}
