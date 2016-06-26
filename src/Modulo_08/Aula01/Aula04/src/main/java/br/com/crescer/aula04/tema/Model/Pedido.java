package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDO")
//@NamedQueries({
//    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
//    @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido"),
//    @NamedQuery(name = "Pedido.findByDatapedido", query = "SELECT p FROM Pedido p WHERE p.datapedido = :datapedido"),
//    @NamedQuery(name = "Pedido.findByDataentrega", query = "SELECT p FROM Pedido p WHERE p.dataentrega = :dataentrega"),
//    @NamedQuery(name = "Pedido.findByValorpedido", query = "SELECT p FROM Pedido p WHERE p.valorpedido = :valorpedido"),
//    @NamedQuery(name = "Pedido.findBySituacao", query = "SELECT p FROM Pedido p WHERE p.situacao = :situacao")})
public class Pedido implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private long idPedido;
    
    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    
    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private BigDecimal valorPedido;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<PedidoItem> itens;

    public Pedido() {
    }

    public Pedido(long idPedido, Date dataPedido, BigDecimal valorPedido, Character situacao) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.situacao = situacao;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }
    
}
