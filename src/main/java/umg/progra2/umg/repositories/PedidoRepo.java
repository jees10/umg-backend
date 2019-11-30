package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Pedido;

import java.io.Serializable;
import java.util.List;

public interface PedidoRepo extends JpaRepository<Pedido, Serializable> {

    List<Pedido> findByIdvendedor (int idvendedor);
}
