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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

import com.foodtrack.foodtrack.entidades.Comida;
import com.foodtrack.foodtrack.entidades.Producto;
import com.foodtrack.foodtrack.repositorios.ComidaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dias")
public class DiaController {

    private final DiaRepository diaRepository;
    private final ComidaRepository comidaRepository; // Agregar esta línea

    public DiaController(DiaRepository diaRepository, ComidaRepository comidaRepository) { // Modificar el constructor
        this.diaRepository = diaRepository;
        this.comidaRepository = comidaRepository; // Agregar esta línea
    }

    @GetMapping("/todosLosDias")
    public List<Dia> obtenerTodosLosDias() {
        return diaRepository.findAll();
    }

    @PostMapping("/crearDia")
    public Dia crearDia(@RequestBody Dia nuevoDia) {
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

        List<Producto> productos = nuevaComida.getAlimentos();
        for (Producto producto : productos) {
            producto.setComida(nuevaComida);
        }
        return comidaRepository.save(nuevaComida);
    }

    @PutMapping("/{diaId}/actualizarComida/{comidaId}")
    public Comida actualizarComida(@PathVariable Long diaId, @PathVariable Long comidaId,
            @RequestBody Comida nuevaComida) {
        Dia dia = diaRepository.findById(diaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Día no encontrado"));

        Comida comidaExistente = comidaRepository.findById(comidaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comida no encontrada"));

        // Actualizar los campos de la comida existente con los valores de nuevaComida
        // Aquí asumimos que los campos que quieres actualizar están en nuevaComida
        comidaExistente.setTipoComida(nuevaComida.getTipoComida());
        comidaExistente.setTotalCalorias(nuevaComida.getTotalCalorias());

        // También puedes actualizar la lista de productos si necesitas hacerlo
        List<Producto> productos = nuevaComida.getAlimentos();
        for (Producto producto : productos) {
            producto.setComida(comidaExistente);
        }
        comidaExistente.setAlimentos(productos);

        // Finalmente, guarda la comida existente con los nuevos valores en la base de
        // datos
        return comidaRepository.saveAndFlush(comidaExistente);
    }

}
