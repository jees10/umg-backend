package umg.progra2.umg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.progra2.umg.entities.Detalle;
import umg.progra2.umg.entities.Pedido;
import umg.progra2.umg.repositories.DetalleRepo;
import umg.progra2.umg.repositories.PedidoRepo;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class PedidoController {

    @Autowired
    PedidoRepo pedidoRepo;

    @Autowired
    DetalleRepo detalleRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Pedido savePedido(@RequestBody Pedido pedido) {
        List<Detalle> detalles = pedido.getDetalles();
        pedido.setDetalles(null);
        Pedido p = pedidoRepo.save(pedido);

        for(Detalle d: detalles){
            d.setIdpedido(p.getIdpedido());
            detalleRepo.save(d);
        }

        p.setDetalles(detalles);

        return p;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Pedido> findAll() {
        return pedidoRepo.findAll();
    }

    @RequestMapping(value = "/{idpedido}",method = RequestMethod.GET)
    public Pedido findById(@PathVariable("idpedido") int idpedido){
        return pedidoRepo.findById(idpedido).get();
    }

    @RequestMapping(value = "/{idpedido}",method = RequestMethod.DELETE)
    public void deletePedido(@PathVariable("idpedido") int idpedido){
        pedidoRepo.delete(pedidoRepo.findById(idpedido).get());
    }

    @RequestMapping(value = "/vendedor/{idvendedor}",method = RequestMethod.GET)
    public List<Pedido> findByIdvendedor(@PathVariable("idvendedor") int idvendedor) {
        return pedidoRepo.findByIdvendedor(idvendedor);
    }
}
