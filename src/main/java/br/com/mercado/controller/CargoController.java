package br.com.mercado.controller;

import br.com.mercado.model.Cargo;
import br.com.mercado.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @PostMapping
    public Cargo salvar(@RequestBody Cargo obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<Cargo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody Cargo obj) {
        return service.buscarPorId(id)
                .map(c -> {
                    obj.setId(id);
                    Cargo atualizado = service.salvar(obj);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
