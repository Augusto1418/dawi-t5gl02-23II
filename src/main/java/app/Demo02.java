package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		
		EntityManager em = fabrica.createEntityManager();
		
		String sql = "select p from Producto p";
		List<Producto> lstProducto = em.createQuery(sql,Producto.class).getResultList();
		
		for (Producto p : lstProducto) {
			System.out.println("LISTADO DE PRODUCTO " );
			System.out.println("PRODUCTO : " + p.getId_prod() );
			System.out.println("DESCRIPCION : " + p.getDes_prod() );
			System.out.println("STOCK PRODUCTO : " + p.getStk_prod() );
			System.out.println("PRECIO  : " + p.getPre_prod() );
			System.out.println("CATEGORIA : " + p.getObjCategoria().getDescripcion() );
			System.out.println("ESTADO : " + p.getEst_prod() );
			System.out.println("PROVEEDOR: " + p.getObjProveedor().getNombre_rs());
			System.out.println("------------------------------------------" );

		}
		em.close();
	}
}
