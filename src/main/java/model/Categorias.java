package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categorias")

public class Categorias {
	
	@Id
	private int idcategoria;
	private String descripcion;
	
	public Categorias(int idcategoria, String descripcion) {
		
		this.idcategoria = idcategoria;
		this.descripcion = descripcion;
	}

	
	public Categorias() {
		super();
	}


	public int getIdcategoria() {
		return idcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
