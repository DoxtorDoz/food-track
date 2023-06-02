package com.foodtrack.foodtrack.controladores;

import com.foodtrack.foodtrack.entidades.Dia;
import com.foodtrack.foodtrack.repositorios.DiaRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/dias")
public class DiaController {

    private final DiaRepository diaRepository;

    // Inyecta el repositorio de Dia
    public DiaController(DiaRepository diaRepository) {
        this.diaRepository = diaRepository;
    }

    @GetMapping
    public List<Dia> obtenerTodosLosDias() {
        return diaRepository.findAll();
    }

    @GetMapping("/{diaId}")
    public Dia obtenerDiaPorId(@PathVariable Long diaId) {
        return diaRepository.findById(diaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Día no encontrado"));
    }
}
