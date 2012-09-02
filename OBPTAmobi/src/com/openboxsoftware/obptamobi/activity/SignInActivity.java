package com.openboxsoftware.obptamobi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.listener.OnCancelClickListener;
import com.openboxsoftware.obptamobi.listener.OnRememberCheckChangedListener;
import com.openboxsoftware.obptamobi.listener.OnSignInClickListener;

public class SignInActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        
	     // Add listeners to views
		Button signInButton = (Button)findViewById(R.id.button_sign_in);
		signInButton.setOnClickListener(new OnSignInClickListener(this));
		
		Button cancelButton = (Button)findViewById(R.id.button_cancel);
		cancelButton.setOnClickListener(new OnCancelClickListener(this));
		
		CheckBox rememberCheckBox = (CheckBox)findViewById(R.id.check_box_remember);
		rememberCheckBox.setOnCheckedChangeListener(new OnRememberCheckChangedListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sign_in, menu);
        return true;
    }
}
