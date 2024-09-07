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
@Table(name = "Articulo")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;

    @Column(name = "denominacion", unique = true)
    private String denominacion;

    private int precio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //Generamos la tabla de relacion entre las entidades
    @JoinTable(name = "Articulo_Categoría", joinColumns = @JoinColumn(name = "Articulo_id"), inverseJoinColumns = @JoinColumn(name = "Categoria_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<Categoria>();
}
