package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoDTO {
    private DivisaoDTO divisao;
    private String id;
    private String descricao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> observacoes;

    public GrupoDTO() {
        // Construtor padrão necessário para Jackson
    }

    public GrupoDTO(
            @JsonProperty("id") String id,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("divisao") DivisaoDTO divisao,
            @JsonProperty("observacoes") List<String> observacoes) {
        this.id = id;
        this.descricao = descricao;
        this.divisao = divisao;
        this.observacoes = observacoes;
    }

    public DivisaoDTO getDivisao() {
        return divisao;
    }

    public void setDivisao(DivisaoDTO divisao) {
        this.divisao = divisao;
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

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }
}
