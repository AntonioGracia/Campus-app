package net.agsoft.campusvjunio.bbdd;

import com.google.android.gms.maps.model.LatLng;

import android.provider.BaseColumns;

public interface Constantes extends BaseColumns {
	
	public static final String TABLA_CAMPUS = "campuses";


	public static final String NOMBRE = "nombre";
	public static final String PAIS = "pais";
	public static final String OPINION = "opinion";
	public static final String ESTADO = "estado";
	public static final String TICKET = "ticket";
	public static final String VASAIR = "vasair";
	public static final LatLng ZARAGOZA = new LatLng(41.654573, 0.882511);

}
