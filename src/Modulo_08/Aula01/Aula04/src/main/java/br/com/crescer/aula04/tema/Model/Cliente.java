package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
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

@Entity
@Table(name = "CLIENTE")
//@NamedQueries({
//    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
//    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
//    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
//    @NamedQuery(name = "Cliente.findByRazaosocial", query = "SELECT c FROM Cliente c WHERE c.razaosocial = :razaosocial"),
//    @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco"),
//    @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro"),
//    @NamedQuery(name = "Cliente.findByCep", query = "SELECT c FROM Cliente c WHERE c.cep = :cep"),
//    @NamedQuery(name = "Cliente.findBySituacao", query = "SELECT c FROM Cliente c WHERE c.situacao = :situacao")})
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private long idCliente;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;
    
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Column(name = "BAIRRO")
    private String bairro;
    
    @Column(name = "CEP")
    private Integer cep;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;
    
    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    @ManyToOne
    private Cidade cidade;
    
    public Cliente() {
    }

    public Cliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(long idCliente, String nome, String razaoSocial, Character situacao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.situacao = situacao;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
