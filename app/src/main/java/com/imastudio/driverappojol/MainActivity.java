package com.imastudio.driverappojol;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.imastudio.driverappojol.base.BaseActivity;
import com.imastudio.driverappojol.helper.SessionManager;
import com.imastudio.driverappojol.view.activity.HistoryActivity;

public class MainActivity extends BaseActivity {

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
