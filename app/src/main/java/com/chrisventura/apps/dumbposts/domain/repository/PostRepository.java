package com.chrisventura.apps.dumbposts.domain.repository;

import com.chrisventura.apps.dumbposts.domain.model.Post;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ventu on 29/5/2017.
 */

public interface PostRepository {

    /* Return all the posts */
    Observable<List<Post>> get();

    /* Return a single post using an ID */
    Observable<Post> getSingle(Object id);

    /* insert a post */
    Observable<Post> insert(Post post);

}
