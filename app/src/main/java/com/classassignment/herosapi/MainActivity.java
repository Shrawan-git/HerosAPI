package com.classassignment.herosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.classassignment.herosapi.api.HeroApi;
import com.classassignment.herosapi.model.Hero_cud;
import com.classassignment.herosapi.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etname, etpwd, etcpwd;
    private Button save, log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etname);
        etpwd = findViewById(R.id.etpwd);
        etcpwd = findViewById(R.id.etcpwd);
        save = findViewById(R.id.save);
        log = findViewById(R.id.log);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Register() {
        String name = etname.getText().toString();
        String password = etpwd.getText().toString();

        Hero_cud hero_cud = new Hero_cud(name, password);

        HeroApi heroApi = Url.getInstance().create(HeroApi.class);
        Call<Void> voidCall = heroApi.registerUser(hero_cud);


        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MainActivity.this, "Registered success", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

