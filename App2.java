import java.util.Scanner;
public class App2 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String texto;
        int chave;
        int continua;
        Registro r;
        MapaHash mapa = new MapaHash();
        do {
            System.out.println("Digite uma chave");
            texto = teclado.next();
            chave = Integer.parseInt(texto);
            System.out.println("Digite um valor");
            texto = teclado.next();
            r = new Registro(chave, texto);
            mapa.put(r);
            System.out.println("Continua? (0 para abortar, 1 para continuar)");
            continua = Integer.parseInt(teclado.next());
        } while(continua != 0);
    }
}
