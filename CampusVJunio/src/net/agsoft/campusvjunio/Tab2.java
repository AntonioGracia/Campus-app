package net.agsoft.campusvjunio;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab2 extends Fragment implements OnClickListener{
	
	View view;
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
	    	   
	        super.onCreate(savedInstanceState);
	        
	        view = inflater.inflate(R.layout.activity_tab2, container, false);
	        
	        Button btAceptar = (Button) view.findViewById(R.id.btVerMapa);
	        btAceptar.setOnClickListener(this);
	        
	       
	        Button nuevaCampus = (Button) view.findViewById(R.id.btNuevaCampusOpinion);
	        nuevaCampus.setOnClickListener(this);
	        
	        return view;
	        
	        
	    }

	@Override
	public void onClick(View v) {

		switch(v.getId()){
		case R.id.btVerMapa:
			Intent a = new Intent(this.getActivity(), Mapa.class);
			startActivity(a);
			break;
		
			
		case R.id.btNuevaCampusOpinion:
			Intent c = new Intent(this.getActivity(), Nueva_campus.class);
			startActivity(c);	
		}
		
	}


}
