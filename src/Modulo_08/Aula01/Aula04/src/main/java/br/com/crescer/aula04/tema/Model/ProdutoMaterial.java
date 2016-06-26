package br.com.crescer.aula04.tema.Model;

import java.io.Serializable;
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
@Table(name = "PRODUTOMATERIAL")
//@NamedQueries({
//    @NamedQuery(name = "Produtomaterial.findAll", query = "SELECT p FROM Produtomaterial p"),
//    @NamedQuery(name = "Produtomaterial.findByIdprodutomaterial", query = "SELECT p FROM Produtomaterial p WHERE p.idprodutomaterial = :idprodutomaterial"),
//    @NamedQuery(name = "Produtomaterial.findByQuantidade", query = "SELECT p FROM Produtomaterial p WHERE p.quantidade = :quantidade")})
public class ProdutoMaterial implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private long idProdutoMaterial;
    
    @Column(name = "QUANTIDADE")
    private long quantidade;
    
    @JoinColumn(name = "IDMATERIAL", referencedColumnName = "IDMATERIAL")
    @ManyToOne(optional = false)
    private Material material;
    
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne(optional = false)
    private Produto produto;
    
    public ProdutoMaterial() {
    }

    public long getIdProdutoMaterial() {
        return idProdutoMaterial;
    }

    public void setIdprodutoMaterial(long idProdutoMaterial) {
        this.idProdutoMaterial = idProdutoMaterial;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
