package com.multimedios.concertapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.facebook.*;
import com.facebook.model.*;

import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//start Facebook Login
		Session.openActiveSession(this, true, new Session.StatusCallback(){
			
			//callback when session changes state
			@Override
			public void call(Session session, SessionState state, Exception exception){
				if(session.isOpened()){
					//make request to the /me API
					Request.newMeRequest(session, new Request.GraphUserCallback() {
						
						//callback after Graph API response with user object
						@Override
						public void onCompleted(GraphUser user, Response response) {
							// TODO Auto-generated method stub
							if(user!=null){
								TextView welcome = (TextView) findViewById(R.id.welcome);
								welcome.setText("Bienvenido a Concert App " + user.getName() + "!");
							}
						}
					}).executeAsync();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		  super.onActivityResult(requestCode, resultCode, data);
		  Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
		}

}
