package br.com.rede.pre.dominio.model;

import java.io.Serializable;
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

@Entity
@Table(name = "RELACAO")
public class Relacao implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_RELACAO")
    @SequenceGenerator(name = "SEQ_RELACAO", sequenceName = "SEQ_RELACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_RELACAO")
    private Long idRelacao;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario; 
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name="ID_USUARIO_RELACIONADO")
    private Usuario usuarioRelacionado;
    
    @Enumerated(EnumType.ORDINAL)
    @Basic(optional = false)
    @Column(name = "TIPO_RELACAO")    
    private TipoRelacao tipoRelacao;

    public Relacao() {
    }    
    
    public Relacao(Long idRelacao, Usuario usuario, Usuario usuarioRelacionado, TipoRelacao tipoRelacao) {
        this.idRelacao = idRelacao;
        this.usuario = usuario;
        this.usuarioRelacionado = usuarioRelacionado;
        this.tipoRelacao = tipoRelacao;
    }    

    public Long getIdRelacao() {
        return idRelacao;
    }

    public void setIdRelacao(Long idRelacao) {
        this.idRelacao = idRelacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioRelacionado() {
        return usuarioRelacionado;
    }

    public void setUsuarioRelacionado(Usuario usuarioRelacionado) {
        this.usuarioRelacionado = usuarioRelacionado;
    }

    public TipoRelacao getTipoRelacao() {
        return tipoRelacao;
    }

    public void setTipoRelacao(TipoRelacao tipoRelacao) {
        this.tipoRelacao = tipoRelacao;
    }
}
