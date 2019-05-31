package GUI;


import colaso.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class VentanaCajero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSimulacion;
	private JLabel[] usuarios = new JLabel[10]; 
	private int users;
	private Cola cola1;

	public VentanaCajero() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null,
				new Color(64, 64, 64), null), "Menu", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelMenu.setBounds(10, 11, 134, 399);
		
		panelSimulacion = new JPanel();
		panelSimulacion.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelSimulacion.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, 
				new Color(64, 64, 64), null), "Tablero de Servicios", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelSimulacion.setBounds(154, 11, 530, 399);
		panelSimulacion.setLayout(new GridLayout(4, 4, 10, 10));
		contentPane.add(panelSimulacion);
		cola1=new Cola();
		//Agrego usuario label 
		for(int i=0;i<5;i++) {
			Agregar("Usuario: "+(i+1), (int)((Math.random()*8)+1), i);
			setUsers(5);
		}
		cola1.imprimir();
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String servicios = JOptionPane.showInputDialog("Introduzca el número de Servicios:");
				Agregar("Usuario: "+(getUsers()+1),Integer.valueOf(servicios),getUsers());
				System.out.println(getUsers());
				cola1.insertar(Integer.valueOf(servicios),"Usuario: "+(getUsers()+1));
				setUsers(getUsers()+1);
				
			}
		});
		btnAgregar.setBounds(10, 291, 114, 23);
		btnAgregar.setVisible(false);
		panelMenu.add(btnAgregar); 
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(!cola1.vacia()){
					int serviciosTemp;
					String nombreTemp;
					nombreTemp=cola1.getRaiz().getNombre();
					serviciosTemp=cola1.getRaiz().getServicios();
			        if(serviciosTemp>3){
			            cola1.insertar(serviciosTemp-3,nombreTemp);
			            cola1.extraer();
			            Simulacion(cola1,getUsers());
			        }
			        else{
			        	cola1.insertar(0,nombreTemp);
			            cola1.extraer();
			            Simulacion(cola1,getUsers());			            
			        }  
		            cola1.imprimir();
			    } 
				
			}
		});
		btnSimular.setBounds(10, 218, 114, 23);
		panelMenu.add(btnSimular);
		
		JButton btnAcercaDe = new JButton("Acerca De");
		btnAcercaDe.setBounds(10, 365, 114, 23);
		btnAcercaDe.setVisible(false);
		panelMenu.add(btnAcercaDe);
		
		JLabel lblCajero = new JLabel("Cajero");
		panelMenu.add(lblCajero);
		lblCajero.setBounds(10,28,114,111);
		ImageIcon i_label = new ImageIcon(getClass().getResource("/Imagenes/cajero.png"));
		Icon icono1 = new ImageIcon(i_label.getImage().getScaledInstance(lblCajero.getWidth(),
				lblCajero.getHeight(), Image.SCALE_DEFAULT));
		lblCajero.setIcon(icono1);
	
	}




public void Agregar(String nombreUsuario, int servicios,int i) {
	
		usuarios[i] = new JLabel();  
		usuarios[i].setText(nombreUsuario+" Svs: "+ servicios);
		usuarios[i].setBounds(120,21,100,100);
		ImageIcon i_label2 = new ImageIcon(getClass().getResource("/Imagenes/usuario.jpg"));
		Icon icono2 = new ImageIcon(i_label2.getImage().getScaledInstance(usuarios[i].getWidth(),
				getUsuarios()[i].getHeight(), Image.SCALE_DEFAULT));
		usuarios[i].setIcon(icono2);
		cola1.insertar(servicios,"Usuario: "+(i+1));
		panelSimulacion.add(usuarios[i]);
		 
 }


public void Simulacion(Cola cola,int atras) {
	if(!cola.vacia()) {
		Nodo aux= cola.getRaiz();
		for(int i=0;i<atras;i++) {
			getUsuarios()[i].setText(aux.getNombre()+" Svs: "+ aux.getServicios());
			aux=aux.getSiguiente();
		}
	}
}


public JLabel[] getUsuarios() {
	return usuarios;
}


public void setUsuarios(JLabel[] usuarios) {
	this.usuarios = usuarios;
}


public Cola getCola1() {
	return cola1;
}




public void setCola1(Cola cola1) {
	this.cola1 = cola1;
}




public JPanel getPanelSimulacion() {
	return panelSimulacion;
}




public void setPanelSimulacion(JPanel panelSimulacion) {
	this.panelSimulacion = panelSimulacion;
}




public int getUsers() {
	return users;
}




public void setUsers(int users) {
	this.users = users;
}




}
