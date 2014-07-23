package net.agsoft.campusvjunio.util;

import java.util.ArrayList;

import net.agsoft.campusvjunio.R;
import net.agsoft.campusvjunio.base.Campus;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CampusAdapter extends BaseAdapter{
	
	private ArrayList<Campus> listaMuchasCampus;
	private ArrayList<Campus> listaActual;
	private LayoutInflater inflater;
	private Context contexto;
	
	static class ViewHolder {

		TextView nombreCampus2;
		TextView paisCampus2;
		TextView opinionCampus2;
	}
	
	public CampusAdapter (Activity contexto, ArrayList<Campus> listaRestaurantes){
		this.contexto = contexto;
		this.listaMuchasCampus = listaRestaurantes;
		listaActual = new ArrayList<Campus>();
		inflater = LayoutInflater.from(contexto);
	}

	public void verFavoritos(){
		
		listaActual.clear();
		for(Campus campus : listaMuchasCampus){
			if(campus.isEstado())
				listaActual.add(campus);
		}
	}
	public void verComidos(){
		
		listaActual.clear();
		for(Campus campus: listaMuchasCampus){
			if(campus.isTicket())
				listaActual.add(campus);
		}
	}
	
	public void verGusta(){
		
		listaActual.clear();
		for(Campus campus: listaMuchasCampus){
			if(campus.isVasir())
				listaActual.add(campus);
		}
	}
	
	public void verTodos(){
		listaActual.clear();
		listaActual.addAll(listaMuchasCampus);
	}
	
	public void eliminar(int posicion){
		listaActual.remove(posicion);
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return listaMuchasCampus.size();
	}

	@Override
	public Object getItem(int posicion) {
		
		return listaMuchasCampus.get(posicion);
	}

	@Override
	public long getItemId(int posicion) {
		// TODO Auto-generated method stub
		return posicion;
	}

	@Override
	public View getView(int posicion, View convertView, ViewGroup padre) {
		ViewHolder holder = null;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.campus, null);
			
			holder = new ViewHolder();
			holder.nombreCampus2 = (TextView) convertView.findViewById(R.id.btNuevaCampusOpinion);
			holder.paisCampus2 = (TextView) convertView.findViewById(R.id.paiscampus2);
			holder.opinionCampus2 = (TextView) convertView.findViewById(R.id.opinioncampus2);
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Campus campus = listaMuchasCampus.get(posicion);
		holder.nombreCampus2 = (TextView) convertView.findViewById(R.id.nombreCampus2);
		holder.paisCampus2 = (TextView) convertView.findViewById(R.id.paiscampus2);
		holder.opinionCampus2 = (TextView) convertView.findViewById(R.id.opinioncampus2);
		
		return convertView;
	}

}
