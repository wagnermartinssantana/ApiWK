package br.com.apiwk.models;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class Estado {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String estado;
	
	//@OneToMany
	//private List<Pessoa> pessoa;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

/*	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
*/

}
