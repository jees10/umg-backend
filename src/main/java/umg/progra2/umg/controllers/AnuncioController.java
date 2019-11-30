package umg.progra2.umg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.progra2.umg.entities.Anuncio;
import umg.progra2.umg.repositories.AnuncioRepo;

import java.util.List;

@RestController
@RequestMapping("/anuncio")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class AnuncioController {

    @Autowired
    AnuncioRepo anuncioRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Anuncio anuncioSave(@RequestBody Anuncio anuncio){
        return anuncioRepo.save(anuncio);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Anuncio> anuncios() {
        return anuncioRepo.findAll();
    }

    @RequestMapping(value = "/{idanuncio}",method = RequestMethod.GET)
    public Anuncio getById(@PathVariable("idanuncio") int idanuncio) {
        return anuncioRepo.findById(idanuncio).get();
    }

    @RequestMapping(value = "/{idanuncio}",method = RequestMethod.DELETE)
    public void deleteAnuncio(@PathVariable("idanuncio") int idanuncio) {
        anuncioRepo.delete(anuncioRepo.findById(idanuncio).get());
    }
}
