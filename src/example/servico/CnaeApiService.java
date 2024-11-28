package example.servico;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.dto.SubclasseDTO;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class CnaeApiService {

    private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v2/cnae/subclasses/";
    private final ObjectMapper objectMapper;

    public CnaeApiService() {
        this.objectMapper = new ObjectMapper();
    }

    public SubclasseDTO buscarSubclassePorId(String subclasseId) throws IOException {
        String url = BASE_URL + subclasseId;
        String jsonResponse = fazerRequisicao(url);

        List<SubclasseDTO> subclasseList = objectMapper.readValue(jsonResponse, new TypeReference<List<SubclasseDTO>>() {});

        if (subclasseList.isEmpty()) {
            throw new IOException("Nenhuma subclasse encontrada para o código: " + subclasseId);
        }

        return subclasseList.get(0);
    }


    private String fazerRequisicao(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Erro ao acessar a API: Código HTTP " + conn.getResponseCode());
        }

        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            return response.toString();
        } finally {
            conn.disconnect();
        }
    }
}
