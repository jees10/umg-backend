package umg.progra2.umg.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idtelefono")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtelefono;

    @Column
    private String numero;

    @Column
    private int idvendedor;

    public int getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(int idtelefono) {
        this.idtelefono = idtelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
}
