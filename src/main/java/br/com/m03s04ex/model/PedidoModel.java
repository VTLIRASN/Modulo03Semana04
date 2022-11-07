package br.com.m03s04ex.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class PedidoModel {

    private Long id;

//    private Date datahoraCadastro;

//    private  Date dataHoraAlteracao;

    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    private ClienteModel cliente;

    @OneToOne
    @JoinColumn(name = "idFormaPagamento", referencedColumnName = "id")
    private FormaPagamentoModel formaPagamentoModel;

    @OneToOne(mappedBy = "pedidoVenda", cascade = CascadeType.ALL)
    private List<ItemPedidoModel> itens = new ArrayList<ItemPedidoModel>();



}
