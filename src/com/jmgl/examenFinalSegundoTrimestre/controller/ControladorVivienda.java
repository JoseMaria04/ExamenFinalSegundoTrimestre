package com.jmgl.examenFinalSegundoTrimestre.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmgl.examenFinalSegundoTrimestre.Utils.ConnectionManager;
import com.jmgl.examenFinalSegundoTrimestre.model.Vivienda;


public class ControladorVivienda {
	/**
	 * 
	 * @return
	 */
	public static List<Vivienda> findAll(int id) {
		List<Vivienda> o = new ArrayList<Vivienda>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from vivienda where idLocalidad =" + id);
			
			while (rs.next()) {
				Vivienda p = new Vivienda();
				p = new Vivienda();
				p.setId(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setIdLocalidad(rs.getInt("idLocalidad"));
				o.add(p);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return o;
	}
}
