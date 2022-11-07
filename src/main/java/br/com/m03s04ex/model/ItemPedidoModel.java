package br.com.m03s04ex.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Item_Pedido")
public class ItemPedidoModel {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    private ProdutoModel produtoModel;
    
    private int quantidade;

    private double valoeProduto;



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }



    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValoeProduto() {
        return valoeProduto;
    }

    public void setValoeProduto(double valoeProduto) {
        this.valoeProduto = valoeProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoModel that = (ItemPedidoModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}