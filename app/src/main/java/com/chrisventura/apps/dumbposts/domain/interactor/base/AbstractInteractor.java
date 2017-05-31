package com.chrisventura.apps.dumbposts.domain.interactor.base;

import com.chrisventura.apps.dumbposts.data.net.helper.ConnectionHelper;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by ventu on 30/5/2017.
 */


public abstract class AbstractInteractor<Result, Params> {
    Scheduler mThreadExecutor;
    Scheduler mPostExectutor;
    CompositeDisposable disposables;
    ConnectionHelper connectionHelper;

    protected AbstractInteractor(Scheduler threadExecutor, Scheduler postExecutor, ConnectionHelper connectionHelper) {
        this.mThreadExecutor = threadExecutor;
        this.mPostExectutor = postExecutor;
        this.disposables = new CompositeDisposable();
        this.connectionHelper = connectionHelper;
    }

    public abstract Observable<Result> buildInteractorObservable(Params params);


    public void execute(DisposableObserver<Result> observer, Params params) {
        if (observer != null) {
            if (connectionHelper.isNetworkConnected()) {
                Observable<Result> observable;
                if (mPostExectutor == null || mThreadExecutor == null) {
                    observable = buildInteractorObservable(params);
                } else {
                    observable =  buildInteractorObservable(params)
                            .observeOn(mPostExectutor)
                            .subscribeOn(mThreadExecutor);
                }
                addDisposable(observable.subscribeWith(observer));
            } else {
                observer.onError(new Throwable("No network available"));
            }
        } else {
            throw new IllegalArgumentException("Observer cannot be null");
        }
    }

    public void dispose() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    void addDisposable(Disposable disposable) {
        if (disposable != null && disposables != null) {
            this.disposables.add(disposable);
        } else {
            throw new IllegalArgumentException("disposable cannot be null");
        }
    }

}