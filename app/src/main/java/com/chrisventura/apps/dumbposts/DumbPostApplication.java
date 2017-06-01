package com.chrisventura.apps.dumbposts;

import android.app.Application;
import android.util.Log;

import com.chrisventura.apps.dumbposts.presentation.injection.components.DaggerNetComponent;
import com.chrisventura.apps.dumbposts.presentation.injection.components.NetComponent;
import com.chrisventura.apps.dumbposts.presentation.injection.modules.AppModule;
import com.chrisventura.apps.dumbposts.presentation.injection.modules.NetModule;
import com.chrisventura.apps.dumbposts.util.AppConstants;

/**
 * Created by ventu on 29/5/2017.
 */

public class DumbPostApplication extends Application {
    static String TAG = "DumbPostApplication";
    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Application created");

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(AppConstants.API_BASE_URL))
                .build();

    }

    public NetComponent getNetComponent() {
        return this.mNetComponent;
    }
}
