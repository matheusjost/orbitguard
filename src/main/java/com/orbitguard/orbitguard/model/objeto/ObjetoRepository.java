package com.orbitguard.orbitguard.model.objeto;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long> {
    @Query("select o from Objeto o where o.distancia > :distancia order by o.distancia")
    List<Objeto> findByDistanciaGreaterThan(@Param("distancia") double distancia);
    
    @Query("select date_format(o.dataAprox,'%d/%m'), count(*) as count from Objeto o group by o.dataAprox order by o.dataAprox")
    List<Object[]> countByDate();

    Objeto findByNomeAndDataAprox (String nome, Date dataAprox);
}
