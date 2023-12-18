package com.senac.trabalhoweb08122023.entities.enums;

public enum StatusPedido {
	ABERTO(1),
	CONFIRMADO(2),
	PAGO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private Integer code;
	
	private StatusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusPedido valueOf(int code) {
		for (StatusPedido value : StatusPedido.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código Status Pedido inválido");
	}
}
