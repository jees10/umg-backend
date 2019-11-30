package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Detalle;

import java.io.Serializable;
import java.util.List;

public interface DetalleRepo extends JpaRepository<Detalle, Serializable> {

    List<Detalle>  findByIdpedido (int idpedido);
}
