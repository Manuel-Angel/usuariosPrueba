package main;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.*;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "usuarios";
	  private static EntityManagerFactory factory;
	  private static EntityManager em;
	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	     
	    
	    em.getTransaction().begin();
	    Rol rol = new Rol();
	    rol.setNombre("administrador");
	    rol.setDescripcion("Permisos de lectura y escritura");
	    em.persist(rol);
	    em.getTransaction().commit();
	    
	    //read the existing entries and write to console
	    Query q = em.createQuery("SELECT t FROM Rol t");
	    List<Rol> todoList = q.getResultList();
	    for (Rol todo : todoList) {
	    	System.out.println(todo);
	    }
	    System.out.println("Size: " + todoList.size());
	    
	    agregaUsuario(rol, "Manuel", "Muñoz", "manuel123");
	    agregaUsuario(rol, "Angelica", "Muñoz", "angiel123");
	    
	    q = em.createQuery("SELECT t FROM Usuario t");
	    List<Usuario> usuarios = q.getResultList();
	    for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	    System.out.println("Size: " +usuarios.size());

	    em.close();
	}
	public static void agregaUsuario(Rol rol, String nombre, String apellido, String nick){
		em.getTransaction().begin();
		Usuario user= new Usuario();
		user.setFirstName(nombre);
		user.setLastName(apellido);
		user.setNickname(nick);
		user.setRol(rol);
		em.persist(user);
	    em.getTransaction().commit();
	}

}
