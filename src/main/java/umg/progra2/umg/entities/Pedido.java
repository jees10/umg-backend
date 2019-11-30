package umg.progra2.umg.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpedido;

    @Column
    private String nombre_pedido;

    @Column
    private float monto;

    @Column
    private String entrega;

    @Column
    private int idvendedor;

    /*
     *RELATIONS
     */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "idpedido")
    private List<Detalle> detalles;

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getNombre_pedido() {
        return nombre_pedido;
    }

    public void setNombre_pedido(String nombrre_pedido) {
        this.nombre_pedido = nombrre_pedido;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
}
