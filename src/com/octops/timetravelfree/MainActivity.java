package com.octops.timetravelfree;
import java.util.Calendar;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;



public class MainActivity extends Activity {
 
	private TextView tvDisplayTime;

	private Button btnChangeTime;
 
	private int hour;
	private int minute;
 
	static final int TIME_DIALOG_ID = 999;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		setCurrentTimeOnView();
		addListenerOnButton();
 
	}
 
	// display current time
	public void setCurrentTimeOnView() {
 
		tvDisplayTime = (TextView) findViewById(R.id.tvTime);

 
		final Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
 
		// set current time into textview
		tvDisplayTime.setText(
                    new StringBuilder().append(pad(hour))
                                       .append(pad(minute)).append(" AD"));
 

 
	}
 
	public void addListenerOnButton() {
 
		btnChangeTime = (Button) findViewById(R.id.btnChangeTime);
 
		btnChangeTime.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				showDialog(TIME_DIALOG_ID);
 
			}
 
		});
 
	}
 
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			// set time picker as current time
			return new TimePickerDialog(this, 
                                        timePickerListener, hour, minute,true);
 
		}
		return null;
	}
 
	private TimePickerDialog.OnTimeSetListener timePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;
 
			// set current time into textview
			tvDisplayTime.setText(new StringBuilder().append(pad(hour))
                    .append(pad(minute)).append(" AD"));
 

 
		}
	};
 
	private static String pad(int c) {
		if (c >= 10)
		   return String.valueOf(c);
		else
		   return "0" + String.valueOf(c);
	}
}