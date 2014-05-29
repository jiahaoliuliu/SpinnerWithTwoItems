package com.jiahaoliuliu.spinnerwithtwoitems;

import com.jiahaoliuliu.spinnerwithtwoitems.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner simpleSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		simpleSpinner = (Spinner)findViewById(R.id.simpleSpinner);
	}
}