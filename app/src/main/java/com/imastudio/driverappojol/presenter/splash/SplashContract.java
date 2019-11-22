package com.imastudio.driverappojol.presenter.splash;

import com.airbnb.lottie.LottieAnimationView;
import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;

public interface SplashContract {

    interface Presenter extends BasePresenter{
        void delaySplash(Long timer, LottieAnimationView lottie);
    }

    interface View extends BaseView<BasePresenter>{
        void welcomeMsg();
        void pindahHalaman();
    }
}
