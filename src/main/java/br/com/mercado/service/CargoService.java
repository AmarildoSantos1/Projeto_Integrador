package br.com.mercado.service;

import br.com.mercado.model.Cargo;
import br.com.mercado.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {
    private CargoRepository repo;

    public Cargo salvar(Cargo obj) {
        return repo.save(obj);
    }

    public List<Cargo> listarTodos() {
        return repo.findAll();
    }

    public Optional<Cargo> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
