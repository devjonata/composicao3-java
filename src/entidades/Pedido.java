package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.EstadoPedido;

public class Pedido {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private EstadoPedido estado;
	private List<ItemDePedido> items = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Date momento, EstadoPedido estado) {
		this.momento = momento;
		this.estado = estado;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public List<ItemDePedido> getItens() {
		return items;
	}
	
	public void adicionarItem(ItemDePedido item) {
		items.add(item);
	}
	
	public void removerItem(ItemDePedido item) {
		items.remove(item);
	}
	
	public Double total() {
		Double soma = 0.0;
		for (ItemDePedido p : items) {
			soma += p.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Items do pedido:\n");
		for (ItemDePedido i : items) {
			sb.append(i.getProduto().getNome() + ", $" + String.format("%.2f",i.getProduto().getPreco()) + ", Quantidade: " + i.getQuantidade() + ", Subtotal: " + String.format("%.2f",i.subTotal()) + "\n");
		}
		sb.append("Preço total: " + String.format("%.2f", total()));
		return sb.toString();
	}
	
	

}
