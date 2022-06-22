package com.example.easymed2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class settingsScreen extends AppCompatActivity {

	/*
	Settings screen for EasyMed
	TODO:
		- Set lock(4digit pin)
		- Set music path
	 */

	ListView list;

	String[] maintitle = {"PIN"};
	String[] subtitle = {"Inserir pin de segurança"};

	Integer[] imgid = {R.drawable.lock_2};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings_screen);

		Intent intent = getIntent();

		MyListView adapter = new MyListView(this, maintitle, subtitle, imgid);
		list = (ListView) findViewById(R.id.SettingsList);
		list.setAdapter(adapter);

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 0:
						Toast.makeText(getApplicationContext(), "Inserir codigo", Toast.LENGTH_SHORT).show();
						setContentView(R.layout.activity_code_screen);
						break;
					case 1:
						Toast.makeText(getApplicationContext(), "Tomar Memofante", Toast.LENGTH_SHORT).show();
						setContentView(R.layout.activity_add_reminders_screen);
						break;
				//case 2:
					//Toast.makeText(getApplicationContext(), "Tomar Viagra", Toast.LENGTH_SHORT).show();
				}
			}

		});
	}
}