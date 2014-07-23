package net.agsoft.campusvjunio;

import net.agsoft.campusvjunio.base.Campus;
import net.agsoft.campusvjunio.bbdd.BaseDatos;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Nueva_campus extends Activity implements OnClickListener{
	
	BaseDatos bd = new BaseDatos(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_campus);
		
		Button btAceptar = (Button) findViewById(R.id.btAceptarCampus);
        btAceptar.setOnClickListener(this);
        Button btCancelar = (Button) findViewById(R.id.btCancelarCampus);
        btCancelar.setOnClickListener(this);
						
  	  SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
  			boolean desactivarSonido = preferencias.getBoolean("desactivar_sonido", false);
  			
  			if(desactivarSonido){
  				
  				btAceptar.setSoundEffectsEnabled(false);
  			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva_campus, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btAceptarCampus:
			
			EditText etNombre = (EditText) findViewById(R.id.etNombreCampus);
			EditText etCocina = (EditText) findViewById(R.id.etCampusPais);
			EditText etDireccion = (EditText) findViewById(R.id.etOpinionCampus);
			CheckBox cbHasEstado = (CheckBox) findViewById(R.id.cbHasEstado);
			CheckBox cbTicket = (CheckBox) findViewById(R.id.cbTicket);
			CheckBox cbVasIr = (CheckBox) findViewById(R.id.cbVasIr);
			
			
			Campus campus = new Campus();
			campus.setNombre(etNombre.getText().toString());
			campus.setPais(etCocina.getText().toString());
			campus.setOpinion(etDireccion.getText().toString());
			campus.setEstado(Boolean.parseBoolean(cbHasEstado.getText().toString()));
			campus.setTicket(Boolean.parseBoolean(cbTicket.getText().toString()));
			campus.setVasir(Boolean.parseBoolean(cbVasIr.getText().toString()));
			
			bd.nuevaCampus(campus);
			
			Toast.makeText(this, getResources().getString(R.string.confirma_campus_nueva), Toast.LENGTH_SHORT).show();
			break;

		case R.id.btCancelarCampus:
			
			finish();
			
			break;
		
	}

}

}
