package com.br.demo.repository;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.Categoria;

public interface CategoriaRepository {

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria save(Categoria categoria);

    void deleteById(Long id);
}
