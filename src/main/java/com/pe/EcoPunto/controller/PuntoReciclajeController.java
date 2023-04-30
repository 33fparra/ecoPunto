package com.pe.EcoPunto.controller;

import com.pe.EcoPunto.entity.PuntoReciclaje;
import com.pe.EcoPunto.repository.PuntoReciclajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/puntoReciclaje")
public class PuntoReciclajeController
{
    @Autowired
    private PuntoReciclajeRepository puntoReciclajeRepository;

    @GetMapping("listar")
    public ResponseEntity<?> listarPuntosReciclajes()
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(puntoReciclajeRepository.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, por favor intente más tarde");
        }
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<?> listarPuntoReciclaje(@PathVariable("id") long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(puntoReciclajeRepository.findById(id).orElse(null));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, por favor intente más tarde");
        }
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guardarPuntoReciclaje(@RequestBody PuntoReciclaje puntoReciclaje)
    {
        try
        {
            if (puntoReciclaje == null || (puntoReciclaje.getId() != null && !puntoReciclajeRepository.existsById(puntoReciclaje.getId())))
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede guardar un Punto Reciclaje existente o no válido!");
            }

            puntoReciclajeRepository.save(puntoReciclaje);
            return ResponseEntity.status(HttpStatus.OK).body("Se guardo correctamente!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al guardar!");
        }
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> actualizarReciclaje(@RequestBody PuntoReciclaje puntoReciclaje, @PathVariable("id") long id)
    {
        try
        {
            if (!puntoReciclajeRepository.existsById(id))
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el punto reciclaje!");
            }

            puntoReciclajeRepository.save(puntoReciclaje);
            return ResponseEntity.status(HttpStatus.OK).body("Se actualizo correctamente!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al actualizar!");
        }

    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarReciclaje(@PathVariable("id") long id)
    {
        try
        {
            if (!puntoReciclajeRepository.existsById(id))
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el punto reciclaje!");
            }

            puntoReciclajeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error al eliminar!");
        }
    }
}
