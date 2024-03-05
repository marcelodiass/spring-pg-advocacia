package br.com.fiap.springpgadvocacia.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PROCESSO")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(
            name = "SQ_PROCESSO",
            sequenceName = "SQ_PROCESSO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PROCESSO")
    private Long id;

    @Column(name = "NR_PROCESSO")
    private String numero;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ADVOGADO",
            referencedColumnName = "ID_ADVOGADO",
            foreignKey = @ForeignKey(name = "FK_PROCESSO_ADVOGADO")
    )
    private Advogado advogado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TIPO_DE_ACAO",
            referencedColumnName = "ID_TIPO_DE_ACAO",
            foreignKey = @ForeignKey(name = "FK_PROCESSO_TIPO_DE_ACAO")
    )
    private TipoDeAcao tipoDeAcao;

    @Column(name = "PRO_BONO")
    private boolean proBono;

}
