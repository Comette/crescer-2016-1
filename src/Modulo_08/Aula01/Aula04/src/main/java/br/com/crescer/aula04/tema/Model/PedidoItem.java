package br.com.crescer.aula04.tema.Model;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ID_PEDIDO_ITEM")
    @SequenceGenerator(name = "SEQ_ID_PEDIDO_ITEM", sequenceName = "SEQ_ID_PEDIDO_ITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private long idPedidoItem;
    
    @OneToOne
    @JoinColumn(name="IDPEDIDO")
    private Pedido pedido;
    
    @OneToOne
    @JoinColumn(name="IDPRODUTO")
    private Produto produto;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private long quantidade;

    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precoUnitario;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    public long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
