package com.jmgl.examenFinalSegundoTrimestre.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jmgl.examenFinalSegundoTrimestre.Utils.ConnectionManager;
import com.jmgl.examenFinalSegundoTrimestre.model.Inquilino;


public class ControladorInquilino {
	/**
	 * 
	 * @return
	 */
	public static Inquilino findAll(int id) {
		Inquilino p = new Inquilino();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Inquilino where idVivienda =" + id);
			
			while (rs.next()) {
				p = new Inquilino();
				p.setId(rs.getInt("id"));
				p.setDni(rs.getString("dni"));
				p.setNombreCompleto(rs.getString("nombreCompleto"));
				p.setFechaInicioAlquiler(rs.getDate("fechaInicioAlquiler"));
				p.setFechaFinAlquiler(rs.getDate("fechaFinAlquiler"));
				p.setCuotaMensual(rs.getDouble("cuotaMensual"));
				p.setIdVivienda(rs.getInt("idVivienda"));
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return p;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Inquilino m) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update examenfinalsegundotrimestre.inquilino set dni = ?, nombreCompleto = ?, "
				  + "fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ? where id = ?");
		
			ps.setString(1, m.getDni());
			ps.setString(2, m.getNombreCompleto());
			ps.setDate(3, new java.sql.Date(m.getFechaInicioAlquiler().getTime()));
			if(m.getFechaFinAlquiler() != null) {
				ps.setDate(4, new java.sql.Date(m.getFechaFinAlquiler().getTime()));
			}
			else {
				ps.setDate(4, null);
			}
			ps.setDouble(5, m.getCuotaMensual());
			ps.setInt(6, m.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			
		}catch (NullPointerException e) {
		
		}
		
		return 0;
	}
}
