package umg.progra2.umg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.progra2.umg.entities.Detalle;
import umg.progra2.umg.repositories.DetalleRepo;

import java.util.List;

@RestController
@RequestMapping("/detalle")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class DetalleController {

    @Autowired
    DetalleRepo detalleRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Detalle detalleSave(@RequestBody() Detalle detalle) {
        return detalleRepo.save(detalle);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Detalle> detalles(){
        return detalleRepo.findAll();
    }

    @RequestMapping(value = "/{iddetalle}",method = RequestMethod.GET)
    public Detalle findById(@PathVariable("iddetalle") int iddetalle) {
        return detalleRepo.findById(iddetalle).get();
    }

    @RequestMapping(value = "/pedido/{idpedido}",method = RequestMethod.GET)
    public List<Detalle> findByIdpedido(@PathVariable("idpedido") int idpedido) {
        return  detalleRepo.findByIdpedido(idpedido);
    }

    @RequestMapping(value = "/{iddetalle}",method = RequestMethod.DELETE)
    public void deleteDetalle(@PathVariable("iddetalle") int iddetalle) {
        detalleRepo.delete(detalleRepo.findById(iddetalle).get());
    }


}
