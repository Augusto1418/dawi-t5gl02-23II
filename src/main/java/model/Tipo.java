package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipos")

public class Tipo {
	@Id
	private int idtipo;
	private String descripcion;
	
	
	
	
	public Tipo(int idtipo, String descripcion) {
		
		this.idtipo = idtipo;
		this.descripcion = descripcion;
	}
	

	public Tipo() {
		super();
	}

	


	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", descripcion=" + descripcion + "]";
	}



	public int getIdtipo() {
		return idtipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
