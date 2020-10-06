package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView dataList;
    List<String> titles;
    List<String> prices;
    List<Integer> images;
    Adapter adapter;
    SwipeRefreshLayout swp;
    private ArrayList<ModelUserAdmin> mList = new ArrayList<>();
    private HTTPHandler mAdapter;
    Button btn;
    boolean sds;
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_home);
//        btn = findViewById(R.id.btnprofil);
        dataList = findViewById(R.id.dataList);
//        swp = findViewById(R.id.swipe_refresh2);
//        swp.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
//        swp.post(new Runnable(){
//            @Override
//            public void run() {
//                getApi();
//            }
//        });
        dataList.setHasFixedSize(true);
        dataList.setLayoutManager(new LinearLayoutManager(this));


        titles = new ArrayList<>();
        images = new ArrayList<>();
        prices = new ArrayList<>();
        titles.add("Sepeda satu");
        titles.add("Sepeda dua");
        titles.add("Sepeda tiga");
        titles.add("Sepeda empat");

        prices.add("5000");
        prices.add("8000");
        prices.add("7000");
        prices.add("9000");

        images.add(R.drawable.pacificoriblue);
        images.add(R.drawable.logo);
        images.add(R.drawable.pacificbluedoubt);
        images.add(R.drawable.pacificcombungu);

        adapter = new Adapter(this,titles,images,prices);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("userid");
        }

    }



//    public void getApi(){
////        swp.setRefreshing(true);
//        AndroidNetworking.get(Config.BASE_URL+"getitem")
//                .setPriority(Priority.MEDIUM)
//                .setOkHttpClient(((RS) getApplication()).getOkHttpClient())
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        swp.setRefreshing(false);
//                        if (mAdapter != null) {
//                            mAdapter.clearData();
//                            mAdapter.notifyDataSetChanged();
//                        }
//                        if (mList != null) mList.clear();
//                        Log.d("RBA", "res" + response);
//
//                        String status = response.optString(Config.RESPONSE_STATUS_FIELD);
//                        String message = response.optString(Config.RESPONSE_MESSAGE_FIELD);
//                        if (message.trim().equalsIgnoreCase(Config.RESPONSE_STATUS_VALUE_SUCCESS)) {
//                            JSONArray payload = response.optJSONArray(Config.RESPONSE_PAYLOAD_FIELD);
//
//                            if (payload == null) {
//                                Toast.makeText(HomeActivity.this, "Tidak ada user", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                            for (int i = 0; i < payload.length(); i++) {
//                                JSONObject dataUser = payload.optJSONObject(i);
//                                ModelUserAdmin item = new ModelUserAdmin(dataUser);
//                                item.setIditem(dataUser.optInt("id"));
//                                item.setMerk(dataUser.optString("merk"));
//                                item.setKodesepeda(dataUser.optString("kodsepeda"));
//                                item.setWarna(dataUser.optString("warna"));
//                                item.setGambar(dataUser.optString("gambar"));
//                                item.setUrl(dataUser.optString("url_image"));
//                                item.setHarga(dataUser.optString("harga"));
//                                mList.add(item);
//                            }
//                            mAdapter = new HTTPHandler(HomeActivity.this, mList, HomeActivity.this);
//                            dataList.setAdapter(mAdapter);
//                        } else {
//                            Toast.makeText(HomeActivity.this, message, Toast.LENGTH_SHORT).show();
//                            JSONObject payload = response.optJSONObject(Config.RESPONSE_PAYLOAD_FIELD);
//                            if (payload != null && payload.optString("API_ACTION").equalsIgnoreCase("LOGOUT"))
//                                Config.forceLogout(HomeActivity.this);
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });
//
//    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Keluar")
                .setMessage("Apakah anda yakin mau keluar?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }).create().show();
    }
}