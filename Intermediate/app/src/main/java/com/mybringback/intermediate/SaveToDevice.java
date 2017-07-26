package com.mybringback.intermediate;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SaveToDevice extends Activity implements OnClickListener {

	Button savePic, saveSound;
	EditText filename;
	boolean isSDAvailable=false, isSDWriteable=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.savetodevice);

		savePic = (Button)findViewById(R.id.savePicture);
		saveSound = (Button)findViewById(R.id.saveSound);
		filename = (EditText)findViewById(R.id.filename);
		savePic.setOnClickListener(this);
		saveSound.setOnClickListener(this);

		checkSD();
	}

	private void checkSD() {
		// TODO Auto-generated method stub

		String state = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(state)){
			//write
			isSDAvailable=true;
			isSDWriteable=true;

		}

		else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
			//read only
			isSDAvailable=true;
			isSDWriteable=false;
		}

		else{
			//uh oh
			isSDAvailable=false;
			isSDWriteable=false;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.savePicture:
			File path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			String name=filename.getText().toString();
			File file = new File(path, name+".png");
			saveData(path, file, R.drawable.ball);
			Toast.makeText(SaveToDevice.this, name+".png has been saved into the Pictures directory", Toast.LENGTH_SHORT).show();
			break;
		case R.id.saveSound:
			path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			name=filename.getText().toString();
			file = new File(path, name+".mp4");
			saveData(path, file, R.raw.mysound);
			Toast.makeText(SaveToDevice.this, name+".mp3 has been saved into the music directory", Toast.LENGTH_SHORT).show();
			break;
		


	}

}

	private void saveData(File path, File file, int info) {
		Log.d("pic", "pic");
		if(isSDAvailable&&isSDWriteable){
			
			try {
				path.mkdirs();
				InputStream is= getResources().openRawResource(info);
				OutputStream os;
				os = new FileOutputStream(file);
				byte[] data = new byte[is.available()];
				is.read(data);
				os.write(data);
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
