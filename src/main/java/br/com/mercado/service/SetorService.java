package br.com.mercado.service;

import br.com.mercado.model.Setor;
import br.com.mercado.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SetorService {
    private SetorRepository repo;

    public Setor salvar(Setor obj) {
        return repo.save(obj);
    }

    public List<Setor> listarTodos() {
        return repo.findAll();
    }

    public Optional<Setor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
