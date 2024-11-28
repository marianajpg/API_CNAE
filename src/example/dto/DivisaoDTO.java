package example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DivisaoDTO {
    private SecaoDTO secao;
    private String id;
    private String descricao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> observacoes;

    public DivisaoDTO() {
        // Construtor padrão necessário para Jackson
    }

    public DivisaoDTO(
            @JsonProperty("id") String id,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("secao") SecaoDTO secao,
            @JsonProperty("observacoes") List<String> observacoes) {
        this.id = id;
        this.descricao = descricao;
        this.secao = secao;
        this.observacoes = observacoes;
    }

    public SecaoDTO getSecao() {
        return secao;
    }

    public void setSecao(SecaoDTO secao) {
        this.secao = secao;
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
