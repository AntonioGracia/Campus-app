package net.agsoft.campusvjunio.bbdd;

import net.agsoft.campusvjunio.base.Campus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static net.agsoft.campusvjunio.bbdd.Constantes.*;
import static android.provider.BaseColumns._ID;

public class BaseDatos extends SQLiteOpenHelper {

	private static final String BASEDATOS_NOMBRE = "campus.db";
	private static final int BASEDATOS_VERSION = 1;
	
	private static String[] FROM_CURSOR = {_ID, NOMBRE, PAIS, OPINION };
	private static String ORDER_BY = NOMBRE + " DESC";
	
	public BaseDatos(Context contexto) {
		super(contexto, BASEDATOS_NOMBRE, null, BASEDATOS_VERSION);
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		

		db.execSQL("CREATE TABLE " + TABLA_CAMPUS + "(" 
				+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
				+ NOMBRE + " TEXT NOT NULL, "
				+ PAIS + " TEXT NOT NULL, "
				+ OPINION + " TEXT NOT NULL, "
				+ ESTADO + " INTEGER NOT NULL, "
				+ TICKET + " INTEGER NOT NULL, "
				+ VASAIR + " INTEGER NOT NULL);");
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_CAMPUS);
		onCreate(db);
	}

	public void nuevaCampus(Campus campus) {
    	
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues valores = new ContentValues();
    	valores.put(NOMBRE, campus.getNombre());
    	valores.put(PAIS, campus.getPais());
    	valores.put(OPINION, campus.getOpinion());
    	valores.put(ESTADO, campus.isEstado());
    	valores.put(TICKET, campus.isTicket());
    	valores.put(VASAIR, campus.isVasir());
    	
    	db.insertOrThrow(TABLA_CAMPUS, null, valores);
    }
    

    public Cursor getCampus() {
    
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	
    	Cursor cursor = db.query(TABLA_CAMPUS, FROM_CURSOR, null, null, null, null, ORDER_BY);
    	
    	return cursor;
    }
}
