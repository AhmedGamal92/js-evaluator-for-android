package com.evgenii.jsevaluatortests;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CharacterEscape extends Activity {
	
	JsEvaluator mJsEvaluator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character_escape);

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		mJsEvaluator = new JsEvaluator(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.character_escape, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onCharacterEscapeCallFuncitonClicked(View view) {
		final EditText functionText = (EditText) findViewById(R.id.editTextCharacterEscapeJsCode);
		mJsEvaluator.evaluate(functionText.getText().toString());

		final EditText parameterText = (EditText) findViewById(R.id.editTextCharacterEscapeParameter);
		mJsEvaluator.callFunction(new JsCallback() {
			@Override
			public void onResult(final String resultValue) {
				final TextView jsResultTextView = (TextView) findViewById(R.id.textViewCharacterEscapeResult);
				jsResultTextView.setText(String.format("Result: %s",
						resultValue));
			}
		}, "greet", parameterText.getText().toString());
	}

}
