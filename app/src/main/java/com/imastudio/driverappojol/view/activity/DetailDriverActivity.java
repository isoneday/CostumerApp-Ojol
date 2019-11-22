package com.imastudio.driverappojol.view.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.imastudio.driverappojol.R;
import com.imastudio.driverappojol.base.BaseActivity;
import com.imastudio.driverappojol.helper.MyContants;
import com.imastudio.driverappojol.model.modeldetail.DataDetailDriver;
import com.imastudio.driverappojol.presenter.detaildriver.DetailDriverContract;
import com.imastudio.driverappojol.presenter.detaildriver.DetailDriverPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.imastudio.driverappojol.helper.MyContants.IDDRIVER;

public class DetailDriverActivity extends BaseActivity implements OnMapReadyCallback, DetailDriverContract.View {

    @BindView(R.id.lokasiawal)
    TextView lokasiawal;
    @BindView(R.id.lokasitujuan)
    TextView lokasitujuan;
    @BindView(R.id.txtnamadriver)
    TextView txtnamadriver;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.txthpdriver)
    TextView txthpdriver;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    private GoogleMap mMap;
    DetailDriverPresenter presenter;
    private Intent intent;
    private String idDriver;
    ProgressDialog loading;
    private double latdriver;
    private double londriver;
    private LatLng posisiDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_driver);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        loading = new ProgressDialog(this);
        callPermission(this,Manifest.permission.CALL_PHONE, MyContants.READPHONE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        intent = getIntent();
        idDriver = intent.getStringExtra(IDDRIVER);
        presenter = new DetailDriverPresenter(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter.getDetailDriver(idDriver);

    }

    @Override
    public void showLoading(String pesanloading) {
        loading.setTitle(pesanloading);
        loading.setMessage("loading . .. . ");
        loading.show();

    }

    @Override
    public void hideLoading() {
        loading.dismiss();
    }

    @Override
    public void showError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void getDataDriver(List<DataDetailDriver> driver) {
        txthpdriver.setText(driver.get(0).getUserHp());
        txtnamadriver.setText(driver.get(0).getUserNama());
        latdriver = Double.parseDouble(driver.get(0).getTrackingLat());
        londriver = Double.parseDouble(driver.get(0).getTrackingLng());
        posisiDriver = new LatLng(latdriver, londriver);
        mMap.addMarker(new MarkerOptions().position(posisiDriver)).setIcon(
                BitmapDescriptorFactory.fromResource(R.mipmap.ic_car)
        );
        mMap.moveCamera(CameraUpdateFactory.
                newLatLngZoom(posisiDriver, 17));
        mMap.setPadding(40, 150, 50, 120);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        txthpdriver.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + driver.get(0).getUserHp())));
            }
        });
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
