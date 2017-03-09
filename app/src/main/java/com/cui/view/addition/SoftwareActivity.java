package com.cui.view.addition;


import com.cui.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SoftwareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_of_software);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.version_of_software, menu);
        return true;
    }
    
}
