package com.jmgl.examenFinalSegundoTrimestre.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jmgl.examenFinalSegundoTrimestre.controller.ControladorInquilino;
import com.jmgl.examenFinalSegundoTrimestre.controller.ControladorLocalidad;
import com.jmgl.examenFinalSegundoTrimestre.controller.ControladorVivienda;
import com.jmgl.examenFinalSegundoTrimestre.model.Inquilino;
import com.jmgl.examenFinalSegundoTrimestre.model.Localidad;
import com.jmgl.examenFinalSegundoTrimestre.model.Vivienda;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfFechaInicio;
	private JTextField jtfFechaFin;
	private JTextField jtfCuota;
	private JTextField jtfDni;
	JComboBox<Localidad> jcbLocalidad;
	JComboBox<Vivienda> jcbVivienda;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JLabel lblNewLabel_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Modificacion de alquileres");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbLocalidad.getSelectedItem() != null) {
		 			Localidad c =(Localidad) jcbLocalidad.getSelectedItem();
		 			cargarVivienda(c.getId());
		 		}
			}
		});
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.weightx = 1.0;
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 1;
		gbc_jcbLocalidad.gridy = 1;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);
		
		JLabel lblNewLabel_2 = new JLabel("Vivienda:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		 jcbVivienda = new JComboBox<Vivienda>();
		 jcbVivienda.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(jcbVivienda.getSelectedItem() != null) {
		 			Vivienda c =(Vivienda) jcbVivienda.getSelectedItem();
		 			cargarInquilino(c.getId());
		 		}
		 	}
		 });
		GridBagConstraints gbc_jcbVivienda = new GridBagConstraints();
		gbc_jcbVivienda.insets = new Insets(0, 0, 5, 0);
		gbc_jcbVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbVivienda.gridx = 1;
		gbc_jcbVivienda.gridy = 2;
		contentPane.add(jcbVivienda, gbc_jcbVivienda);
		
		JLabel lblNewLabel_3 = new JLabel("Datos del inquilino");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 4;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		contentPane.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre Completo:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de inicio:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfFechaInicio = new JTextField();
		GridBagConstraints gbc_jtfFechaInicio = new GridBagConstraints();
		gbc_jtfFechaInicio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaInicio.gridx = 1;
		gbc_jtfFechaInicio.gridy = 7;
		contentPane.add(jtfFechaInicio, gbc_jtfFechaInicio);
		jtfFechaInicio.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					jtfFechaFin.setEnabled(false);
					jtfFechaFin.setText("");
				}
				else {
					jtfFechaFin.setEnabled(true);
			 		Vivienda c =(Vivienda) jcbVivienda.getSelectedItem();
					cargarFechaInquilino(c.getId());
					
				}
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.EAST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 8;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblNewLabel_9 = new JLabel("Alquiler en activo");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 8;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha de fin: ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfFechaFin = new JTextField();
		GridBagConstraints gbc_jtfFechaFin = new GridBagConstraints();
		gbc_jtfFechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFin.gridx = 1;
		gbc_jtfFechaFin.gridy = 9;
		contentPane.add(jtfFechaFin, gbc_jtfFechaFin);
		jtfFechaFin.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Cuota mensual (€): ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 10;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		jtfCuota = new JTextField();
		jtfCuota.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				try {
					if(jtfCuota.getText() != null) {
						lblNewLabel_12.setText("" + (1.21 * (Double.parseDouble(jtfCuota.getText()))));
					}
					else {
						lblNewLabel_12.setText("");
					}
				}catch (NumberFormatException o) {
					
				}
			}
		});

		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 1;
		gbc_jtfCuota.gridy = 10;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		jtfCuota.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Total mensual (IVA incluido) (€):");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 11;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 11;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		contentPane.add(panel, gbc_panel);
		
		JButton jbModificar = new JButton("Modificar");
		jbModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbVivienda.getSelectedItem() != null) {
		 			Vivienda c =(Vivienda) jcbVivienda.getSelectedItem();
		 			modificarInquilino(c.getId());
		 		}
			}
		});
		panel.add(jbModificar);
		
		cargarLocalidad();
		try {
			lblNewLabel_12.setText("" + (1.21 * (Double.parseDouble(jtfCuota.getText()))));
		} catch (NumberFormatException o){
		}
	}
	
	/**
	 * 
	 */
	private void cargarLocalidad() {
		List<Localidad> l = ControladorLocalidad.findAll();
		for (Localidad o : l) {
			this.jcbLocalidad.addItem(o);
		}
	}
	
	/**
	 * 
	 */
	private void cargarVivienda(int id) {
		this.jcbVivienda.removeAllItems();
		List<Vivienda> v = ControladorVivienda.findAll(id);
		for (Vivienda o : v) {
			this.jcbVivienda.addItem(o);
		}
	}
	
	private void cargarInquilino(int id) {
		Inquilino i = ControladorInquilino.findAll(id);
		this.jtfId.setText(" " + i.getId());
		this.jtfDni.setText(i.getDni());
		this.jtfNombre.setText(i.getNombreCompleto());
		this.jtfFechaInicio.setText(sdf.format(i.getFechaInicioAlquiler()));
		if(i.getFechaFinAlquiler()!= null) {
			this.jtfFechaFin.setText(sdf.format(i.getFechaFinAlquiler()));
		}
		else {
			this.jtfFechaFin.setText("");
		}
		this.jtfCuota.setText("" + i.getCuotaMensual());

	}
	
	private void cargarFechaInquilino(int id) {
		Inquilino i = ControladorInquilino.findAll(id);
		if(i.getFechaFinAlquiler()!= null) {
			this.jtfFechaFin.setText(sdf.format(i.getFechaFinAlquiler()));
		}
		else {
			this.jtfFechaFin.setText("");
		}
	}
	
	/**
	 * 
	 */
	private void modificarInquilino(int id) {
		String dni = this.jtfDni.getText();;
		if (dniNoCorrecto(dni)) {
			JOptionPane.showMessageDialog(null, "El Dni no es correcto");			
			return; 
					
		}
		
		String nombre = this.jtfNombre.getText();
		if(nombre.isEmpty() || nombre.isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo nombre esta vacio");			
			return;
		}
		
		
		Inquilino i = ControladorInquilino.findAll(id);
		Inquilino o = new Inquilino();
		
		o.setId(i.getId());
		o.setDni(this.jtfDni.getText());
		o.setNombreCompleto(this.jtfNombre.getText());
		try {
			o.setFechaInicioAlquiler(sdf.parse(this.jtfFechaInicio.getText()));
			if(i.getFechaFinAlquiler()!= null) {
				o.setFechaFinAlquiler(sdf.parse(this.jtfFechaFin.getText()));
			}
			else {
				o.setFechaFinAlquiler(null);;
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "NO HAS PUESTO LA FECHA EN EL FORMATO CORRECTO");			
		}
		
		o.setCuotaMensual(Double.parseDouble(this.jtfCuota.getText()));
		
		if (ControladorInquilino.modificar(o) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");			
		}
	}
	
	private boolean dniNoCorrecto(String dni) {
		String palabras[] = dni.split("[ ]+");
		for (String palabra : palabras) {
			int contadorNumeros = 0, contadorLetra = 0;
			for(int j= 0; j < palabra.length(); j++) {
				if (Character.isDigit(palabra.charAt(j))) {
					contadorNumeros++;
				}
				if(Character.isUpperCase(palabra.charAt(j)) || Character.isLowerCase(palabra.charAt(j)) &&  j == 8) {
					contadorLetra++;
				}
				
				if(contadorNumeros == 8 && contadorLetra == 1) {
					return false;
				}
				
			}
			
		}
		return true;
	}
	
//	private boolean nombreNoCorrecto (String nombre) {
//		
//		String palabras[] = nombre.trim().split("[ ]+");
//		for (String palabra : palabras) {
//			int contadorLetra = 0;
//			for(int j= 0; j < palabra.length(); j++) {
//				if(Character.isUpperCase(palabra.charAt(j)) || Character.isLowerCase(palabra.charAt(j)) ) {
//					contadorLetra++;
//				}
//				
//				if(contadorLetra == 0) {
//					return false;
//				}
//				
//			}
//			
//		}
//		
//		return true;
//	}

}
