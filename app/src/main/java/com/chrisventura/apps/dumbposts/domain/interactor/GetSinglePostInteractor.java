package com.chrisventura.apps.dumbposts.domain.interactor;

import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;
import com.chrisventura.apps.dumbposts.domain.interactor.base.AbstractInteractor;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.domain.repository.PostRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by ventu on 31/5/2017.
 */

public class GetSinglePostInteractor extends AbstractInteractor<Post, Object> {
    PostRepository repository;

    @Inject
    public GetSinglePostInteractor(@Named("threadExecutor") Scheduler threadExecutor,
                                   @Named("postExecutor") Scheduler postExecutor,
                                   PostRepository postRepository,
                                   ConnectionHelper connectionHelper) {
        super(threadExecutor, postExecutor, connectionHelper);
        this.repository = postRepository;
    }

    public GetSinglePostInteractor(PostRepository postRepository,
                                   ConnectionHelper connectionHelper) {
        super(null, null, connectionHelper);
        this.repository = postRepository;
    }

    @Override
    public Observable<Post> buildInteractorObservable(Object param) {
        return repository.getSingle(param);
    }
}
