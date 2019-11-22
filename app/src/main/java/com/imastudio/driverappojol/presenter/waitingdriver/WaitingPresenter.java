package com.imastudio.driverappojol.presenter.waitingdriver;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modelwaiting.ResponseWaiting;
import com.imastudio.driverappojol.network.InitRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaitingPresenter implements WaitingContract.Presenter {
    WaitingContract.View waitingView;
    BaseView view;

    public WaitingPresenter(WaitingContract.View view){
        waitingView= view;
    }

    @Override
    public void cekStatusBooking(int idbooking) {
        InitRetrofit.getInstance().checkRequestBooking(String.valueOf(idbooking))
                .enqueue(new Callback<ResponseWaiting>() {
            @Override
            public void onResponse(Call<ResponseWaiting> call, Response<ResponseWaiting> response) {
                if (response.isSuccessful()){
                    String result = response.body().getResult();
                    String msg = response.body().getMsg();
                    if (result.equals("true")){
                        waitingView.showMsg(msg);
                        String iddriver = response.body().getDriver();
                        waitingView.getidDriver(iddriver);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseWaiting> call, Throwable t) {
                waitingView.showError(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void cancelRequestBooking(int idbooking, String token, String device) {
        waitingView.showLoading("proses cancel order");
        InitRetrofit.getInstance().cancelBooking(String.valueOf(idbooking)
                ,token,device).enqueue(new Callback<ResponseWaiting>() {
            @Override
            public void onResponse(Call<ResponseWaiting> call, Response<ResponseWaiting> response) {
                waitingView.hideLoading();
                if (response.isSuccessful()){
                    String result = response.body().getResult();
                    String msg = response.body().getMsg();
                    if (result.equals("true")){
                        waitingView.showMsg(msg);
                        waitingView.back();
                    }else{
                        waitingView.showMsg(msg);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseWaiting> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(BaseView view) {
        this.view=view;

    }

    @Override
    public void onDetach() {
        view=null;

    }
}
