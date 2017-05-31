package com.chrisventura.apps.dumbposts.domain.interactor;

import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;
import com.chrisventura.apps.dumbposts.domain.interactor.base.AbstractInteractor;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by ventu on 29/5/2017.
 */

public class GetPostsInteractor extends AbstractInteractor<List<Post>, Void> {
    PostRepository repository;

    @Inject
    public GetPostsInteractor(@Named("threadExecutor") Scheduler threadExecutor,
                              @Named("postExecutor") Scheduler postExecutor,
                              PostRepository postRepository,
                              ConnectionHelper connectionHelper) {
        super(threadExecutor, postExecutor, connectionHelper);
        this.repository = postRepository;
    }

    @Override
    public Observable<List<Post>> buildInteractorObservable(Void unused) {
        return repository.get();
    }
}
