package br.com.mercado.service;

import br.com.mercado.model.CategoriaProduto;
import br.com.mercado.repository.CategoriaProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaProdutoService {
    private CategoriaProdutoRepository repo;

    public CategoriaProduto salvar(CategoriaProduto obj) {
        return repo.save(obj);
    }

    public List<CategoriaProduto> listarTodos() {
        return repo.findAll();
    }

    public Optional<CategoriaProduto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
