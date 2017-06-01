package com.chrisventura.apps.dumbposts.domain.interactor;

import com.chrisventura.apps.dumbposts.data.entity.PostEntity;
import com.chrisventura.apps.dumbposts.data.entity.mapper.PostEntityModelMapper;
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
    PostEntityModelMapper modelMapper;

    @Inject
    public GetSinglePostInteractor(@Named("threadExecutor") Scheduler threadExecutor,
                                   @Named("postExecutor") Scheduler postExecutor,
                                   PostRepository postRepository,
                                   ConnectionHelper connectionHelper,
                                   PostEntityModelMapper modelMapper) {
        super(threadExecutor, postExecutor, connectionHelper);
        this.repository = postRepository;
        this.modelMapper = modelMapper;
    }

    public GetSinglePostInteractor(PostRepository postRepository,
                                   ConnectionHelper connectionHelper,
                                   PostEntityModelMapper modelMapper) {
        super(null, null, connectionHelper);
        this.repository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Observable<Post> buildInteractorObservable(Object param) {
        return repository.getSingle(param).map(this.modelMapper::transform);
    }
}
