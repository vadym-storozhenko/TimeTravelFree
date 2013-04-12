package com.octops.timetravelfree;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.CustomDigitalClock;
import android.widget.TextView;

public class MainActivity extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

final CustomDigitalClock dc = (CustomDigitalClock) findViewById(R.id.fragment_clock_digital);
dc.setText(dc.getText().toString());
final TextView tv=(TextView) findViewById(R.id.textView1);



dc.setClickable(true);
dc.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
// TODO Auto-generated method stub
tv.setText(dc.getText().toString());
tv.setTextColor(Color.RED);
}
});
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.activity_main, menu);
return true;
}
}