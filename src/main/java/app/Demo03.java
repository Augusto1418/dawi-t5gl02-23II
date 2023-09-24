package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		EntityManager em = fabrica.createEntityManager();
		
		int tipo=1;
		String sql = "select u from Usuario u where u.idtipo=:xtipo";
		List<Usuario> lstUsuarios = em.createQuery(sql,Usuario.class).setParameter("xtipo",tipo).getResultList();
		
		    System.out.println("-------LISTADO DE USUARIOS-------");
		
		for (Usuario u : lstUsuarios) {
			System.out.println("CODIGO : " + u.getCod_usua());
			System.out.println("NOMBRE : " + u.getNom_usua()+" "+ u.getApe_usua());
			System.out.println("TIPO  ... : " + u.getIdtipo()+"-"+ u.getObjTipo().getDescripcion());
			System.out.println("---------------------------------");
		}
	}
}
