package org.example.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClasseDTO {
    private GrupoDTO grupo;
    private String id;
    private String descricao;
    private List<String> observacoes;

    public ClasseDTO() {
        // Construtor padrão necessário para Jackson
    }

    public ClasseDTO(
            @JsonProperty("id") String id,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("grupo") GrupoDTO grupo,
            @JsonProperty("observacoes") List<String> observacoes) {
        this.id = id;
        this.descricao = descricao;
        this.grupo = grupo;
        this.observacoes = observacoes;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
