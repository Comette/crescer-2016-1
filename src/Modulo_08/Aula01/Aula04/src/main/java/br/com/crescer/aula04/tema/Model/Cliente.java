package br.com.crescer.aula04.tema.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ID_CLIENTE")
    @SequenceGenerator(name = "SEQ_ID_CLIENTE", sequenceName = "SEQ_ID_CLIENTE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private long idCliente;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;
    
    @Basic(optional = false)
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    
    @OneToOne
    @JoinColumn(name="IDCIDADE")
    private Cidade cidade;
    
    @Basic(optional = false)
    @Column(name = "CEP")
    private long cep;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
    
}
