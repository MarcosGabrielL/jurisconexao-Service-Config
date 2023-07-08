package br.com.softsaj.configuration.repositories;

 
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.softsaj.configuration.models.Banners;



/**
 *
 * @author Marcos
 */
@Repository
public interface BannersRopository extends JpaRepository<Banners, Long> {
    
     Optional<Banners> findBannerById(Long id);
     
     void deleteBannerById(Long id);
     
     @Query("SELECT u FROM Banners u WHERE u.vendedor = ?1")
     List<Banners> findByEmail(String usuario);
}
