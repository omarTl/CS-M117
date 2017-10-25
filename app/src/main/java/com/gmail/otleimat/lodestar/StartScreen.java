package com.gmail.otleimat.lodestar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.widget.TextView;


public class StartScreen extends AppCompatActivity {
    private BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        // Check if bluetooth is available and enabled on the device
        if(bluetooth != null)
        {
            if (bluetooth.isEnabled()) {
                // Bluetooth Found
                // Do something cool here
            }
            else
            {
                // Bluetooth is not enabled
                // Use cellular?
            }
        }
    }
}
