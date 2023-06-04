package com.foodtrack.foodtrack.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.foodtrack.foodtrack.entidades.Comida;

import com.foodtrack.foodtrack.entidades.Dia;

import jakarta.transaction.Transactional;

@RepositoryRestResource(path = "dias")
public interface DiaRepository extends JpaRepository<Dia, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas

    @Query("SELECT d FROM Dia d JOIN FETCH d.comidas WHERE d.id = :diaId")
    Dia obtenerDiaConComidas(Long diaId);

    // Obtener todos los días
    List<Dia> findAll();

    // Obtener un día por su identificador
    Optional<Dia> findById(Long id);
}
