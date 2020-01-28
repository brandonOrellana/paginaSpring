package com.clase.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.clase.model.Conexion;
import com.clase.model.Usuario;

@Component
public class CreandoConexion {
	@Bean(name="beanUsuario")
	public Usuario getUsuario(){
		return new Usuario();
	}
	
	@Bean(name="beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}
}
