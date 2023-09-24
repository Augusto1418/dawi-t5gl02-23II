package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		EntityManager em = fabrica.createEntityManager();
		
		
		//private String usr_usua;
		//private String cla_usua;
		String usuario = JOptionPane.showInputDialog("Ingrese usuario : ");
		String clave = JOptionPane.showInputDialog("Clave : ");
		
		String sql = "select r from Usuario r where r.usr_usua = :xusr_usua and r.cla_usua = :xcla_usua";
		
		try {
			Usuario r = em.createQuery(sql,Usuario.class).
					setParameter("xusr_usua", usuario).
					setParameter("xcla_usua", clave).
					getSingleResult();
			JOptionPane.showMessageDialog(null,"BIENVENIDO"+ " "+ r.getNom_usua());
			
			FrmManteProd fr = new FrmManteProd();
			fr.setVisible(true);
			//dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"USUARIO INCORRECTO");
		}
		em.close();
		
	}
}
