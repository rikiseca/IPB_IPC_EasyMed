package com.example.easymed2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainScreen extends AppCompatActivity {


	ListView list;  // TODO: if enough time switch from ListView to RecyclerView

	ArrayList<pill> pills = new ArrayList<>();

	String[] maintitle = {"Viagra", "Memofante"};
	String[] subtitle = {"Pressão sanguinea", "Memoria"};

	Integer[] imgid = {R.drawable.viagra, R.drawable.memofante};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);

		Intent intent = getIntent();


		/* starts before 1 month from now */
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.MONTH, -1);

		/* ends after 1 month from now */
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.MONTH, 1);

		HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
				.range(startDate, endDate)
				.datesNumberOnScreen(5)
				.build();
		horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
			@Override
			public void onDateSelected(Calendar date, int position) {
				//do something
			}
		});
		/*
		TODO:
		 	- Add hours to Main Screen items
		*/
		MyListView adapter = new MyListView(this, maintitle, subtitle, imgid);
		list = (ListView) findViewById(R.id.PillListView);
		list.setAdapter(adapter);

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 0:
						Toast.makeText(getApplicationContext(), "Tomar Viagra", Toast.LENGTH_SHORT).show();
						setContentView(R.layout.activity_add_reminders_screen);
						break;
					case 1:
						Toast.makeText(getApplicationContext(), "Tomar Memofante", Toast.LENGTH_SHORT).show();
						setContentView(R.layout.activity_add_reminders_screen);
						break;
//					case 2:
//						Toast.makeText(getApplicationContext(), "Tomar Viagra", Toast.LENGTH_SHORT).show();
				}
			}

		});

	}

	public void onAddButtonClick(View view) {
		Intent intent = new Intent(this,addRemindersScreen.class);
		startActivity(intent);
	}

	public void onSettingsClick(View view) {
		Intent intent = new Intent(this, settingsScreen.class);
		startActivity(intent);
	}

}