package com.mybringback.intermediate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Numbers extends ActionBarActivity {
	
	EditText number;
	Button sendInfo;
	String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers);
       
        
        sendInfo=(Button)findViewById(R.id.button1);
        
        
        number=(EditText)findViewById(R.id.editText1);
        
        sendInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 s=number.getText().toString();
				 Intent i=getIntent();
				 String msg=i.getStringExtra("numbers");
				 
				 if(msg.contentEquals("width")){
					 i.putExtra("widthInfo", s);
					 setResult(RESULT_OK,i);
					 finish();
				 }
				 if(msg.contentEquals("height")){
					 i.putExtra("heightInfo", s);
					 setResult(RESULT_OK,i);
					 finish();
				 }
				
			}
		});
        
    }

   
}


