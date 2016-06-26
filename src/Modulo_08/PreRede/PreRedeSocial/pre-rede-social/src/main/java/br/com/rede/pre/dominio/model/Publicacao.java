package br.com.rede.pre.dominio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PUBLICACAO")
public class Publicacao implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    private Long idPublicacao;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;
    
    @Basic(optional = false)
    @Column(name = "IMG_PUBLICACAO")    
    private String imgPublicacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(name = "DT_PUBLICACAO")
    private Date dtPublicacao;
    
    @OneToMany(mappedBy = "publicacao")
    private List<Interacao> interacoes;

    public Publicacao() {
    }

    public Publicacao(Long idPublicacao, Usuario usuario, String imgPublicacao, Date dtPublicacao, List<Interacao> interacoes) {
        this.idPublicacao = idPublicacao;
        this.usuario = usuario;
        this.imgPublicacao = imgPublicacao;
        this.dtPublicacao = dtPublicacao;
        this.interacoes = interacoes;
    }

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getImgPublicacao() {
        return imgPublicacao;
    }

    public void setImgPublicacao(String imgPublicacao) {
        this.imgPublicacao = imgPublicacao;
    }

    public Date getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(Date dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public List<Interacao> getInteracoes() {
        return interacoes;
    }

    public void setInteracoes(List<Interacao> interacoes) {
        this.interacoes = interacoes;
    }
}
