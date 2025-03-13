package com.br.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.demo.dto.request.CategoriaRequestDTO;
import com.br.demo.dto.response.CategoriaResponseDTO;
import com.br.demo.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

        private final CategoriaService categoriaService;

        public CategoriaController(CategoriaService categoriaService) {
                this.categoriaService = categoriaService;
        }

        @GetMapping
        public List<CategoriaResponseDTO> listarCategorias() {
                return categoriaService.listarCategorias();
        }

        @GetMapping("/{id}")
        public CategoriaResponseDTO buscarPorId(@PathVariable Long id) {
                return categoriaService.buscarPorId(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public CategoriaResponseDTO criarCategoria(@RequestBody CategoriaRequestDTO requestDTO) {
                return categoriaService.criarCategoria(requestDTO);
        }

        @PutMapping("/{id}")
        public CategoriaResponseDTO atualizarCategoria(@PathVariable Long id,
                        @RequestBody CategoriaRequestDTO requestDTO) {
                return categoriaService.atualizarCategoria(id, requestDTO);
        }

        @DeleteMapping("/{id}")
        public void excluirCategoria(@PathVariable Long id) {
                categoriaService.excluirCategoria(id);
        }

        @GetMapping("/ativas")
        public List<CategoriaResponseDTO> listarCategoriasAtivas() {
                return categoriaService.listarCategoriasAtivas();
        }
}
