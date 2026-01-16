package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Adestrador")
public class Adestrador {
    @Id
    private String id;
    private String nome;
    private Long idade;
    private String cidade;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }
    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}