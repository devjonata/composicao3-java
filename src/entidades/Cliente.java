package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private String nome;
	private String emial;
	private Date dataDeNascimento;
	
	public Cliente() {
	}

	public Cliente(String nome, String emial, Date dataDeNascimento) {
		this.nome = nome;
		this.emial = emial;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}	

}
