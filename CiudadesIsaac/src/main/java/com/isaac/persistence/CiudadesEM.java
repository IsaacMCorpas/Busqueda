package com.isaac.persistence;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isaac.models.Ciudad;

public class CiudadesEM extends EntityManager {
	
	private static CiudadesEM instance = null;

	public static final CiudadesEM getInstance() {
		if (instance == null) {
			instance = new CiudadesEM();
			
		}
		return instance;
		
	}
	
	
	public List<Ciudad> getListaCiudadBusqueda(String name) {
		List<Ciudad> listaCiudad = null;
		try {
			Session session = factory.openSession();
			Transaction t=session.beginTransaction();
			String sql="FROM Ciudad WHERE name LIKE '"+name+"%'";
			listaCiudad=session.createQuery(sql,Ciudad.class).getResultList();
			t.commit();
			session.close();
			
		} catch (Exception e) {
			ManejoException(e);
			
		}
		
		return listaCiudad;
	}
		
	private void ManejoException(Exception e) {
		System.out.println("Ha ocurrido un erro en la entity Manager de Ciudades ::"+e);
		e.printStackTrace();
		
	}
}

