package com.example.easymed2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.dpro.widgets.OnWeekdaysChangeListener;
import com.dpro.widgets.WeekdaysPicker;

import java.util.List;

public class addRemindersScreen extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_reminders_screen);

		WeekdaysPicker widget = (WeekdaysPicker) findViewById(R.id.weekdays_picker);
		widget.setOnWeekdaysChangeListener(new OnWeekdaysChangeListener() {
			@Override
			public void onChange(View view, int clickedDayOfWeek, List<Integer> selectedDays) {
				// Do Something
				System.out.println("It doesn't blow up");
			}
		});

		Spinner spinner_days_per = (Spinner) findViewById(R.id.spinner_days_per);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner_days_per.setAdapter(adapter);

		Intent intent = getIntent();

		//TODO: get number of times per day from spinner and divide it by 24
	}

	public void onCancelClick(View view) {
		Intent intent = new Intent(this, MainScreen.class);
		Toast.makeText(this, "Lembrete não guardado", Toast.LENGTH_SHORT).show();
		startActivity(intent);
	}

	public void onApplyClick(View view) {
		Intent intent = new Intent(this, MainScreen.class);
		Toast.makeText(this, "Lembrete guardado com sucesso", Toast.LENGTH_SHORT).show();
		startActivity(intent);
	}

}