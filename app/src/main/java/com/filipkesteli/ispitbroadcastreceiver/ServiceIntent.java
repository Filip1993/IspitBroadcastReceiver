package com.filipkesteli.ispitbroadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by programer on 6.6.2016..
 */
public class ServiceIntent extends IntentService {

    private Handler handler = new Handler();

    public ServiceIntent() {
        super("Intent Servis");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        showToast(intent);
    }

    private void showToast(final Intent intent) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (intent != null) {
                    String value = intent.getStringExtra(Receiver.PARAMETER_KEY);
                    Toast.makeText(ServiceIntent.this, value, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ServiceIntent.this, "Nije dobar PARAMETER_KEY", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
