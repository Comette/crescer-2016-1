package br.com.crescer.aula04.tema.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ID_PRODUTO")
    @SequenceGenerator(name = "SEQ_ID_PRODUTO", sequenceName = "SEQ_ID_PRODUTO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private long idProduto;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    private Date dataCadastro;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;
    
    @Basic(optional = false)
    @Column(name = "PRECOVENDA")
    private BigDecimal precoVenda;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situcacao;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    public List<PedidoItem> pedidos;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    public List<ProdutoMaterial> materiais;

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

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public char getSitucacao() {
        return situcacao;
    }

    public void setSitucacao(char situcacao) {
        this.situcacao = situcacao;
    }
       
}
