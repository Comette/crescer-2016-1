package br.com.crescer.aula04.tema.Model;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
public class Material {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ID_MATERIAL")
    @SequenceGenerator(name = "SEQ_ID_MATERIAL", sequenceName = "SEQ_ID_MATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private long idMaterial;

    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private double pesoLiquido;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;

    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    
}
