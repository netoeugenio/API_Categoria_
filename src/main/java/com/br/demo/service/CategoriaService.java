package com.br.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.demo.dto.request.CategoriaRequestDTO;
import com.br.demo.dto.response.CategoriaResponseDTO;
import com.br.demo.model.Categoria;
import com.br.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResponseDTO> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(c -> new CategoriaResponseDTO(c.getId(), c.getNome(), c.getDescricao(), c.getStatus(),
                        c.getDataCriacao()))
                .collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao(),
                categoria.getStatus(), categoria.getDataCriacao());
    }

    public CategoriaResponseDTO criarCategoria(CategoriaRequestDTO requestDTO) {
        Categoria novaCategoria = new Categoria(null, requestDTO.getNome(), requestDTO.getDescricao(),
                requestDTO.getStatus(), LocalDateTime.now());
        Categoria categoriaSalva = categoriaRepository.save(novaCategoria);
        return new CategoriaResponseDTO(categoriaSalva.getId(), categoriaSalva.getNome(), categoriaSalva.getDescricao(),
                categoriaSalva.getStatus(), categoriaSalva.getDataCriacao());
    }

    public CategoriaResponseDTO atualizarCategoria(Long id, CategoriaRequestDTO requestDTO) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaExistente.setNome(requestDTO.getNome());
        categoriaExistente.setDescricao(requestDTO.getDescricao());
        categoriaExistente.setStatus(requestDTO.getStatus());

        Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistente);
        return new CategoriaResponseDTO(categoriaAtualizada.getId(), categoriaAtualizada.getNome(),
                categoriaAtualizada.getDescricao(), categoriaAtualizada.getStatus(),
                categoriaAtualizada.getDataCriacao());
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaResponseDTO> listarCategoriasAtivas() {
        return categoriaRepository.findAll().stream()
                .filter(c -> "Ativo".equals(c.getStatus()))
                .map(c -> new CategoriaResponseDTO(c.getId(), c.getNome(), c.getDescricao(), c.getStatus(),
                        c.getDataCriacao()))
                .collect(Collectors.toList());
    }
}
