package umg.progra2.umg.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Anuncio implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idanuncio;

    @Lob
    @Column(name = "imagen_anuncio",length = 100000)
    private String imagen_anuncio;

    @Column
    private String texto;

    public int getIdanuncio() {
        return idanuncio;
    }

    public void setIdanuncio(int idanuncio) {
        this.idanuncio = idanuncio;
    }

    public String getImagen_anuncio() {
        return imagen_anuncio;
    }

    public void setImagen_anuncio(String imagen_anuncio) {
        this.imagen_anuncio = imagen_anuncio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
