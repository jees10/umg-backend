package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Telefono;

import java.io.Serializable;
import java.util.List;

public interface TelefonoRepo extends JpaRepository<Telefono, Serializable> {

    List<Telefono> findByIdvendedor (int idvendedor);
}
