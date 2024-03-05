package br.com.fiap.springpgadvocacia.resources;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/advogado")
public class AdvogadoResource {

    @Autowired
    private AdvogadoRepository repository;

    @GetMapping
    public List<Advogado> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Advogado> findById(@PathVariable(name = "id") Long id) {
        Advogado advogado = repository.findById( id ).orElse( null );
        if (Objects.isNull( advogado )) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( advogado );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Advogado> persist(@RequestBody Advogado advogado) {
        Advogado saved = repository.save( advogado );
        return ResponseEntity.ok( saved );
    }

}