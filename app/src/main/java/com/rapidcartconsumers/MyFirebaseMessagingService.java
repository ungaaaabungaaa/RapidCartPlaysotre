package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService
{

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebaseMessage(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public  void  getFirebaseMessage(String title, String msg)
    {

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"Myfirebasechannel")
                .setSmallIcon(R.drawable.ic_rapidwhite)
                .setAutoCancel(true)
                .setContentTitle(title)
                .setContentText(msg);
        NotificationManagerCompat manager =NotificationManagerCompat.from(this);
        manager.notify(101, builder.build());

    }

}
