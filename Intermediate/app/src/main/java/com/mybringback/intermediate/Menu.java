package com.mybringback.intermediate;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends Activity implements OnClickListener{

	String activities[]={"MAINACTIVITY", "SETTINGS", "INTERNALSTORAGE", "READING", "SAVETOSD"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}

	public void onClick( View v){
		int id = v.getId();
		for (int i = 0; i < activities.length; i++) {
			if (id == getResources().getIdentifier("b" + i, "id",
					"com.mybringback.intermediate")) {
				Intent intent = new Intent("com.mybringback.intermediate."
						+ activities[i]);
				startActivity(intent);
			}

		}
	}

}
