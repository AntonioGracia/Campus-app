package net.agsoft.campusvjunio;

import static net.agsoft.campusvjunio.bbdd.Constantes.NOMBRE;
import static net.agsoft.campusvjunio.bbdd.Constantes.OPINION;
import static net.agsoft.campusvjunio.bbdd.Constantes.PAIS;

import net.agsoft.campusvjunio.bbdd.BaseDatos;
import net.agsoft.campusvjunio.util.CampusAdapter;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;

public class CampusActivity extends Activity {
	
	private BaseDatos datos;
	private CampusAdapter adaptador;
	
	private static String[] FROM_SHOW = {NOMBRE, PAIS, OPINION};
	private static int[] TO = {R.id.nombreCampus2, R.id.paiscampus2, R.id.opinioncampus2};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campuses);
		
		cargarLista();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campuses, menu);
		return true;
	}
	
    private void cargarLista() {
	       
        datos = new BaseDatos(this);
        
        verCampus();
    }
    
    
    private void verCampus() {
    	Cursor cursor = datos.getCampus();
   
    }
    
    
    
   
	

}
