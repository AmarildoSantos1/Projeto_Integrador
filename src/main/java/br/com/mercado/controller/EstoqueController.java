package br.com.mercado.controller;

import br.com.mercado.model.Produto;
import br.com.mercado.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarEstoque() {
        return produtoRepository.findAll();
    }

    @GetMapping("/valor-total")
    public double valorTotal() {
        return produtoRepository.findAll()
                .stream()
                .mapToDouble(p -> p.getPrecoCusto() * p.getQuantidadeInicial())
                .sum();
    }

    @GetMapping("/buscar")
    public List<Produto> buscarPorNomeOuCodigo(@RequestParam String termo) {
        return produtoRepository.findAll()
                .stream()
                .filter(p -> p.getNome().contains(termo) || p.getCodigoBarras().contains(termo))
                .toList();
    }
}