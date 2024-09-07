package entidades;


import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apellido;
    private String nombre;

    @Column(name = "dni", unique = true )   //De esta manera nos aseguramos de que dni sea único.
    private int dni;

    //Relacion OneToOne Unidireccional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    //Relacion ManyToOne bidireccional
    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private List<Factura> factura = new ArrayList<>();



}
