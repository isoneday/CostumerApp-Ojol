package com.imastudio.driverappojol.presenter.detailorder;

import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;

public interface OrderContract {
    interface Presenter extends BasePresenter{
        void detailRute(String origin, String desti, String key);
        void completeBooking(String iduser, String idbooking, String token, String device);

        void TakeBooking(String idbooking, String iddriver, String device, String token);
    }
    interface View extends BaseView<BasePresenter>{
        void showLoading(String pesanloading);
        void hideLoading();
        void showError(String localizedMessage);
        void showMsg(String msg);

        void getDataMap(String dataGaris);

        void pindahHalaman();
    }
}
