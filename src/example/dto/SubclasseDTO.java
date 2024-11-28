package example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubclasseDTO {
    private ClasseDTO classe;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> observacoes;
    private String id;
    private String descricao;

    public SubclasseDTO() {
        // Construtor padrão necessário para Jackson
    }

    public SubclasseDTO(
            @JsonProperty("id") String id,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("classe") ClasseDTO classe,
            @JsonProperty("observacoes") List<String> observacoes) {
        this.id = id;
        this.descricao = descricao;
        this.classe = classe;
        this.observacoes = observacoes;
    }

    public ClasseDTO getClasse() {
        return classe;
    }

    public void setClasse(ClasseDTO classe) {
        this.classe = classe;
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
