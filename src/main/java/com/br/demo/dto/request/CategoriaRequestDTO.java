package com.br.demo.dto.request;

public class CategoriaRequestDTO {

    private String nome;
    private String descricao;
    private String status;

    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(String nome, String descricao, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
