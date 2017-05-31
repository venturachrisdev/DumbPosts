package com.chrisventura.apps.dumbposts.domain.injection.modules;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.transition.Scene;

import com.chrisventura.apps.dumbposts.DumbPostApplication;
import com.chrisventura.apps.dumbposts.data.net.PostRepositoryImpl;
import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;
import com.chrisventura.apps.dumbposts.data.net.service.PostService;
import com.chrisventura.apps.dumbposts.domain.interactor.GetPostsInteractor;
import com.chrisventura.apps.dumbposts.domain.repository.PostRepository;
import com.chrisventura.apps.dumbposts.presentation.ui.AndroidConnectionHelper;
import com.chrisventura.apps.dumbposts.util.CustomScope;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ventu on 29/5/2017.
 */


@Module
public class NetModule {
    String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(DumbPostApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache providesCache(DumbPostApplication application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        GsonBuilder builder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    @Provides
    @Singleton
    OkHttpClient providesClient(Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cache(cache);

        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(Gson gson, OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(client);

        return builder.build();
    }

    @Provides
    @Singleton
    PostService providesPostService(Retrofit retrofit) {
        return retrofit.create(PostService.class);
    }

    @Provides
    @Singleton
    PostRepository providesPostRepository(PostService service) {
        return new PostRepositoryImpl(service);
    }

    @Provides
    @Singleton
    ConnectionHelper providesConnectionHelper(DumbPostApplication application) {
        return new AndroidConnectionHelper(application);
    }

    @Provides
    @Singleton
    @Named("threadExecutor")
    Scheduler providesThreadExectutor() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("postExecutor")
    Scheduler providesPostExecutor() {
        return AndroidSchedulers.mainThread();
    }

}
