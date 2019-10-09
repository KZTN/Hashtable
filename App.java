import java.util.Scanner;
public class App {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int key;
        Registro r1, r2, r3, r4;
        MapaHash mapa = new MapaHash();
        mapa.put(new Registro(4815, "leao"));
        mapa.put(new Registro(4815, "Cachorro"));
        mapa.put(new Registro(18080, "Gato"));
        mapa.put(new Registro(681351, "Pássaro"));
        mapa.put(new Registro(26548, "Tartaruga"));
        
        do {
            System.out.println("Digite o código do registro (-1 para sair)");
            key = teclado.nextInt();
            Registro r = mapa.get(key);
            if(r != null) {
                System.out.println("Registro recuperado: "+r.getKey()+" - "+r.getValue());
            } else {
                System.out.println("Registro não existente!");
            }
        }   while(key != -1);

    }
}