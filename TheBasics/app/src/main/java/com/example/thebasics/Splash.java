package com.example.thebasics;


import com.example.thebasics.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends ActionBarActivity {

	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ourSong=MediaPlayer.create(Splash.this, R.raw.tutorialsplashscreen);
		ourSong.start();
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(2000);	
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent openMainActivity=new Intent("com.mybringback.thebasics.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		
		timer.start();
	}
	
	
	@Override
	protected void onPause(){
		super.onPause();
		ourSong.stop();
		finish();
	}
	
}
