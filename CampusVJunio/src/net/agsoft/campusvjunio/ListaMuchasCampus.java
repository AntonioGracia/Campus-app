package net.agsoft.campusvjunio;



import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;



import java.util.ArrayList;

import net.agsoft.campusvjunio.base.Campus;
import net.agsoft.campusvjunio.bbdd.BaseDatos;
import net.agsoft.campusvjunio.util.CampusAdapter;

import static net.agsoft.campusvjunio.bbdd.Constantes.*;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class ListaMuchasCampus extends Fragment {
	
	private CampusAdapter adaptador;
	private SimpleCursorAdapter adaptador3;
	private BaseDatos datos;
	
	private static String[] FROM_SHOW = {NOMBRE, PAIS, OPINION };
	private static int[] TO = {R.id.nombreCampus2, R.id.paiscampus2, R.id.opinioncampus2};
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		datos = new BaseDatos(this.getActivity().getApplicationContext());
		
		view = inflater.inflate(R.layout.lista_campuses, container, false);
		
		ListView lvListaCampuses = (ListView) view.findViewById(R.id.lvListaCampuses);
	
		
		return view;
	}
	
	 public void cargarLista(){
		 datos = new BaseDatos(this.getActivity());
		 verCampus();
	 }
	 
	 public void verCampus(){
		 Cursor cursor = datos.getCampus();
		 this.cargarCampus(cursor);
	 }
	 
	 public void cargarCampus (Cursor cursor){
		 SimpleCursorAdapter adaptador2 = new SimpleCursorAdapter(
				 this.getActivity(), R.layout.campus, cursor, FROM_SHOW, TO,SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		 ((ListView) view.findViewById(R.id.lvListaCampuses)).setAdapter(adaptador2);
	 }

	@Override
	public void onResume() {
		super.onResume();
		
		cargarLista();
		
		
	}

}

