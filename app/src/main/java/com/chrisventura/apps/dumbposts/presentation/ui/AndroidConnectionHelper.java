package com.chrisventura.apps.dumbposts.presentation.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;

/**
 * Created by ventu on 30/5/2017.
 */

public class AndroidConnectionHelper implements ConnectionHelper {
    Context context;

    public AndroidConnectionHelper(Context context) {
        this.context = context;
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager  manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return
                networkInfo != null &&
                networkInfo.isConnectedOrConnecting() &&
                networkInfo.isAvailable();

    }
}
