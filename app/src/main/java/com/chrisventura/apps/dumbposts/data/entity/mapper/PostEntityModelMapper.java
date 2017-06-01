package com.chrisventura.apps.dumbposts.data.entity.mapper;

import com.chrisventura.apps.dumbposts.data.entity.PostEntity;
import com.chrisventura.apps.dumbposts.domain.model.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ventu on 31/5/2017.
 */

@Singleton
public class PostEntityModelMapper {

    @Inject
    public PostEntityModelMapper() {}

    public Post transform(PostEntity entity) {
        Post post = null;
        if (entity != null) {
            post = new Post();
            post.setUserId(entity.getUserId());
            post.setId(entity.getId());
            post.setTitle(entity.getTitle());
            post.setBody(entity.getBody());
        }
        return post;
    }

    public List<Post> transform(List<PostEntity> entities) {
        List<Post> posts = new ArrayList<>();

        for(PostEntity entity : entities) {
            Post post = transform(entity);
            if (post != null)
                posts.add(post);
        }

        return posts;
    }
}
