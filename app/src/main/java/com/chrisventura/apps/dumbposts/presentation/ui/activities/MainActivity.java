package com.chrisventura.apps.dumbposts.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chrisventura.apps.dumbposts.DumbPostApplication;
import com.chrisventura.apps.dumbposts.R;
import com.chrisventura.apps.dumbposts.domain.injection.components.DaggerMainViewComponent;
import com.chrisventura.apps.dumbposts.domain.injection.modules.MainViewModule;
import com.chrisventura.apps.dumbposts.domain.model.Post;
import com.chrisventura.apps.dumbposts.presentation.presenter.MainPresenter;
import com.chrisventura.apps.dumbposts.presentation.ui.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.text1)
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainViewComponent.builder()
                .netComponent(
                        ((DumbPostApplication) getApplication())
                        .getNetComponent()
                )
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);

        presenter.attach(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPosts(List<Post> posts) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}
