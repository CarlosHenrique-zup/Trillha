package br.com.zup.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private Integer telefone;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String email, Integer idade, String endereco,
			Integer telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return "======================" +
				"\nNome: " + nome + ",\nIdade:  " + idade + ", \nCPF: " + cpf + ",\nEndereço: " + endereco + ",\nTelefone: "
				+ telefone;
	}
}
