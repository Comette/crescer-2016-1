package br.com.rede.pre.dominio.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INTERACAO")
public class Interacao {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_INTERACAO")
    @SequenceGenerator(name = "SEQ_INTERACAO", sequenceName = "SEQ_INTERACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_INTERACAO")
    private Long idInteracao;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name="ID_PUBLICACAO")
    private Publicacao publicacao;
    
    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(name = "TIPO_INTERACAO")    
    private TipoInteracao tipoInteracao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(name = "DT_INTERACAO")
    private Date dtInteracao;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name="ID_USUARIO_AGENTE")
    private Usuario agente;

    public Interacao() {
    }

    public Interacao(Long idInteracao, Publicacao publicacao, TipoInteracao tipoInteracao, Date dtInteracao, Usuario agente) {
        this.idInteracao = idInteracao;
        this.publicacao = publicacao;
        this.tipoInteracao = tipoInteracao;
        this.dtInteracao = dtInteracao;
        this.agente = agente;
    }

    public Long getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(Long idInteracao) {
        this.idInteracao = idInteracao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public TipoInteracao getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(TipoInteracao tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    public Date getDtInteracao() {
        return dtInteracao;
    }

    public void setDtInteracao(Date dtInteracao) {
        this.dtInteracao = dtInteracao;
    }

    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }    
    
}
