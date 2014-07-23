package net.agsoft.campusvjunio;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class Preferencias extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		addPreferencesFromResource(R.xml.preferencias);
		
		Toast.makeText(getApplicationContext(), 
				"Reinicia la aplicacion para que se activen los cambios", Toast.LENGTH_LONG).show();
	}

}
