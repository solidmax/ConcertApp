package com.multimedios.concertapp;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class ProcesandoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_procesando);
		
		loginFacebook();
	}

	private void loginFacebook(){
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
								Intent irHomeActivity = new Intent(getApplicationContext(), HomeActivity.class);
						    	irHomeActivity.putExtra("usuario", user.getName());
						    	startActivity(irHomeActivity);
						    	finish();
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
		getMenuInflater().inflate(R.menu.procesando, menu);
		return true;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		  super.onActivityResult(requestCode, resultCode, data);
		  Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

}
