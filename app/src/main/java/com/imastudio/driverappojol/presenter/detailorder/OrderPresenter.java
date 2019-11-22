package com.imastudio.driverappojol.presenter.detailorder;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modelhistory.ResponseHistory;
import com.imastudio.driverappojol.model.modelmap.ResponseMap;
import com.imastudio.driverappojol.network.InitRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderPresenter implements OrderContract.Presenter {

    OrderContract.View detailOrderView;
    BaseView view;

    public OrderPresenter(OrderContract.View v) {
        detailOrderView = v;
    }

    @Override
    public void detailRute(String origin, String desti, String key) {
        InitRetrofit.getInstanceGoogle().getDataMap(origin, desti, key).enqueue(new Callback<ResponseMap>() {
            @Override
            public void onResponse(Call<ResponseMap> call, Response<ResponseMap> response) {
                if (response.isSuccessful()){
                    String status = response.body().getStatus();
                    if (status.equals("OK")){
                        String dataGaris = response.body().getRoutes().get(0)
                                .getOverviewPolyline().getPoints();
                        detailOrderView.getDataMap(dataGaris);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMap> call, Throwable t) {
                    detailOrderView.showError(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void completeBooking(String iduser, String idbooking, String token, String device) {
        detailOrderView.showLoading("proses complete booking");
        InitRetrofit.getInstance().completeBooking(iduser, idbooking, token, device)
                .enqueue(new Callback<ResponseHistory>() {
            @Override
            public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                detailOrderView.hideLoading();
                if (response.isSuccessful()){
                    String result = response.body().getResult();
                    String msg = response.body().getMsg();
                    if (result.equals("true")){
                        detailOrderView.showMsg(msg);
                        detailOrderView.pindahHalaman();
                    }else {
                        detailOrderView.showMsg(msg);

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHistory> call, Throwable t) {
                detailOrderView.showError(t.getLocalizedMessage());
                detailOrderView.hideLoading();

            }
        });
    }

    @Override
    public void TakeBooking(String idbooking, String iddriver, String device, String token) {
        detailOrderView.showLoading("Proses take booking");
        InitRetrofit.getInstance().takeBooking(idbooking, iddriver, device, token)
                .enqueue(new Callback<ResponseHistory>() {
                    @Override
                    public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                        detailOrderView.hideLoading();
                        if (response.isSuccessful()){
                            String result = response.body().getResult();
                            String msg = response.body().getMsg();
                            if (result.equals("true")){
                                detailOrderView.showMsg(msg);
                                detailOrderView.pindahHalaman();

                            }else{
                                detailOrderView.showMsg(msg);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseHistory> call, Throwable t) {

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
