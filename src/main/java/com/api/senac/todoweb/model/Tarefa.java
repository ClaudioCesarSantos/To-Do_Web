package com.api.senac.todoweb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private boolean concluida;
}
