package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import enumerator.HttpStatusCode;
import enumerator.RequestMethod;

public class ApiService {

    public static String buscaEnderecoPelo(String requestUrl, String... path) throws Exception {

        String urlParaChamada = requestUrl + String.join("/", path);

        try {
            URL url = URI.create(urlParaChamada).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod(RequestMethod.GET.name());
            if (conexao.getResponseCode() != HttpStatusCode.OK.getCode())
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            // String response = resposta.lines().reduce("", String::concat);
            String response = String.join("", resposta.lines().toList());

            // Gson gson = new Gson();
            // Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return response;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
