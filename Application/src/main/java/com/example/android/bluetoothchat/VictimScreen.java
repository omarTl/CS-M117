package com.example.android.bluetoothchat;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.renderscript.Sampler;
import android.support.annotation.BoolRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

import com.example.android.common.activities.SampleActivityBase;

/**
 * Created by omart on 12/3/2017.
 */

public class VictimScreen extends SampleActivityBase {

    private FragmentTransaction transaction;
    private VictimChat fragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victim_layout);
        if (savedInstanceState == null) {
            transaction = getSupportFragmentManager().beginTransaction();
            fragment = new VictimChat();
            fragment.setType("Victim");
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }
}
