package umg.progra2.umg.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Detalle implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddetalle;

    @Column
    private int idpedido;

    @Column
    private int idproducto;

    @Column
    private int cant_producto;

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int idpdetalle) {
        this.iddetalle = iddetalle;
    }

    public int getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(int cant_producto) {
        this.cant_producto = cant_producto;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
}
