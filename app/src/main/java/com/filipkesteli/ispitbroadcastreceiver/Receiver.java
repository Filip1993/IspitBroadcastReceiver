package com.filipkesteli.ispitbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {

    public static final String PARAMETER_KEY = "Pozdrav";

    public Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra(PARAMETER_KEY)) {
            String value = intent.getStringExtra(PARAMETER_KEY);
            Intent i = new Intent(context, ServiceIntent.class);
            i.putExtra(PARAMETER_KEY, value);
            context.startService(i);
        }
    }
}
