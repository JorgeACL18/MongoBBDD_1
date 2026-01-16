package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Pokemon")
public class Pokemon {
    @Id
    private String id;
    private String nome;
    private List<String> tipo;
    private Long nivel;
    private List<String> habilidades;
    private String adestradorID;

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

    public List<String> getTipo() {
        return tipo;
    }
    public void setTipo(List<String> tipo) {
        this.tipo = tipo;
    }

    public Long getNivel() {
        return nivel;
    }
    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getAdestradorID() {
        return adestradorID;
    }
    public void setAdestradorID(String adestradorID) {
        this.adestradorID = adestradorID;
    }
}