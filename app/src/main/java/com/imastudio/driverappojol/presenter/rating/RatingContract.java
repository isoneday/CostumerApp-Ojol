package com.imastudio.driverappojol.presenter.rating;

import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;

public interface RatingContract {
    interface Presenter extends BasePresenter{
        void setRatingDriver(String iduser, String iddriver, String idbooking, String rating, String comment, String token, String device);
    }
    interface View extends BaseView<BasePresenter>{
        void showLoading(String pesanloading);
        void hideLoading();
        void showError(String localizedMessage);
        void showMsg(String msg);

        void back();
    }
}
