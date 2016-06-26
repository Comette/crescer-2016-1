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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
//@NamedQueries({
//    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
//    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
//    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
//    @NamedQuery(name = "Produto.findByDatacadastro", query = "SELECT p FROM Produto p WHERE p.datacadastro = :datacadastro"),
//    @NamedQuery(name = "Produto.findByPrecocusto", query = "SELECT p FROM Produto p WHERE p.precocusto = :precocusto"),
//    @NamedQuery(name = "Produto.findByPrecovenda", query = "SELECT p FROM Produto p WHERE p.precovenda = :precovenda"),
//    @NamedQuery(name = "Produto.findBySituacao", query = "SELECT p FROM Produto p WHERE p.situacao = :situacao")})
public class Produto implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private long idProduto;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;
    
    @Column(name = "PRECOVENDA")
    private BigDecimal precoVenda;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @OneToMany(mappedBy = "produto")
    private List<PedidoItem> pedidos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ProdutoMaterial> materiais;
    

    public Produto() {
    }

    public Produto(long idProduto, String nome, Date dataCadastro, BigDecimal precoCusto, Character situacao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.precoCusto = precoCusto;
        this.situacao = situacao;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecovenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public List<PedidoItem> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoItem> pedidos) {
        this.pedidos = pedidos;
    }

    public List<ProdutoMaterial> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<ProdutoMaterial> materiais) {
        this.materiais = materiais;
    }
}
