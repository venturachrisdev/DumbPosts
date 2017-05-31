package com.chrisventura.apps.dumbposts;

import com.chrisventura.apps.dumbposts.data.net.PostRepositoryImpl;
import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;
import com.chrisventura.apps.dumbposts.data.net.service.PostService;
import com.chrisventura.apps.dumbposts.domain.interactor.GetPostsInteractor;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.presenter.MainPresenter;
import com.chrisventura.apps.dumbposts.presentation.presenter.impl.MainPresenterImpl;
import com.chrisventura.apps.dumbposts.presentation.ui.MainView;
import com.chrisventura.apps.dumbposts.util.AppConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Gson gson;
    Retrofit retrofit;
    PostService postService;
    PostRepositoryImpl postRepository;
    GetPostsInteractor getPostsInteractor;
    MainPresenter mainPresenter;

    MainView mainView;

    @Before
    public void entryPoint() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(AppConstants.API_BASE_URL)
                .client(new OkHttpClient())
                .build();

        postService = retrofit.create(PostService.class);

        postRepository = new PostRepositoryImpl(postService);

        ConnectionHelper connectionHelper = new ConnectionHelper() {
            @Override
            public boolean isNetworkConnected() {
                return true;
            }
        };

        getPostsInteractor = new GetPostsInteractor(
                null,
                null,
                postRepository,
                connectionHelper
        );

        mainPresenter = new MainPresenterImpl(getPostsInteractor);

        mainView = new MainView() {
            @Override
            public void showPosts(List<Post> posts) {
                assertTrue(posts != null);
                assertTrue(posts.size() != 0);
                for (int i = 0; i < posts.size() ; i++) {
                    Post post = posts.get(i);
                    System.out.println("{");
                    System.out.println("\tid= " + post.getId());
                    System.out.println("\ttitle= " + post.getTitle());
                    System.out.println("\tbody= " + post.getBody());
                    System.out.println("},");
                }
            }

            @Override
            public void displayError(String error) {
                System.out.println(error);
            }
        };

        mainPresenter.attach(mainView);

    }

    @Test
    public void getPosts() throws Exception {
        mainPresenter.getPosts();
    }
}