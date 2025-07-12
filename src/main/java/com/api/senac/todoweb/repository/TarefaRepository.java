package com.api.senac.todoweb.repository;

import com.api.senac.todoweb.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
