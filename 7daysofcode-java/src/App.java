import service.ApiService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(ApiService.buscaEnderecoPelo("https://viacep.com.br/ws/", "01001000", "json"));
    }
}
