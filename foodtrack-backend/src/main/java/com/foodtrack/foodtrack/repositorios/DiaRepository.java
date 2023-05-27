package com.foodtrack.foodtrack.repositorios;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.foodtrack.foodtrack.entidades.Dia;

public interface DiaRepository extends JpaRepository<Dia, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas
}
