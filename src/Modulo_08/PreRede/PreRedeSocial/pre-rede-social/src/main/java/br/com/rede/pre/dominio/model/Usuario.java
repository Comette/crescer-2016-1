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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DT_NASCIMENTO")
    private Date nascimento;    
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    
    @Basic(optional = false)
    @Column(name = "IMG_PERFIL")    
    private String imgPerfil;
    
    @OneToMany(mappedBy = "usuario")
    private List<Relacao> amigos;
    
    @OneToMany(mappedBy = "usuario")
    private List<Publicacao> publicacoes;

    public Usuario() {
    }   
    
    public Usuario(long id, String nome, Date nascimento, String email, String senha, String imgPerfil, List<Relacao> amigos, List<Publicacao> publicacoes) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.senha = senha;
        this.imgPerfil = imgPerfil;
        this.amigos = amigos;
        this.publicacoes = publicacoes;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public List<Relacao> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Relacao> amigos) {
        this.amigos = amigos;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }        
}
