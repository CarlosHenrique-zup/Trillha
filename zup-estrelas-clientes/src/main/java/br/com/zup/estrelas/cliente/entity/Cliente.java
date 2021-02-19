package br.com.zup.estrelas.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cpf;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private int idade;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String endereco;

	public Cliente() {

	}

	public Cliente(Long cpf, String nome, int idade, String email, String telefone, String endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
