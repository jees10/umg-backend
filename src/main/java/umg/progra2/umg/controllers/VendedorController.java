package umg.progra2.umg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.progra2.umg.entities.Pedido;
import umg.progra2.umg.entities.Telefono;
import umg.progra2.umg.entities.Vendedor;
import umg.progra2.umg.repositories.PedidoRepo;
import umg.progra2.umg.repositories.TelefonoRepo;
import umg.progra2.umg.repositories.VendedorRepo;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class VendedorController {

    @Autowired
    VendedorRepo vendedorRepo;

    @Autowired
    TelefonoRepo telefonoRepo;

    @Autowired
    PedidoRepo pedidoRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Vendedor saveVendedor(@RequestBody Vendedor vendedor) {

        List<Telefono> telefonos = vendedor.getTelefonos();
        vendedor.setTelefonos(null);
        Vendedor  v = vendedorRepo.save(vendedor);
        for( Telefono t: telefonos) {
            t.setIdvendedor(v.getIdvendedor());
            telefonoRepo.save(t);
        }
        v.setTelefonos(telefonos);
        return  v;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Vendedor> findAll(){
        return vendedorRepo.findAll();
    }

    @RequestMapping(value = "/{idvendedor}",method = RequestMethod.GET)
    public Vendedor getById(@PathVariable("idvendedor") int idvendedor){
        return vendedorRepo.findById(idvendedor).get();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Vendedor Login(Vendedor vendedor) {
        List<Vendedor> vendedorLogin = vendedorRepo.findByCorreoAndAndPassword(vendedor.getCorreo(), vendedor.getPassword());
            if (vendedorLogin.isEmpty()) {
                return null;
            } else {
                for ( Vendedor v: vendedorLogin) {
                    if(v.getEstado() == 0){
                        return null;
                    }
                }
                return vendedorLogin.get(0);
            }
    }

    @RequestMapping(value = "/{idvendedor}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("idvendedor") int idvendedor){
         vendedorRepo.delete(vendedorRepo.findById(idvendedor).get());
    }


}
