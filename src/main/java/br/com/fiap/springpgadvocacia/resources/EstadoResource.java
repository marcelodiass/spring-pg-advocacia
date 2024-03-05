package br.com.fiap.springpgadvocacia.resources;

import br.com.fiap.springpgadvocacia.entity.Estado;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> findById(@PathVariable(name = "id") Long id) {
        Estado estado = repository.findById( id ).orElse( null );
        if (Objects.isNull( estado )) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( estado );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> persist(@RequestBody Estado estado) {
        Estado saved = repository.save( estado );
        return ResponseEntity.ok( saved );
    }
}
