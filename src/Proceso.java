import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Proceso
{
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                System.getProperty("os.name").toLowerCase().contains("win") ? "cmd" : "bash",
                System.getProperty("os.name").toLowerCase().contains("win") ? "/c" : "-lc",
                System.getProperty("os.name").toLowerCase().contains("win") ? "ping -n 3 127.0.0.1" : "ping -c 3 127.0.0.1"
        );
        Process p = pb.start();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8)))
        {
            br.lines().forEach(System.out::println);
        }
        int code = p.waitFor();
        System.out.println("Código de salida: " + code);
    }
}
