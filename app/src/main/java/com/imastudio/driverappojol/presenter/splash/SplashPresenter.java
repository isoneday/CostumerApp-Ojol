package com.imastudio.driverappojol.presenter.splash;

import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.imastudio.driverappojol.base.BaseView;


public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View splashView;
    BaseView view;

    public SplashPresenter(SplashContract.View view) {
        splashView = view;
    }

    @Override
    public void delaySplash(Long timer, LottieAnimationView lottie) {
        lottie.setAnimation("motorcycle.json");
        lottie.loop(true);
        lottie.playAnimation();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
            splashView.welcomeMsg();
            splashView.pindahHalaman();
            }
        }, timer);
    }

    @Override
    public void onAttach(BaseView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;

    }
}
