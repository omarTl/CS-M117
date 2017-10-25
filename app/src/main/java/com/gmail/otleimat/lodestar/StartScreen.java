package com.gmail.otleimat.lodestar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class StartScreen extends AppCompatActivity {
    private BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        final Button BluetoothOn = (Button) findViewById(R.id.enable_bluetooth);
        final TextView startText = (TextView) findViewById(R.id.start_text);
        // Check if bluetooth is available and enabled on the device
        if(bluetooth != null)
        {
            if (bluetooth.isEnabled()) {
                viewFlipper.showNext();
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
            viewFlipper.showNext();
        }
    }
    public void victim(View v){

    }
    public void firstResponder(View v){

    }
}
