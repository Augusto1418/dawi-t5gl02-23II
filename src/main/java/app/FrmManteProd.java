package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JLabel lblProveedor;
	private JComboBox cboProveedor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(239, 74, 77, 14);
		contentPane.add(lblProveedor);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(327, 70, 86, 22);
		contentPane.add(cboProveedor);
		
		llenaCombo();
		
		llenaCombo1();
	}

	 void llenaCombo1() {
		
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
			
			EntityManager manager = fabrica.createEntityManager();
			
			String sql = "select p from Proveedor p";
			List<Proveedor> lstProveedores = manager.createQuery(sql,Proveedor.class).getResultList();
			
			cboProveedor.addItem("seleccione...");
			for (Proveedor p : lstProveedores) {
				
				cboProveedor.addItem(p.getNombre_rs());
			}
			
			manager.close();
	}

	void llenaCombo() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		
		EntityManager manager = fabrica.createEntityManager();
		
		String sql = "select c from Categorias c";
		List<Categorias> lstCategorias = manager.createQuery(sql,Categorias.class).getResultList();
		
		cboCategorias.addItem("seleccione...");
		for (Categorias c : lstCategorias) {
			
			cboCategorias.addItem(c.getDescripcion());
		}
		
		manager.close();
	}
	
	void listado() {
		
	
EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		
		EntityManager em = fabrica.createEntityManager();
		
		String sql = "select p from Producto p";
		List<Producto> lstProducto = em.createQuery(sql,Producto.class).getResultList();
		
		for (Producto p : lstProducto) {
			imprimir("LISTADO DE PRODUCTO " );
			imprimir("PRODUCTO : " + p.getId_prod() );
			imprimir("DESCRIPCION : " + p.getDes_prod() );
			imprimir("STOCK PRODUCTO : " + p.getStk_prod() );
			imprimir("PRECIO  : " + p.getPre_prod() );
			imprimir("CATEGORIA : " + p.getObjCategoria().getDescripcion() );
			imprimir("ESTADO : " + p.getEst_prod() );
			imprimir("PROVEEDOR: " + p.getObjProveedor().getNombre_rs());
			imprimir("------------------------------------------" );

		}
		
			em.close();
		
	}
	
	private void imprimir(String s) {
	   txtSalida.append(s + "\n");
		
	}

	void registrar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Practica001");
		EntityManager em = fabrica.createEntityManager();
		
		 String id_prod = txtCódigo.getText().toUpperCase();
		 String des_prod;
		 int stk_prod;
		 double pre_prod;
		
		 int idcategoria;
		 int est_prod;
		 int idproveedor;
		
		 //VALIDACIONES
		 
		 if(id_prod.matches("[P][0-9][4]")) {
			 aviso("FORMATO DE CODIGO NO CORRECTO : P0000");
			 return;
		 }
		 
		 
		Producto p = new Producto();
		p.setId_prod(id_prod);
		p.setDes_prod(txtDescripcion.getText());
		p.setStk_prod(Integer.parseInt(txtStock.getText()));
		p.setPre_prod(Double.parseDouble(txtPrecio.getText()));
		p.setIdcategoria(cboCategorias.getSelectedIndex());
		p.setIdproveedor(cboProveedor.getSelectedIndex());
		p.setEst_prod(1);
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			aviso("registro ok");
			
		}
		catch (PersistenceException e) {
			aviso("ERROR : POR DUPLICADO : " + e.getMessage());
		}
		catch (Exception e) {
			aviso("ocurrio un error : " + e.getMessage());
		}
		em.close();
	}

	void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg,"AVISO",JOptionPane.INFORMATION_MESSAGE);
		
	}
}