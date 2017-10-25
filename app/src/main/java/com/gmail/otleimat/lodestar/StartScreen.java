package com.gmail.otleimat.lodestar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StartScreen extends AppCompatActivity {
    private BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    private TextView startText;
    private Button BluetoothOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        startText = (TextView) findViewById(R.id.start_text);
        BluetoothOn = (Button) findViewById(R.id.enable_bluetooth);
        BluetoothOn.setVisibility(View.INVISIBLE);
        // Check if bluetooth is available and enabled on the device
        if(bluetooth != null)
        {
            if (bluetooth.isEnabled()) {
                startText.setText("Bluetooth found and is enabled :)");
            }
            else
            {
                // If Bluetooth is not enabled, simply give user option to enable it
                startText.setText("Bluetooth not enabled");
                BluetoothOn.setVisibility(View.VISIBLE);
            }
        }
    }
    public void enableBluetooth(View v){
        // onClick Listener for enabling Bluetooth
        if (bluetooth.enable()){
            BluetoothOn.setVisibility(View.INVISIBLE);
            startText.setText("Bluetooth enabled successfully");
        }
    }
}
