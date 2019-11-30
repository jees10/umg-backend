package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Vendedor;

import java.io.Serializable;
import java.util.List;

public interface VendedorRepo extends JpaRepository<Vendedor, Serializable> {

    List<Vendedor> findByCorreoAndAndPassword(String correo, String password);
}
