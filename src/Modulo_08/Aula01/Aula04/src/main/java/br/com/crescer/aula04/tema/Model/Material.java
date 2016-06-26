package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity
@Table(name = "MATERIAL")
//@NamedQueries({
//    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
//    @NamedQuery(name = "Material.findByIdmaterial", query = "SELECT m FROM Material m WHERE m.idmaterial = :idmaterial"),
//    @NamedQuery(name = "Material.findByDescricao", query = "SELECT m FROM Material m WHERE m.descricao = :descricao"),
//    @NamedQuery(name = "Material.findByPesoliquido", query = "SELECT m FROM Material m WHERE m.pesoliquido = :pesoliquido"),
//    @NamedQuery(name = "Material.findByPrecocusto", query = "SELECT m FROM Material m WHERE m.precocusto = :precocusto")})
public class Material implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private long idMaterial;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private long pesoLiquido;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private List<ProdutoMaterial> produtos;

    public Material() {
    }

    public Material(long idMaterial, String descricao, long pesoLiquido, BigDecimal precoCusto) {
        this.idMaterial = idMaterial;
        this.descricao = descricao;
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
    }

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

    public long getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(long pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public List<ProdutoMaterial> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoMaterial> produtos) {
        this.produtos = produtos;
    }

}
