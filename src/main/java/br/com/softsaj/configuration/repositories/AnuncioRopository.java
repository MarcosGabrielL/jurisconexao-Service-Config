package br.com.softsaj.configuration.repositories;

 
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.softsaj.configuration.models.Anuncio;



/**
 *
 * @author Marcos
 */
@Repository
public interface AnuncioRopository extends JpaRepository<Anuncio, Long> {
    
     Optional<Anuncio> findAnuncioById(Long id);
     
     void deleteAnuncioById(Long id);
     
     @Query("SELECT u FROM Anuncio u WHERE u.vendedor = ?1")
      List<Anuncio> findByEmail(String usuario);

	boolean existsByVendedor(String vendedor);
}
