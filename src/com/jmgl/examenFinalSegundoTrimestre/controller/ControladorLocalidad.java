package com.jmgl.examenFinalSegundoTrimestre.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.examenFinalSegundoTrimestre.Utils.ConnectionManager;
import com.jmgl.examenFinalSegundoTrimestre.model.Localidad;


public class ControladorLocalidad {
	/**
	 * 
	 * @return
	 */
	public static List<Localidad> findAll() {
		List<Localidad> o = new ArrayList<Localidad>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from localidad");
			
			while (rs.next()) {
				Localidad p = new Localidad();
				p = new Localidad();
				p.setId(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				o.add(p);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return o;
	}
}
