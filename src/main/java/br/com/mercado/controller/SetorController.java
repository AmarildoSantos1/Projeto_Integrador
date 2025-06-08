package br.com.mercado.controller;

import br.com.mercado.model.Setor;
import br.com.mercado.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @PostMapping
    public Setor salvar(@RequestBody Setor obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<Setor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable Long id, @RequestBody Setor obj) {
        return service.buscarPorId(id)
                .map(s -> {
                    obj.setId(id);
                    Setor atualizado = service.salvar(obj);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
