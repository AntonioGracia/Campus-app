package net.agsoft.campusvjunio.base;

import android.os.Parcel;
import android.os.Parcelable;

public class Campus implements Parcelable{
	
	private String nombre;
	private String Pais;
	private String Opinion;
	private boolean Estado;
	private boolean Ticket;
	private boolean vasir;
	
	public Campus(){}
	
	public Campus (Parcel entrada){
		
		this.nombre = entrada.readString();
		this.Pais = entrada.readString();
		this.Opinion = entrada.readString();
		this.Estado = Boolean.parseBoolean(entrada.readString());
		this.Ticket = Boolean.parseBoolean(entrada.readString());
		this.vasir = Boolean.parseBoolean(entrada.readString());
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel destino, int flags) {
		
		destino.writeString(this.nombre);
		destino.writeString(this.Pais);
		destino.writeString(this.Opinion);
		destino.writeString(String.valueOf(this.Estado));
		destino.writeString(String.valueOf(this.Ticket));
		destino.writeString(String.valueOf(this.vasir));
	}
	
	public static final Parcelable.Creator<Campus> CREATOR = new Parcelable.Creator<Campus>() {
		
		public Campus createFromParcel(Parcel in) {
		    return new Campus(in);
		}
		
		public Campus[] newArray(int size) {
		    return new Campus[size];
		}
	};

	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getOpinion() {
		return Opinion;
	}

	public void setOpinion(String opinion) {
		Opinion = opinion;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	public boolean isTicket() {
		return Ticket;
	}

	public void setTicket(boolean ticket) {
		Ticket = ticket;
	}

	public boolean isVasir() {
		return vasir;
	}

	public void setVasir(boolean vasir) {
		this.vasir = vasir;
	}




	
	
}
