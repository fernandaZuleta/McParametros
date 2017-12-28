package com.example.mariaquinonez.countries.fcm;

import android.content.Intent;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by maria.quinonez on 14/12/2017.
 */

public class MyInstanceIDListenerService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh(){
        Intent intent= new Intent(this,  RegistrationIntentService.class);
        startService(intent);
    }
}
