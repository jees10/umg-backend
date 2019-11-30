package umg.progra2.umg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.progra2.umg.entities.Anuncio;

import java.io.Serializable;

public interface AnuncioRepo extends JpaRepository<Anuncio, Serializable> {
}
