package com.foodtrack.foodtrack.repositorios;

import com.foodtrack.foodtrack.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productos")
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos personalizados si necesitas consultas específicas
}
