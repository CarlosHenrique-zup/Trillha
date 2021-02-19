package br.com.zup.estrelas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.zup.estrelas.entity.ClienteEntity;

public class Cliente {
	
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<ClienteEntity> clienteEntityArray = new ArrayList<>();
	private ClienteEntity cliente = new ClienteEntity();
	private static final String DETALHAMENTO = "==========================================";
	private String nomeCliente = "";
	private int idadeCliente = 0;
	private String enderecoCliente = "";
	private String telefoneCliente = "";
	private String emailCliente = "";
	private String cpfCliente = "";

	public void fimDoPrograma() {
		System.out.println(DETALHAMENTO);
		System.out.println("|             [FIM DO PROGRAMA]          |");
		System.out.println(DETALHAMENTO);
	}

	public void opcaoInvalida() {
		System.out.println(DETALHAMENTO);
		System.out.println("|             [OPÇÃO INVÁLIDA]           |");
		System.out.println(DETALHAMENTO);
	}

	private void setarDadosCliente() {
		cliente.setNome(nomeCliente);
		cliente.setCpf(cpfCliente);
		cliente.setEmail(emailCliente);
		cliente.setEndereco(enderecoCliente);
		cliente.setIdade(idadeCliente);
		cliente.setTelefone(telefoneCliente);
	}

	private void leituraDeDados(ClienteEntity cliente) {
		System.out.printf("\n\nNome: %s", cliente.getNome());
		System.out.printf("\nCpf: %s", cliente.getCpf());
		System.out.printf("\nEndereco: %s", cliente.getEndereco());
		System.out.printf("\nEmail: %s", cliente.getEmail());
	}

	public void insercaoDeDados() {
		System.out.print("NOME: ");
		nomeCliente = sc.next();
		System.out.print("IDADE: ");
		idadeCliente = sc.nextInt();
		System.out.print("EMAIL: ");
		emailCliente = sc.next();
		System.out.print("ENDEREÇO: ");
		enderecoCliente = sc.next();
		System.out.print("TELEFONE: ");
		telefoneCliente = sc.next();
	}

	public void iniciarProjeto() {
		System.out.println();
		System.out.println(DETALHAMENTO);
		System.out.println("|            [CRUD - CLIENTES]           |");
		System.out.println(DETALHAMENTO);
		System.out.println("|                                        |");
		System.out.println("|     [0] - SAIR DO PROGRAMA             |");
		System.out.println("|     [1] - CADASTRAR CLIENTE            |");
		System.out.println("|     [2] - SELECIONAR CLIENTES          |");
		System.out.println("|     [3] - SELECIONAR CLIENTE POR CPF   |");
		System.out.println("|     [4] - ATUALIZAR CLIENTE            |");
		System.out.println("|     [5] - APAGAR CLIENTE               |");
		System.out.println("|                                        |");
		System.out.println(DETALHAMENTO);
		System.out.println();
		System.out.print("ESCOLHA A SUA OPÇÃO: ");
		int opcaoUsuario = sc.nextInt();

		switch (opcaoUsuario) {
		case 1:
			try {
				cadastrarClientes();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}

			break;
		case 2:
			try {
				selecionarTodosClientes();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}

			break;
		case 3:
			try {
				selecionarClientePorCpf();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				atualizarClientePeloCpf();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				deletarClientePeloCpf();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 0:
			System.out.println();
			fimDoPrograma();
			break;
		default:
			System.out.println();
			opcaoInvalida();
			break;
		}

		sc.close();
	}

	private void cadastrarClientes() {
		System.out.println();
		System.out.println(DETALHAMENTO);
		System.out.println("|           [CADASTRAR CLIENTE]          |");
		System.out.println(DETALHAMENTO);
		System.out.println("|               [INFORME]                |");
		System.out.println(DETALHAMENTO);
		System.out.print("CPF: ");
		cpfCliente = sc.next();

		insercaoDeDados();
		setarDadosCliente();

		if (clienteEntityArray.contains(cliente.getCpf())) {
			System.out.println("Cliente com cpf cadastrado!");
			iniciarProjeto();
			return;
		}

		clienteEntityArray.add(cliente);
		System.out.println();
		iniciarProjeto();

	}

	private void selecionarTodosClientes() {
		for (ClienteEntity cliente : clienteEntityArray) {
			if (cliente != null) {
				leituraDeDados(cliente);
			}
		}

		System.out.println();
		iniciarProjeto();
	}

	private void selecionarClientePorCpf() {
		System.out.println();
		System.out.println(DETALHAMENTO);
		System.out.println("|      [SELECIONAR CLIENTE POR CPF]     |");
		System.out.println(DETALHAMENTO);
		System.out.print("INSIRA O CPF DO CLIENTE:");
		cpfCliente = sc.next();

		for (ClienteEntity cliente : clienteEntityArray) {
			if (cliente.getCpf().equals(cpfCliente)) {
				leituraDeDados(cliente);
				iniciarProjeto();

				return;
			}
		}

		System.out.println("CLIENTE NÃO ENCONTRADO!");
		System.out.println();
		iniciarProjeto();
	}

	private void atualizarClientePeloCpf() {
		System.out.println();
		System.out.println(DETALHAMENTO);
		System.out.println("|      [ATUALIZAR CLIENTE PELO CPF]     |");
		System.out.println(DETALHAMENTO);
		System.out.print("INSIRA O CPF DO CLIENTE:");
		cpfCliente = sc.next();

		if (cliente != null && cliente.getCpf().equals(cpfCliente)) {
			insercaoDeDados();
			setarDadosCliente();
		} else {
			System.out.println("CPF NÃO ENCONTRADO!");
		}

		System.out.println();
		iniciarProjeto();
	}

	private void deletarClientePeloCpf() {
		System.out.println();
		System.out.println(DETALHAMENTO);
		System.out.println("|       [DELETAR CLIENTE POR CPF]      |");
		System.out.println(DETALHAMENTO);
		System.out.print("INSIRA O CPF DO CLIENTE:");
		cpfCliente = sc.next();

		int i = 0;

		if (clienteEntityArray.size() > 0) {
			for (ClienteEntity cliente : clienteEntityArray) {

				if (cliente.getCpf().equals(cpfCliente)) {
					clienteEntityArray.remove(i);
					System.out.println("CLIENTE EXCLUÍDO COM SUCESSO!");
					iniciarProjeto();
					return;
				}
				i++;
			}
		}

		System.out.println("CLIENTE NÃO ENCONTRADO!");
		System.out.println();
		iniciarProjeto();
	}
}
