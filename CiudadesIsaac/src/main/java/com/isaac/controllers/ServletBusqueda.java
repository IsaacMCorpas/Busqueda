package com.isaac.controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.isaac.models.Ciudad;
import com.isaac.persistence.CiudadesEM;

@WebServlet("/buscador")
public class ServletBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		request.getRequestDispatcher("buscador.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String name=request.getParameter("city");
		
		System.out.println("Nombre de la ciudad a mostrar"+name);
		
		List<Ciudad> ciudades= CiudadesEM.getInstance().getListaCiudadBusqueda(name);
		System.out.println("Lista de ciudades a cargar"+ciudades);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter stringCity = new StringWriter();
		
		objectMapper.writeValue(stringCity, ciudades);
		
		System.out.println("Datos enviados"+stringCity.toString());
		
		response.setContentType("application/json");
		response.getWriter().append(stringCity.toString()).flush();
		
		
		
	}

}
