package com.example.rahardyan.chatsdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.QiscusAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startChatting();
            }
        });


    }

    private void startChatting(){

        Qiscus.setUser("a@b.comconsumer", "q1scu5Hal0doc")
                .withUsername("Aa Bb")
                .save(new Qiscus.SetUserListener() {
                    @Override
                    public void onSuccess(QiscusAccount qiscusAccount) {
                        Log.d("amsibsam", "success register qiscus");
                        Qiscus.buildChatWith("faiq@linkdokter.comdoctor")
                                .build(MainActivity.this, new Qiscus.ChatActivityBuilderListener() {
                                    @Override
                                    public void onSuccess(Intent intent) {
                                        startActivity(intent);
                                    }
                                    @Override
                                    public void onError(Throwable throwable) {
                                        throwable.printStackTrace();
                                    }
                                });
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("amsibsam", "failed to register "+throwable.toString());
                    }
                });

    }
}
