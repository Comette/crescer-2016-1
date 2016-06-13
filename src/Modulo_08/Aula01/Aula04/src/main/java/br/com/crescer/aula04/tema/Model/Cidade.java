package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADE")
//@NamedQueries({
//    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
//    @NamedQuery(name = "Cidade.findByIdcidade", query = "SELECT c FROM Cidade c WHERE c.idcidade = :idcidade"),
//    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome"),
//    @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf")})
public class Cidade implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private long idCidade;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "UF")
    private String uf;

    public Cidade() {
    }

    public Cidade(long idCidade, String nome, String uf) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.uf = uf;
    }

    public long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
