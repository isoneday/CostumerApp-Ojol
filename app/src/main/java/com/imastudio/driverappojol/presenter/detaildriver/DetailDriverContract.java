package com.imastudio.driverappojol.presenter.detaildriver;

import com.imastudio.driverappojol.base.BasePresenter;
import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modeldetail.DataDetailDriver;

import java.util.List;

public interface DetailDriverContract {
    interface Presenter extends BasePresenter{
        void getDetailDriver(String idDriver);
    }
    interface View extends BaseView<BasePresenter>{
        void showLoading(String pesanloading);
        void hideLoading();
        void showError(String localizedMessage);
        void showMsg(String msg);

        void getDataDriver(List<DataDetailDriver> dataDriver);
    }
}
