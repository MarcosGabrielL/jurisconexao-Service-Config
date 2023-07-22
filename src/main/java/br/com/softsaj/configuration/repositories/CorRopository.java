package br.com.softsaj.configuration.repositories;

 
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.softsaj.configuration.models.Cor;



/**
 *
 * @author Marcos
 */
@Repository
public interface CorRopository extends JpaRepository<Cor, Long> {
    
     Optional<Cor> findCorById(Long id);
     
     //@Query("Exists (select u FROM Cor u WHERE u.vendedor = ?1)")
     boolean existsByVendedor(String vendedor);
     
     void deleteCorById(Long id);
     
     @Query("SELECT u FROM Cor u WHERE u.vendedor = ?1")
      List<Cor> findByVendedor(String usuario);
}
