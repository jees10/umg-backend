package umg.progra2.umg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.progra2.umg.entities.Detalle;
import umg.progra2.umg.entities.Producto;
import umg.progra2.umg.repositories.DetalleRepo;
import umg.progra2.umg.repositories.ProductoRepo;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    DetalleRepo detalleRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Producto productoSave(@RequestBody Producto producto) {
        Producto p = productoRepo.save(producto);
        return  p;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Producto> productos() {
        return productoRepo.findAll();
    }

    @RequestMapping(value = "/{idproducto}",method = RequestMethod.GET)
    public Producto findById(@PathVariable("idproducto") int idproducto){
        return productoRepo.findById(idproducto).get();
    }

    @RequestMapping(value = "/{idproducto}",method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable("idproducto") int idproducto) {
        productoRepo.delete(productoRepo.findById(idproducto).get());
    }
}
