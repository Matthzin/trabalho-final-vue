package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.PedidoDAO;
import com.senac.trabalhoweb08122023.entities.ItemPedido;
import com.senac.trabalhoweb08122023.entities.Pedido;
import com.senac.trabalhoweb08122023.entities.enums.StatusPedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoDAO dao;
	
	@Autowired
	private ProdutoService produtoService;

	public List<Pedido> findAll() {
		return dao.findAll();
	}
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj=  dao.findById(id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return dao.save(obj);
	}
	
	public Pedido insert(String cliente) {
		Pedido obj = new Pedido(cliente);
		return dao.save(obj);
	}
	
	public List<Pedido> findPedidosByStatus(Integer status) {
        return dao.findByStatusPedido(status);
    }
	
	public Pedido createPedidoAndInsertItem(ItemPedido item, String cliente) {
        List<Pedido> pedidosAbertos = findPedidosByStatus(1);

        if (pedidosAbertos.isEmpty()) {
            Pedido newPedido = new Pedido(cliente);
            item.setProduto(produtoService.findById(item.getProduto().getId()));
            newPedido.getItens().add(item);
            return dao.save(newPedido);
        } else {
            Pedido existingPedido = pedidosAbertos.get(0);
            item.setProduto(produtoService.findById(item.getProduto().getId()));
            existingPedido.getItens().add(item);
            return dao.save(existingPedido);
        }
    }
	
	private void addProdutoToItem(ItemPedido item) {
        item.setProduto(produtoService.findById(item.getProduto().getId()));
    }
	
}
