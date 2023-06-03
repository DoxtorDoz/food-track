package com.foodtrack.foodtrack.controladores;

import com.foodtrack.foodtrack.entidades.Comida;
import com.foodtrack.foodtrack.repositorios.ComidaRepository;
import com.foodtrack.foodtrack.repositorios.ProductoRepository;
import com.foodtrack.foodtrack.entidades.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    private final ComidaRepository comidaRepository;
    private final ProductoRepository productoRepository;

    // Inyecta el repositorio de Comida
    public ComidaController(ComidaRepository comidaRepository, ProductoRepository productoRepository) {
        this.comidaRepository = comidaRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/{comidaId}")
    public Comida obtenerDetallesComida(@PathVariable Long comidaId) {
        return comidaRepository.findById(comidaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comida no encontrada"));
    }

    @PostMapping("/crearComida")
    public Comida crearComida(@RequestBody Comida nuevaComida) {
        // Agregar lógica adicional si es necesario antes de guardar la comida
        // Asociar los productos a la comida
        List<Producto> productos = nuevaComida.getAlimentos();
        for (Producto producto : productos) {
            producto.setComida(nuevaComida);
        }
        // Guardar la comida en la base de datos
        return comidaRepository.save(nuevaComida);
    }

}
