package com.imastudio.driverappojol;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceId;
import com.imastudio.driverappojol.base.BaseActivity;
import com.imastudio.driverappojol.helper.SessionManager;
import com.imastudio.driverappojol.model.modelhistory.ResponseHistory;
import com.imastudio.driverappojol.network.InitRetrofit;
import com.imastudio.driverappojol.view.activity.HistoryActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private SessionManager session;
    private String tokenfcm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session= new SessionManager(this);
        if (session.getGcm().isEmpty()){
             tokenfcm = FirebaseInstanceId.getInstance().getToken();
            Toast.makeText(this, "token :"+tokenfcm, Toast.LENGTH_SHORT).show();
            insertTokentoDB();
        }
    }

    private void insertTokentoDB() {
        String iduser = session.getIdUser();
        InitRetrofit.getInstance().registerToken(iduser,tokenfcm).enqueue(new Callback<ResponseHistory>() {
            @Override
            public void onResponse(Call<ResponseHistory> call, Response<ResponseHistory> response) {
                if (response.isSuccessful()){
                    String result=  response.body().getResult();
                    String msg = response.body().getMsg();
                    if (result.equals("true")){
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHistory> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void onHistory(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.mn_logout){
        keluarApps(this,2,"logout","Apakah anda yakin logout app");
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        keluarApps(this,1,"keluar","Apakah anda yakin keluar app");
    }
}
