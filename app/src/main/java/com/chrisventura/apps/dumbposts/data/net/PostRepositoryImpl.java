package com.chrisventura.apps.dumbposts.data.net;

import com.chrisventura.apps.dumbposts.data.net.service.PostService;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;

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
    public Observable<List<Post>> get() {
        return postService.getPosts();
    }

    @Override
    public Observable<Post> getSingle(Object id) {
        Integer integer = (Integer) id;
        return postService.getSinglePost(integer);
    }

    @Override
    public Observable<Post> insert(Post post) {
        return postService.insertPost(post);
    }
}
