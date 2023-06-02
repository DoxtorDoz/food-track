package com.foodtrack.foodtrack.repositorios;

import com.foodtrack.foodtrack.entidades.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
    // Puedes agregar métodos personalizados si necesitas consultas específicas
}
