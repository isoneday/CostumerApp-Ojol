package com.imastudio.driverappojol.view.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.imastudio.driverappojol.R;
import com.imastudio.driverappojol.helper.HeroHelper;
import com.imastudio.driverappojol.helper.SessionManager;
import com.imastudio.driverappojol.presenter.waitingdriver.WaitingContract;
import com.imastudio.driverappojol.presenter.waitingdriver.WaitingPresenter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

import static com.imastudio.driverappojol.helper.MyContants.IDBOOKING;
import static com.imastudio.driverappojol.helper.MyContants.IDDRIVER;


public class WaitingDriverActivity extends AppCompatActivity
        implements WaitingContract.View {
    WaitingPresenter presenter;
    @BindView(R.id.pulsator)
    PulsatorLayout pulsator;
    @BindView(R.id.buttoncancel)
    Button buttoncancel;
    private Intent intent;
    private int idbooking;
    private SessionManager session;
    ProgressDialog loading;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_driver);
        ButterKnife.bind(this);
        timer = new Timer();
        loading = new ProgressDialog(this);
        intent = getIntent();
        idbooking = intent.getIntExtra(IDBOOKING, 0);
        presenter = new WaitingPresenter(this);
        pulsator.start();
        presenter.cekStatusBooking(idbooking);

    }

    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        presenter.cekStatusBooking(idbooking);
                    }
                },0,5000);
            }
        });
    }


    @Override
    public void showLoading(String pesanloading) {
        loading.setTitle("Proses" + pesanloading);
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
    public void getidDriver(String iddriver) {
        Intent i = new Intent(this, DetailDriverActivity.class);
        i.putExtra(IDDRIVER, iddriver);
        startActivity(i);

        finish();
    }

    @Override
    public void back() {
        finish();
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
        timer.cancel();
    }

    @OnClick(R.id.buttoncancel)
    public void onViewClicked() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("cancel order");
        builder.setMessage("apakah anda yakin cancel orderan ini ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                session = new SessionManager(WaitingDriverActivity.this);
                String token = session.getToken();
                String device = HeroHelper.getDeviceUUID(WaitingDriverActivity.this);
                presenter.cancelRequestBooking(idbooking, token, device);
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
