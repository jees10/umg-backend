package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Producto;

import java.io.Serializable;
import java.util.List;

public interface ProductoRepo extends JpaRepository<Producto, Serializable> {

}
