package com.example.userdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.userdetails.api.ApiClient;
import com.example.userdetails.api.ApiInterface;
import com.example.userdetails.schema.Datum;
import com.example.userdetails.schema.Example;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final int page=12;
    private RecyclerView recyclerView;
    public static List<Datum> datums = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        LoadJson();

    }

    public void LoadJson()
    {
        ApiInterface apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        Call<Example> call;
        call=apiInterface.getExample(page);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                datums= response.body().getData();
                adapter = new Adapter( datums, MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                initListener();

                if(datums != null){
                    Log.i("status", "if" );
                    Log.i("Res", datums.get(0).getFirstName() + " " + datums.get(0).getLastName() +" " + datums.get(0).getAvatar());
                    Log.i("Res", datums.get(1).getFirstName() + " " + datums.get(1).getLastName() +" " + datums.get(1).getAvatar());
                    Log.i("Res", datums.get(2).getFirstName() + " " + datums.get(2).getLastName() +" " + datums.get(2).getAvatar());
                    Log.i("Res", datums.get(3).getFirstName() + " " + datums.get(3).getLastName() +" " + datums.get(3).getAvatar());


                }else{
                    Log.i("status", " else");
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.i("statusi","No Response");
            }
        });

    }
    private void initListener(){
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(MainActivity.this, User_Details_View.class);
//                Datum datum = datums.get(position);
//                intent.putExtra("firstname", datum.getFirstName());
//                intent.putExtra("lastname", datum.getLastName());
//                intent.putExtra("avatar", datum.getAvatar());
//                intent.putExtra("email", datum.getEmail());
//                intent.putExtra("id", datum.getId());
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

    }
}
