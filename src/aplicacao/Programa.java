package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemDePedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.EstadoPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Informe os dados do cliente:");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String emailCliente = sc.nextLine();
		System.out.print("Data de nascimento: ");
		String dataDeNascimento = sc.next();
		
		Cliente cliente = new Cliente(nomeCliente, emailCliente, sdf.parse(dataDeNascimento));
		
		System.out.println("Informe os dados do pedido:");
		System.out.print("Estado do pedido: ");
		String estado = sc.next();
		Date momento = new Date();
		System.out.print("Quantos items para este pedido? ");
		int numeroPedidos = sc.nextInt();
		
		Pedido pedido = new Pedido(momento, EstadoPedido.valueOf(estado));
		
		for (int i=1; i<=numeroPedidos; i++) {
			System.out.println("Informe os dados do " + i + "º item:");
			System.out.print("Nome do produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do produto: ");
			Double precoProduto = sc.nextDouble();
			System.out.print("Quantidade do produto: ");
			Integer quantidadeProduto = sc.nextInt();
			ItemDePedido itemDePedido = new ItemDePedido(quantidadeProduto, precoProduto, new Produto(nomeProduto, precoProduto));
			pedido.adicionarItem(itemDePedido);
		}
		
		System.out.println();
		System.out.println("Resumo do pedido:");
		System.out.println("Data do pedido: " + sdf1.format(pedido.getMomento()));
		System.out.println("Estado do pedido: " + pedido.getEstado());
		System.out.println("Cliente: " + cliente.getNome() + " " + sdf.format(cliente.getDataDeNascimento()) + " - " + cliente.getEmial());
		System.out.println(pedido);
		
		
		
		
		
		
		
		sc.close();
	}

}
