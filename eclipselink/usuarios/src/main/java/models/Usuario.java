package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String idUsuarios;
	private String firstName;
	private String lastName;
	private String nickname;
	private Rol rol;
	
	@Override
	public String toString() {
		return "Usuario [idUsuarios=" + idUsuarios + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nickname=" + nickname + ", rol=" + rol + "]";
	}
	@ManyToOne
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
