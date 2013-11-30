package com.multimedios.concertapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity {
	
	private Button boton_ingresar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		boton_ingresar = (Button) findViewById(R.id.btn_login_facebook);
	}
	
	public void loginFacebook(View v){
		boton_ingresar.setClickable(false);
		
		Intent irProcesandoActivity = new Intent(getApplicationContext(), ProcesandoActivity.class);
    	startActivity(irProcesandoActivity);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
