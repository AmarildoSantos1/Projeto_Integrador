package br.com.mercado.controller;

import br.com.mercado.model.CategoriaProduto;
import br.com.mercado.service.CategoriaProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaProdutoController {

    private final CategoriaProdutoService service;

    @PostMapping
    public CategoriaProduto salvar(@RequestBody CategoriaProduto obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> atualizar(@PathVariable Long id, @RequestBody CategoriaProduto obj) {
        return service.buscarPorId(id)
                .map(c -> {
                    obj.setId(id);
                    CategoriaProduto atualizado = service.salvar(obj);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
