package com.imastudio.driverappojol.presenter.detaildriver;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modeldetail.DataDetailDriver;
import com.imastudio.driverappojol.model.modeldetail.ResponseDetailDriver;
import com.imastudio.driverappojol.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDriverPresenter implements DetailDriverContract.Presenter {

    DetailDriverContract.View detailView;
    BaseView view;

     public DetailDriverPresenter(DetailDriverContract.View view) {
        detailView = view;
    }

    @Override
    public void getDetailDriver(String idDriver) {
    detailView.showLoading("proses get detail driver");

        InitRetrofit.getInstance().getDetailDriver(idDriver).enqueue(new Callback<ResponseDetailDriver>() {
            @Override
            public void onResponse(Call<ResponseDetailDriver> call, Response<ResponseDetailDriver> response) {
               detailView.hideLoading();
                if (response.isSuccessful()){
                    String result = response.body().getResult();
                    String msg = response.body().getMsg();
                    if (result.equals("true")){
                        detailView.showMsg(msg);
                        List<DataDetailDriver> dataDriver = response.body().getData();
                        detailView.getDataDriver(dataDriver);
                    }else{
                        detailView.showMsg(msg);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailDriver> call, Throwable t) {
                    detailView.showError(t.getLocalizedMessage());
            }
        });
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
