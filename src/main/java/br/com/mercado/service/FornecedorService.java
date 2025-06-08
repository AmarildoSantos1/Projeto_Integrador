package br.com.mercado.service;

import br.com.mercado.model.Fornecedor;
import br.com.mercado.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private FornecedorRepository repo;

    public Fornecedor salvar(Fornecedor obj) {
        return repo.save(obj);
    }

    public List<Fornecedor> listarTodos() {
        return repo.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
