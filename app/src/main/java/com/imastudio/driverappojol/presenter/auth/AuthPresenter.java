package com.imastudio.driverappojol.presenter.auth;

import android.content.DialogInterface;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modelauth.ResponseAuth;
import com.imastudio.driverappojol.network.InitRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthPresenter implements  AuthContract.Presenter {

    AuthContract.View authview;
    BaseView view;

    public AuthPresenter(AuthContract.View view) {
        this.authview = view;
    }

    @Override
    public void prosesLogin(String email, String password, String device, DialogInterface dialogInterface) {
        authview.showLoading("Login");
        InitRetrofit.getInstance().
                loginUser(password,email,device).enqueue(new Callback<ResponseAuth>() {
            @Override
            public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                authview.hideLoading();
                if (response.isSuccessful()){
                    String msg = response.body().getMsg();
                    String result = response.body().getResult();
                    ResponseAuth dataUser = response.body();
                    if (result.equals("true")){
                        authview.showMsg(msg);
                        dialogInterface.dismiss();
                        authview.pindahHalaman(dataUser);
                    }else{
                        authview.showMsg(msg);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseAuth> call, Throwable t) {
                authview.showError(t.getLocalizedMessage());
                authview.hideLoading();
            }
        });


    }

    @Override
    public void prosesRegister(String email, String password, String nama, String phone, DialogInterface dialogInterface) {
        authview.showLoading("Register");
        InitRetrofit.getInstance().
                registerUser(nama,phone,
                        password,email).enqueue(new Callback<ResponseAuth>() {
            @Override
            public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                authview.hideLoading();
                if (response.isSuccessful()){
                    String msg = response.body().getMsg();
                    String result = response.body().getResult();
                    if (result.equals("true")){
                        authview.showMsg(msg);
                        dialogInterface.dismiss();
                    }else{
                        authview.showMsg(msg);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseAuth> call, Throwable t) {
                authview.showError(t.getLocalizedMessage());
                authview.hideLoading();
            }
        });


    }


    @Override
    public void onAttach(BaseView view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
