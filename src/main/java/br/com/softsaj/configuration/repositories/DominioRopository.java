package br.com.softsaj.configuration.repositories;

 
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.softsaj.configuration.models.Dominio;




/**
 *
 * @author Marcos
 */
@Repository
public interface DominioRopository extends JpaRepository<Dominio, Long> {
    
     Optional<Dominio> findDominioById(Long id);
     
     void deleteDominioById(Long id);
     
     @Query("SELECT u FROM Dominio u WHERE u.vendedor = ?1")
      List<Dominio> findByEmail(String usuario);
}
