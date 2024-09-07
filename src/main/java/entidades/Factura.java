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
@Table(name = "Factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;

    @Column(name = "numero", unique = true)
    private int numero;

    private int total;

    //Relacion uno a muchos
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Cliente")
    private Cliente cliente;

    //Al ser una composicion, si es unidireccional se trabaja como una relación OneToMany donde la clase del lado One es dueña de la relación
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //CascadeType.ALL porque si yo borro una factura el detalle se debe eliminar
    @Builder.Default
    private List<DetalleFactura> detallefactura = new ArrayList<DetalleFactura>();


}
