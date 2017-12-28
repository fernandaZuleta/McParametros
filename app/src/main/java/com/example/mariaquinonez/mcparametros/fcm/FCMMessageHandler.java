package com.example.mariaquinonez.mcparametros.fcm;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.example.mariaquinonez.mcparametros.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.sql.Struct;
import java.util.Map;

/**
 * Created by maria.quinonez on 12/12/2017.
 */

public class FCMMessageHandler extends FirebaseMessagingService {
    public static final int MESSAGE_NOTIFICATION_ID=435345;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Map<String, String> data= remoteMessage.getData();
        String from= remoteMessage.getFrom();

        RemoteMessage.Notification notification= remoteMessage.getNotification();
        createNotification(notification);

    }
    private void  createNotification (RemoteMessage.Notification notification){
        Context context= getBaseContext();
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(notification.getTitle()).setContentText(notification.getBody());
        NotificationManager mNotificationManager= (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MESSAGE_NOTIFICATION_ID,mBuilder.build());
    }
}
