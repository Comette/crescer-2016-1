package br.com.crescer.aula04.tema.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADE")
public class Cidade {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ID_CIDADE")
    @SequenceGenerator(name = "SEQ_ID_CIDADE", sequenceName = "SEQ_ID_CIDADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private long idCidade;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "UF")
    private String UF;

    public long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
    
       
}
