package com.foodtrack.foodtrack.repositorios;

import com.foodtrack.foodtrack.entidades.Comida;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(path = "comidas")
@Transactional
public interface ComidaRepository extends JpaRepository<Comida, Long> {

    List<Comida> findByDia_Id(Long diaId);

    List<Comida> findByAlimentosNombre(String nombreProducto);

}
