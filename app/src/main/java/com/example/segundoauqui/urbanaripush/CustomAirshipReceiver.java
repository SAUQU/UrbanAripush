package com.example.segundoauqui.urbanaripush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.urbanairship.AirshipReceiver;
import com.urbanairship.push.PushMessage;

/**
 * Created by segundoauqui on 9/1/17.
 */

public class CustomAirshipReceiver extends AirshipReceiver {


    private static final String TAG = "AirShip";

    @Override
    protected void onPushReceived(@NonNull Context context, @NonNull PushMessage message, boolean notificationPosted) {
        Log.i(TAG, "Received push message. Alert: " + message.getAlert() + ". posted notification: " + notificationPosted);

        // Rebuilds and posts a notification that has already been received/posted
        Notification notification = new Notification.Builder(context)
                .setContentTitle(message.getTitle())
                .setContentText(message.getAlert())
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(1234, notification);
    }


}

