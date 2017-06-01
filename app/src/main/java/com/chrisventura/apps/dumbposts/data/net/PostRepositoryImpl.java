package com.chrisventura.apps.dumbposts.data.net;

import com.chrisventura.apps.dumbposts.data.entity.PostEntity;
import com.chrisventura.apps.dumbposts.data.net.service.PostService;
import com.chrisventura.apps.dumbposts.domain.repository.PostRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ventu on 29/5/2017.
 */

public class PostRepositoryImpl implements PostRepository {
    PostService postService;

    public PostRepositoryImpl(PostService postService) {
        this.postService = postService;
    }


    @Override
    public Observable<List<PostEntity>> get() {
        return postService.getPosts();
    }

    @Override
    public Observable<PostEntity> getSingle(Object id) {
        Integer integer = (Integer) id;
        return postService.getSinglePost(integer);
    }

    @Override
    public Observable<PostEntity> insert(PostEntity post) {
        return postService.insertPost(post);
    }
}
