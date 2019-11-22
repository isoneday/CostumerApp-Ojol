package com.imastudio.driverappojol.presenter.map;

import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;

public interface MapContract {
    interface Presenter extends BasePresenter{
        void getDataMap(String s, String s1, String key);
        void requestOrder(String iduser, String latawal, String nameLocation, String latakhir, String lngakhir, String nameDesLocation, String catatan, String jarak, String lngawal, String token, String device);
    }
    interface View extends BaseView<BasePresenter>{
        void showLoading(String pesanloading);
        void hideLoading();
        void showError(String localizedMessage);
        void showMsg(String msg);
        void getDataInfoOrder(String text, String distanceText, String s);
        void dataBooking(int idbooking, int tarif);
        void dataGaris(String dataGaris);
    }
}
