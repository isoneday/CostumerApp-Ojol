package com.imastudio.driverappojol.presenter.history;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modelhistory.DataHistory;
import com.imastudio.driverappojol.model.modelhistory.ResponseHistory;
import com.imastudio.driverappojol.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter implements HistoryContract.Presenter {

    HistoryContract.View historyView;
    BaseView view;
    public static List<DataHistory> dataHistoryRequest;
    public static List<DataHistory> dataHistoryProses;
    public static List<DataHistory> dataHistoryComplete;

    public HistoryPresenter(HistoryContract.View view) {
        historyView = view;
    }

    @Override
    public void getDataHistory(String iduser, String status, String token, String device) {

        historyView.showLoading("proses get data history");
      if (status.equals("1")){

          InitRetrofit.getInstance().getRequestHistory().enqueue(new Callback<ResponseHistory>() {
              @Override
              public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
            historyView.hideLoading();
            if (response.isSuccessful()){
                String result = response.body().getResult();
                String msg = response.body().getMsg();
                if (result.equals("true")){
                    historyView.showMsg(msg);
                    dataHistoryRequest = response.body().getData();
                    historyView.dataHistory(dataHistoryRequest);

                }else {
                    historyView.showMsg(msg);

                }
            }
              }

              @Override
              public void onFailure(Call<ResponseHistory> call, Throwable t) {

              }
          });
      }
       else if (status.equals("2")) {
            InitRetrofit.getInstance().getProsesHistory(iduser, token, device).enqueue(new Callback<ResponseHistory>() {
                @Override
                public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                    historyView.hideLoading();
                    if (response.isSuccessful()) {
                        String result = response.body().getResult();
                        String msg = response.body().getMsg();
                        if (result.equals("true")) {
                            historyView.showMsg(msg);
                            dataHistoryProses = response.body().getData();
                            historyView.dataHistory(dataHistoryProses);
                        } else {
                            historyView.showMsg(msg);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseHistory> call, Throwable t) {
                    historyView.showError(t.getLocalizedMessage());
                    historyView.hideLoading();

                }
            });
        } else if (status.equals("4")) {
            InitRetrofit.getInstance().getCompleteHistory(iduser, token, device).enqueue(new Callback<ResponseHistory>() {
                @Override
                public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                    historyView.hideLoading();
                    if (response.isSuccessful()) {
                        String result = response.body().getResult();
                        String msg = response.body().getMsg();
                        if (result.equals("true")) {
                            historyView.showMsg(msg);
                            dataHistoryComplete = response.body().getData();
                            historyView.dataHistory(dataHistoryComplete);
                        } else {
                            historyView.showMsg(msg);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseHistory> call, Throwable t) {
                    historyView.showError(t.getLocalizedMessage());
                    historyView.hideLoading();

                }
            });
        }

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
