package com.example.y_ogawara.realmtest;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by yuusuke on 2017/06/07.
 */

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}