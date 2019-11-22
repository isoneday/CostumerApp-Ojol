package com.imastudio.driverappojol.presenter.waitingdriver;

import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;

public interface WaitingContract {
    interface Presenter extends BasePresenter{

        void cekStatusBooking(int idbooking);
        void cancelRequestBooking(int idbooking, String token, String device);
    }
    interface View extends BaseView<BasePresenter>{
        void showLoading(String pesanloading);
        void hideLoading();
        void showError(String localizedMessage);
        void showMsg(String msg);

        void getidDriver(String iddriver);

        void back();
    }
}
