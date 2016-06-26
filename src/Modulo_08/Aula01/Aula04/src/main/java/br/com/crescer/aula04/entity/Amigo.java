package br.com.crescer.aula04.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AMIGO")
public class Amigo {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIZADE")
    @SequenceGenerator(name = "SEQ_AMIZADE", sequenceName = "SEQ_AMIZADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_AMIZADE")
    private Long idAmigo;
    
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario; 
    
    @ManyToOne
    @JoinColumn(name="ID_USUARIO_AMIGO")
    private Usuario usuarioAmigo; 
    
    @Basic(optional = false)
    @Column(name = "DT_INICIO_AMIZADE")
    private Date dataInicioAmizade;    
}
