package com.api.senac.todoweb.service;

import com.api.senac.todoweb.model.Tarefa;
import com.api.senac.todoweb.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public void marcarConcluida(Long id) {
        Tarefa tarefa = repository.findById(id).orElseThrow();
        tarefa.setConcluida(true);
        repository.save(tarefa);
    }
}
