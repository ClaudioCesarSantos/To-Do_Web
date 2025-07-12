package com.api.senac.todoweb.controller;

import com.api.senac.todoweb.model.Tarefa;
import com.api.senac.todoweb.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tarefas", service.listarTodas());
        return "index"; // nome da sua view HTML
    }

    @PostMapping
    public String adicionar(@RequestParam String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);
        tarefa.setConcluida(false);
        service.salvar(tarefa);
        return "redirect:/tarefas";
    }

    @PostMapping("/concluir/{id}")
    public String concluir(@PathVariable Long id) {
        service.marcarConcluida(id);
        return "redirect:/tarefas";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/tarefas";
    }
}
