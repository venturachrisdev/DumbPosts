package com.chrisventura.apps.dumbposts.domain.repository;

import com.chrisventura.apps.dumbposts.data.entity.PostEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ventu on 29/5/2017.
 */

public interface PostRepository {

    /* Return all the posts */
    Observable<List<PostEntity>> get();

    /* Return a single post using an ID */
    Observable<PostEntity> getSingle(Object id);

    /* insert a post */
    Observable<PostEntity> insert(PostEntity post);

}
