package com.mybringback.intermediate;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	Button width, height, calc;
	TextView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Intent i=new Intent(this, Numbers.class);
        width=(Button)findViewById(R.id.button1);
        height=(Button)findViewById(R.id.button2);
        calc=(Button)findViewById(R.id.button3);
        
        area=(TextView)findViewById(R.id.txtArea);
        
        width.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				i.putExtra("numbers", "width" );
				startActivityForResult(i, 1);
			}
		});
        
        height.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				i.putExtra("numbers", "height" );
				startActivityForResult(i, 1);
			}
		});
 
 		calc.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			int a =Integer.valueOf(width.getText().toString());		
			int b =Integer.valueOf(height.getText().toString());	
			
			area.setText(a*b+" sq ft");

		}
	});
    
    
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	if(data.getExtras().containsKey("widthInfo")){
    		width.setText(data.getStringExtra("widthInfo"));
    	}
    	
    	if(data.getExtras().containsKey("heightInfo")){
    		height.setText(data.getStringExtra("heightInfo"));
    	}
    }

   
}
