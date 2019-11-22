package com.imastudio.driverappojol.presenter.map;

import com.imastudio.driverappojol.base.BaseView;
import com.imastudio.driverappojol.model.modelmap.Distance;
import com.imastudio.driverappojol.model.modelmap.Duration;
import com.imastudio.driverappojol.model.modelmap.LegsItem;
import com.imastudio.driverappojol.model.modelmap.ResponseMap;
import com.imastudio.driverappojol.model.modelmap.RoutesItem;
import com.imastudio.driverappojol.model.modelreqorder.ResponseBooking;
import com.imastudio.driverappojol.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapPresenter implements MapContract.Presenter {
MapContract.View mapView;
BaseView view;

public MapPresenter(MapContract.View view){
    mapView=view;
}


    @Override
    public void getDataMap(String origin, String destination, String key) {
        mapView.showLoading("get data map");
        InitRetrofit.getInstanceGoogle().getDataMap(origin, destination, key)
                .enqueue(new Callback<ResponseMap>() {
                    @Override
                    public void onResponse(Call<ResponseMap> call, Response<ResponseMap> response) {
                        mapView.hideLoading();
                        if (response.isSuccessful()){
                            String status = response.body().getStatus();
                            if (status.equals("OK")){
                                List<RoutesItem> dataMap = response.body().getRoutes();
                                List<LegsItem> legs = dataMap.get(0).getLegs();
                                Distance distance = legs.get(0).getDistance();
                                Duration duration = legs.get(0).getDuration();
                                Double harga = Math.ceil((distance.getValue()/1000)*5000);
                                    String jarak = String.valueOf(distance.getValue()/1000);
                                mapView.getDataInfoOrder(duration.getText(),jarak,
                                        harga.toString());
                                String dataGaris = dataMap.get(0).getOverviewPolyline().getPoints();
                                mapView.dataGaris(dataGaris);
                                mapView.showMsg("tampil data");
                            }else{
                                mapView.showMsg("gagal tampil data");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMap> call, Throwable t) {
                    mapView.showError(t.getLocalizedMessage());
                    mapView.hideLoading();
                    }
                });
    }

    @Override
    public void requestOrder(String iduser, String latawal, String nameLocation, String latakhir, String lngakhir, String nameDesLocation, String catatan, String jarak, String lngawal, String token, String device) {
    mapView.showLoading("proses request order");
    InitRetrofit.getInstance().insertOrderBooking(iduser, latawal, nameLocation, latakhir, lngakhir
            , nameDesLocation, catatan, jarak, lngawal, token, device).enqueue(
                new Callback<ResponseBooking>() {
                    @Override
                    public void onResponse(Call<ResponseBooking> call, Response<ResponseBooking> response) {
                    mapView.hideLoading();
                        if (response.isSuccessful()){
                            String result =response.body().getResult();
                            String msg = response.body().getMsg();
                            if (result.equals("true")){
                                mapView.showMsg(msg);
                                int idbooking = response.body().getIdBooking();
                                int tarif = response.body().getTarif();
                                mapView.dataBooking(idbooking,tarif);
                            }else{
                                mapView.showMsg(msg);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBooking> call, Throwable t) {
                        mapView.hideLoading();
                        mapView.showError(t.getLocalizedMessage());
                    }
                }
        );
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
