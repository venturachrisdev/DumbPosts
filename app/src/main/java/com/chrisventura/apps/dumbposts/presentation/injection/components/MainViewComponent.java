package com.chrisventura.apps.dumbposts.presentation.injection.components;

import com.chrisventura.apps.dumbposts.presentation.injection.modules.MainViewModule;
import com.chrisventura.apps.dumbposts.presentation.ui.activities.MainActivity;
import com.chrisventura.apps.dumbposts.util.CustomScope;

import dagger.Component;

/**
 * Created by ventu on 29/5/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {
    MainActivity inject(MainActivity view);
}
