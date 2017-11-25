package com.chegaai.estabelecimento.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentoCategoria")
public class EstabelecimentoCategoriaController {
    @Autowired
    private EstabelecimentoCategoriaService estabelecimentoCategoriaService;

    @GetMapping()
    public List<EstabelecimentoCategoria> getAll() {
        return estabelecimentoCategoriaService.getAll();
    }
}
