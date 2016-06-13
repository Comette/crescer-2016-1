package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOITEM")
//@NamedQueries({
//    @NamedQuery(name = "Pedidoitem.findAll", query = "SELECT p FROM Pedidoitem p"),
//    @NamedQuery(name = "Pedidoitem.findByIdpedidoitem", query = "SELECT p FROM Pedidoitem p WHERE p.idpedidoitem = :idpedidoitem"),
//    @NamedQuery(name = "Pedidoitem.findByQuantidade", query = "SELECT p FROM Pedidoitem p WHERE p.quantidade = :quantidade"),
//    @NamedQuery(name = "Pedidoitem.findByPrecounitario", query = "SELECT p FROM Pedidoitem p WHERE p.precounitario = :precounitario"),
//    @NamedQuery(name = "Pedidoitem.findBySituacao", query = "SELECT p FROM Pedidoitem p WHERE p.situacao = :situacao")})
public class PedidoItem implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private long idPedidoItem;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private long quantidade;
    
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precoUnitario;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
    @ManyToOne(optional = false)
    private Pedido pedido;
    
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne
    private Produto produto;
    

    public PedidoItem() {
    }

    public PedidoItem(long idPedidoItem, long quantidade, BigDecimal precoUnitario, char situacao) {
        this.idPedidoItem = idPedidoItem;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
    }

    public long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
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

}
