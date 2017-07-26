package com.mybringback.intermediate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Settings extends Activity {
	CheckBox cb;
	EditText et;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		

		cb=(CheckBox)findViewById(R.id.checkBox1);
		et=(EditText)findViewById(R.id.editText);
		b=(Button)findViewById(R.id.button1);

		cb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				savePrefs("CHECKBOX", cb.isChecked());


			}
		});

		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(cb.isChecked())
				{
					savePrefs("NAME", et.getText().toString());
					Toast.makeText(Settings.this, "settings saved!", Toast.LENGTH_SHORT).show();
				}
				
			}
			
		});
		loadPrefs();
	}

	private void loadPrefs(){
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		boolean cbValue=sp.getBoolean("CHECKBOX", false);
		String etValue=sp.getString("NAME", "Your Name ");
		
		if(cbValue){
			cb.setChecked(true);
		}
		else{
			cb.setChecked(false);
		}
		et.setText(etValue);
	}

	private void savePrefs(String key, boolean value){
			SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
			Editor edit=sp.edit();
			edit.putBoolean(key, value);
			edit.commit();
	}

	private void savePrefs(String key, String value){
		
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit=sp.edit();
		edit.putString(key, value);
		edit.commit();

	}
}
