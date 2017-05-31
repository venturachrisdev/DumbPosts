package com.chrisventura.apps.dumbposts.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chrisventura.apps.dumbposts.R;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.presenter.SinglePostPresenter;
import com.chrisventura.apps.dumbposts.presentation.ui.SinglePostView;

public class SinglePostActivity extends AppCompatActivity implements SinglePostView {
    SinglePostPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.dettach();
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPost(Post post) {

    }
}
