package br.com.mercado.service;

import br.com.mercado.model.Produto;
import br.com.mercado.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private ProdutoRepository repo;

    public Produto salvar(Produto obj) {
        return repo.save(obj);
    }

    public List<Produto> listarTodos() {
        return repo.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
