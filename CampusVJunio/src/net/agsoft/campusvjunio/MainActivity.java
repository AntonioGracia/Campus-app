package net.agsoft.campusvjunio;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState);
		setContentView(R.layout.activity_main);
		cargaPestanas();
		cargarPreferencias();
	}
	
	private void cargaPestanas() {
	    	
	    	Resources res = getResources();
	        
	        ActionBar actionBar = getActionBar();
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	        
	        ActionBar.Tab tab1 = actionBar.newTab().setText(res.getString(R.string.lista_campus));
	        ActionBar.Tab tab2 = actionBar.newTab().setText(res.getString(R.string.tab_derecha));
	        
	        Fragment fragmentoTab1 = new ListaMuchasCampus();
	        Fragment fragmentoTab2 = new Tab2();
	        
	        tab1.setTabListener(new TabsListener(fragmentoTab1));
	        tab2.setTabListener(new TabsListener(fragmentoTab2));
	        
	        actionBar.addTab(tab1);
	        actionBar.addTab(tab2);
	        

	        
	 }
	 

	 private void cargarPreferencias(){
		 
		  SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);

			boolean desactivarBienvenida = preferencias.getBoolean("desactivar_bienvenida", true);

			if(desactivarBienvenida){
				
			Toast.makeText(getApplicationContext(), "Bienvenido a la aplicacion de los campus", Toast.LENGTH_LONG).show();
			}
	   
			
			boolean cambiarFondo = preferencias.getBoolean("cambiar_fondo", false);
			
			if(cambiarFondo){
			
			RelativeLayout realativeMenu = (RelativeLayout) findViewById(R.id.contenedor);
				
			realativeMenu.setBackgroundColor(Color.BLUE);
			
			}
	 }

	 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent = null;
		
		switch (item.getItemId()) {	
		
			case R.id.menu_nueva_campus:
				intent = new Intent(this, Nueva_campus.class);
				startActivity(intent);
				
				return true;
			case R.id.menu_preferencias:
				
				intent = new Intent(this, Preferencias.class);
				startActivity(intent);
				
				return true;
			case R.id.menu_about:
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage(R.string.acerca_de_message)
						.setIcon(R.drawable.ic_launcher)
						.setTitle(R.string.acerca_de_title)
						.setPositiveButton(R.string.btaceptar_label, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();						
							}
						});
				AlertDialog dialogo = builder.create();
				dialogo.show();
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}
