package com.foodtrack.foodtrack.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;

import com.foodtrack.foodtrack.entidades.Comida;
import com.foodtrack.foodtrack.entidades.Dia;
import com.foodtrack.foodtrack.entidades.Producto;
import com.foodtrack.foodtrack.repositorios.ComidaRepository;
import com.foodtrack.foodtrack.repositorios.DiaRepository;
import com.foodtrack.foodtrack.repositorios.ProductoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dias")
public class DiaController {

    private final DiaRepository diaRepository;
    private final ComidaRepository comidaRepository; // Agregar esta línea
    private final ProductoRepository productoRepository;

    // Inyéctalo en el constructor
    public DiaController(DiaRepository diaRepository, ComidaRepository comidaRepository,
            ProductoRepository productoRepository) {
        this.diaRepository = diaRepository;
        this.comidaRepository = comidaRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/todosLosDias")
    public List<Dia> obtenerTodosLosDias() {
        return diaRepository.findAll();
    }

    @PostMapping("/crearDia")
    public Dia crearDia(@RequestBody Dia nuevoDia) {
        if (nuevoDia.getTotalKcal() == null) {
            nuevoDia.setTotalKcal(0.0); // O algún valor predeterminado
        }
        return diaRepository.save(nuevoDia);
    }

    @GetMapping("/{diaId}")
    public Dia obtenerDiaPorId(@PathVariable Long diaId) {
        return diaRepository.findById(diaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Día no encontrado"));
    }

    @PostMapping("/{diaId}/crearComida")
    public Comida crearComida(@PathVariable Long diaId, @RequestBody Comida nuevaComida) {
        Dia dia = diaRepository.findById(diaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Día no encontrado"));

        nuevaComida.setDia(dia);

        // Establecer totalKcal si es null
        if (nuevaComida.getTotalKcal() == null) {
            nuevaComida.setTotalKcal(0.0); // O algún valor predeterminado
        }

        Comida comidaGuardada = comidaRepository.save(nuevaComida);

        // Luego, agrega la Comida al Dia, calcula las calorías totales y guarda el Dia
        dia.setComida(comidaGuardada);
        dia.calcularTotales();
        diaRepository.save(dia);

        // Finalmente, devuelve la Comida guardada
        return comidaGuardada;
    }

    @GetMapping("/{diaId}/comidas")
    public List<Comida> obtenerComidasPorDia(@PathVariable Long diaId) {
        Dia dia = diaRepository.findById(diaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Día no encontrado"));

        return dia.getComidas();
    }
}
