package com.chrisventura.apps.dumbposts.data.net.service;

import com.chrisventura.apps.dumbposts.data.entity.PostEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ventu on 29/5/2017.
 */

public interface PostService {

    @GET("posts")
    Observable<List<PostEntity>> getPosts();

    @GET("posts/{id}")
    Observable<PostEntity> getSinglePost(@Path("id") Integer id);

    @POST("posts")
    Observable<PostEntity> insertPost(@Body PostEntity post);

}
