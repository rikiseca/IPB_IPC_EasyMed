package com.example.easymed2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);

	}

	public void onContinueClick(View view) {
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}

	public void onHelpClick(View view) {
		Intent intent = new Intent(this, helpScreen.class);
		startActivity(intent);
	}
}