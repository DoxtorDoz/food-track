package com.foodtrack.foodtrack.repositorios;

import com.foodtrack.foodtrack.entidades.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

    // Obtener todas las comidas de un día específico
    List<Comida> findByDiaId(Long diaId);

    // Obtener todas las comidas de un tipo específico (Desayuno, Comida, Merienda,
    // Cena)
    List<Comida> findByTipo(String tipo);

    // Obtener todas las comidas que contengan un producto específico
    List<Comida> findByAlimentosNombre(String nombreProducto);

    // ...otros métodos personalizados según tus necesidades
}
