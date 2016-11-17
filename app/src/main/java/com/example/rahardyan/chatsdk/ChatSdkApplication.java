package com.example.rahardyan.chatsdk;

import android.app.Application;

import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rahardyan on 16/11/16.
 */

public class ChatSdkApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initQiscusChattSdk();

    }

    private void initQiscusChattSdk(){
        Qiscus.initWithCustomServer(this, "https://halodoc-newmessaging.linkdokter.com");
    }
}
