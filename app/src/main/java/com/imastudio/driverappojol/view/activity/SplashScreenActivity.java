package com.imastudio.driverappojol.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.imastudio.driverappojol.MainActivity;
import com.imastudio.driverappojol.R;
import com.imastudio.driverappojol.helper.SessionManager;
import com.imastudio.driverappojol.presenter.splash.SplashContract;
import com.imastudio.driverappojol.presenter.splash.SplashPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity implements SplashContract.View {
    SplashPresenter presenter;
    @BindView(R.id.lotti1)
    LottieAnimationView lotti1;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        presenter = new SplashPresenter(this);
        presenter.delaySplash((long) 5000, lotti1);
        session = new SessionManager(this);
    }

    @Override
    public void welcomeMsg() {

        if (session.isLogin()) {

            Toast.makeText(this, "selamat datang kembali di aplikasi"
                    + getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Hi,selamat datang di aplikasi"
                    + getString(R.string.app_name), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void pindahHalaman() {
        if (session.isLogin()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, AuthActivity.class));
            finish();
        }
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);

    }

    @Override
    public void onDetachView() {
        presenter.onDetach();

    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
