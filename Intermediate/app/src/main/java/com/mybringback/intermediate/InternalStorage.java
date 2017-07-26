package com.mybringback.intermediate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InternalStorage extends Activity{
	Button save;
	EditText name, entry;
	String filename, journal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internal);
		
		name=(EditText)findViewById(R.id.etName);
		entry=(EditText)findViewById(R.id.etEntry);
		save=(Button)findViewById(R.id.btnSave);
		
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				filename=name.getText().toString();
				if(filename.contentEquals("")){
					filename="Untitled";
				}
				journal=entry.getText().toString();

				try {
					FileOutputStream fos=openFileOutput(filename, Context.MODE_PRIVATE);
					fos.write(journal.getBytes());
					fos.close();
					Toast.makeText(InternalStorage.this, "Journal entry saved!", Toast.LENGTH_SHORT).show();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
