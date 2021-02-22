package br.com.zup.principal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.zup.dao.ClienteDAO;
import br.com.zup.pojo.Cliente;

public class ProgramaPrincipal {

	private static ClienteDAO clienteDAO = new ClienteDAO();

	public static final String PULALINHA = "\n";
	public static final String OPCAOINVALIDA = "OPÇÃO INVÁLIDA!";
	public static final String DETALHAMENTO = "============================================";

	public static void menuCliente() {
		System.out.println("============================================");
		System.out.println("|               CLIENTE CRUD			   |");
		System.out.println("============================================");
		System.out.println("|            [ESCOLHA UMA OPÇÃO]           |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|       [1] - CADASTRAR CLIENTE            |");
		System.out.println("|       [2] - CONSULTAR CLIENTE PELO ID    |");
		System.out.println("|       [3] - CONSULTAR TODOS OS CLIENTES  |");
		System.out.println("|       [4] - ATUALIZAR CLIENTE            |");
		System.out.println("|       [5] - REMOVER CLIENTE              |");
		System.out.println("|       [0] - SAIR DO PROGRAMA             |");
		System.out.println("|                                          |");
		System.out.println("============================================");
	}

	public static void cadastrarNovoCliente(Scanner sc) throws SQLException {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|             [CADASTRAR CLIENTE]          |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.print("INSIRA O NOME DO CLIENTE: ");
		String nome = sc.next();
		System.out.print("INSIRA O CPF DO CLIENTE: ");
		String cpf = sc.next();
		System.out.print("INSIRA O EMAIL DO CLIENTE: ");
		String email = sc.next();
		System.out.print("INSIRA A IDADE DO CLIENTE: ");
		int idade = sc.nextInt();
		System.out.print("INSIRA O ENDEREÇO DO CLIENTE: ");
		String endereco = sc.next();
		System.out.print("INSIRA O TELEFONE DO CLIENTE: ");
		Integer telefone = sc.nextInt();

		clienteDAO.cadastrarNovoCliente(new Cliente(nome, cpf, email, idade, endereco, telefone));
	}

	public static void consultarClientePeloId(Scanner sc) {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|       [CONSULTAR CLIENTE PELO ID]        |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O ID DO CLIENTE: ");
		Long idCliente = sc.nextLong();

		System.out.println(clienteDAO.consultaClientePeloId(idCliente));
	}

	public static void consultarTodosOsClientes(Scanner sc) {
		List<Cliente> clientes = clienteDAO.consultaTodosOsClientes();
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|        [CONSULTAR TODOS OS CLIENTES]     |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		for (Cliente clienteConsultado : clientes) {
			System.out.println(clienteConsultado);
		}
	}

	public static void atualizarCliente(Scanner sc) {
		System.out.println(PULALINHA);
		System.out.println("============================================");
		System.out.println("|            [ATUALIZAR CLIENTE]           |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.println("USUÁRIO: ");
		System.out.print("INSIRA O ID DO CLIENTE QUE DESEJA  ALTERAR: ");
		Long idCliente = sc.nextLong();
		System.out.print("INSIRA O NOME DO CLIENTE: ");
		String nome = sc.next();
		System.out.print("INSIRA O CPF DO CLIENTE: ");
		String cpf = sc.next();
		System.out.print("INSIRA O EMAIL DO CLIENTE: ");
		String email = sc.next();
		System.out.print("INSIRA A IDADE DO CLIENTE: ");
		Integer idade = sc.nextInt();
		System.out.print("INSIRA O ENDEREÇO DO CLIENTE: ");
		String endereco = sc.next();
		System.out.print("INSIRA O TELEFONE DO CLIENTE: ");
		Integer telefone = sc.nextInt();
		
		Cliente cliente = new Cliente(nome, cpf, email, idade, endereco, telefone);

		clienteDAO.atualizarCliente(cliente,idCliente);
	}

	public static void removerCliente(Scanner sc) {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|         [REMOVER CLIENTE PELO ID] 	   |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O ID DO CLIENTE: ");
		Long idCliente = sc.nextLong();

		clienteDAO.removerCliente(idCliente);
	}

	public static void finalDoPrograma() {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|             [FIM DO PROGRAMA]            |");
		System.out.println("============================================");
	}

	public static void opcaoInvalida() {
		System.out.println(PULALINHA);
		System.out.println("===========================================");
		System.out.println("|            [OPÇÃO INVÁLIDA]             |");
		System.out.println("===========================================");
	}

	public static void main(String[] args) throws SQLException, IOException {

		Scanner sc = new Scanner(System.in);
		int opcaoUsuario;

		do {
			menuCliente();
			System.out.print("DIGITE UMA OPÇÃO: ");
			opcaoUsuario = sc.nextInt();
			System.out.println(DETALHAMENTO);
			switch (opcaoUsuario) {
			case 1:
				try {
					cadastrarNovoCliente(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					consultarClientePeloId(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					consultarTodosOsClientes(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					atualizarCliente(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					removerCliente(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0:
				break;
			default:
				opcaoInvalida();
			}
		} while (opcaoUsuario != 0);

		finalDoPrograma();

		sc.close();
	}
}
