package com.imastudio.driverappojol.view.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.compat.AutocompleteFilter;
import com.google.android.libraries.places.compat.Place;
import com.google.android.libraries.places.compat.ui.PlaceAutocomplete;
import com.imastudio.driverappojol.R;
import com.imastudio.driverappojol.base.BaseActivity;
import com.imastudio.driverappojol.helper.DirectionMapsV2;
import com.imastudio.driverappojol.helper.GPSTracker;
import com.imastudio.driverappojol.helper.HeroHelper;
import com.imastudio.driverappojol.helper.SessionManager;
import com.imastudio.driverappojol.presenter.map.MapContract;
import com.imastudio.driverappojol.presenter.map.MapPresenter;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.imastudio.driverappojol.helper.MyContants.IDBOOKING;
import static com.imastudio.driverappojol.helper.MyContants.LOKASIAWAL;
import static com.imastudio.driverappojol.helper.MyContants.LOKASITUJUAN;
import static com.imastudio.driverappojol.helper.MyContants.REQUEST_LOCATION;
import static com.imastudio.driverappojol.helper.MyContants.TARIF;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback, MapContract.View {

    @BindView(R.id.imgpick)
    ImageView imgpick;
    @BindView(R.id.lokasiawal)
    TextView lokasiawal;
    @BindView(R.id.lokasitujuan)
    TextView lokasitujuan;
    @BindView(R.id.edtcatatan)
    EditText edtcatatan;
    @BindView(R.id.txtharga)
    TextView txtharga;
    @BindView(R.id.txtjarak)
    TextView txtjarak;
    @BindView(R.id.txtdurasi)
    TextView txtdurasi;
    @BindView(R.id.requestorder)
    Button requestorder;
    @BindView(R.id.rootlayout)
    RelativeLayout rootlayout;
    private GoogleMap mMap;
    private GPSTracker gps;
    private double myLat;
    private double myLng;
    private LatLng myLatLng;
    private String nameLocation;
    private double desLat;
    private double desLng;
    private String nameDesLocation;
    MapPresenter presenter;
    ProgressDialog loading;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        callPermission(this, Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_LOCATION);
        checkGpsDevice(this);
        loading = new ProgressDialog(this);

        presenter = new MapPresenter(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED) {
            checkPermissionAndCall();

        }
    }

    private void checkPermissionAndCall() {
        if (Build.VERSION.SDK_INT > 22) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            } else {
                getMyLocation();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getMyLocation();

    }

    private void getMyLocation() {
        gps = new GPSTracker(this);

        if (gps.canGetLocation()) {
            myLat = gps.getLatitude();
            myLng = gps.getLongitude();
            Toast.makeText(this, "lat :" + myLat + "lon :" + myLng, Toast.LENGTH_SHORT)
                    .show();
            addMarker(myLat, myLng);
            lokasiawal.setText(nameLocation);
        }
    }

    private void addMarker(double myLat, double myLng) {
        myLatLng = new LatLng(myLat, myLng);
        nameLocation = convertLocation(myLat, myLng);
        mMap.addMarker(new MarkerOptions().position(myLatLng).title(nameLocation))
                .setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pickup));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 18));
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }

    private String convertLocation(double myLat, double myLng) {
        nameLocation = null;
        Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
        try {
            List<Address> list = geocoder.getFromLocation(myLat, myLng, 1);
            if (list != null && list.size() > 0) {
                nameLocation = list.get(0).getAddressLine(0) + "" + list.get(0).getCountryName();

                //fetch data from addresses
            } else {
                Toast.makeText(MapsActivity.this, "kosong", Toast.LENGTH_SHORT).show();
                //display Toast message
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameLocation;
    }


    @OnClick({R.id.imgpick, R.id.lokasiawal, R.id.lokasitujuan, R.id.requestorder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgpick:
                break;
            case R.id.lokasiawal:
                setLocation(LOKASIAWAL);
                break;
            case R.id.lokasitujuan:
                setLocation(LOKASITUJUAN);
                break;
            case R.id.requestorder:
                session = new SessionManager(this);
                String iduser = session.getIdUser();
                String latawal = String.valueOf(myLat);
                String latakhir = String.valueOf(desLat);
                String lngakhir = String.valueOf(desLng);
                String catatan = edtcatatan.getText().toString();
                String jarak =txtjarak.getText().toString();
                String lngawal = String.valueOf(myLng);
                String token = session.getToken();
                String device = HeroHelper.getDeviceUUID(this);
                presenter.requestOrder(iduser,latawal,nameLocation,latakhir,lngakhir,
                        nameDesLocation,catatan,jarak,lngawal,token,device);
                break;
        }
    }

    private void setLocation(int lokasi) {
        AutocompleteFilter filter = new AutocompleteFilter.Builder()
                .setCountry("ID")
                .build();

        Intent i = null;
        try {
            i = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .setFilter(filter)
                    .build(MapsActivity.this);
            startActivityForResult(i, lokasi);
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOKASIAWAL && resultCode == RESULT_OK) {
            Place place = PlaceAutocomplete.getPlace(this, data);
            myLat = place.getLatLng().latitude;
            myLng = place.getLatLng().longitude;
            myLatLng = new LatLng(myLat, myLng);
            mMap.clear();
            nameLocation = place.getAddress().toString();
            mMap.addMarker(new MarkerOptions().position(myLatLng).title(nameLocation))
                    .setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pickup));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 17));
        } else if (requestCode == LOKASITUJUAN && resultCode == RESULT_OK) {
            Place place = PlaceAutocomplete.getPlace(this, data);

            desLat = place.getLatLng().latitude;
            desLng = place.getLatLng().longitude;
            LatLng desLatLng = new LatLng(desLat, desLng);
            nameDesLocation = place.getAddress().toString();
            mMap.addMarker(new MarkerOptions().position(desLatLng).title(nameDesLocation))
                    .setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pickup));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(desLatLng, 17));
            String key = getString(R.string.google_maps_key);
            presenter.getDataMap(myLat + "," + myLng, desLat + "," + desLng, key);
            lokasitujuan.setText(nameDesLocation);
        }
    }

    @Override
    public void showLoading(String pesanloading) {
        loading.setTitle("Proses"+pesanloading);
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
    public void getDataInfoOrder(String durasi, String distanceText, String harga) {
        txtdurasi.setText(durasi);
        txtharga.setText(harga);
        txtjarak.setText(distanceText);
    }

    @Override
    public void dataBooking(int idbooking, int tarif) {
        Intent i = new Intent(this,WaitingDriverActivity.class);
        i.putExtra(IDBOOKING,idbooking);
        i.putExtra(TARIF,tarif);
        startActivity(i);
    }

    @Override
    public void dataGaris(String dataGaris) {
        DirectionMapsV2 mapsV2 = new DirectionMapsV2(this);
        mapsV2.gambarRoute(mMap,dataGaris);
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
