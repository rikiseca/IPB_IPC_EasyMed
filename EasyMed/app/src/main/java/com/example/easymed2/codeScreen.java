package com.example.easymed2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

// TODO: get values from clicks and limit them to 4, this could later be changed for a 6 or 8 digit's code with another setting

public class codeScreen extends AppCompatActivity {
	public int codeLenght = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code_screen);
	}

	public void onNumberClick(View view) {
		if (codeLenght == 3) {
			codeLenght += 1;
			// exit screen
			Toast.makeText(this, "Código aceite", Toast.LENGTH_SHORT).show();
		} else {
			codeLenght += 1;
		}
	}

}