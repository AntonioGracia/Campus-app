package net.agsoft.campusvjunio;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabsListener implements ActionBar.TabListener{
	
	private Fragment fragmento;
	
	public TabsListener(Fragment fragmento){
		this.fragmento = fragmento;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		ft.replace(R.id.contenedor, fragmento);
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragmento);
		
	}
	


}
