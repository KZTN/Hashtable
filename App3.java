import java.util.Scanner;
public class App3 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String texto;
        int chave;
        int continua;
        Registro r;
        MapaHashMD5 mapa = new MapaHashMD5();
        do {
            System.out.println("Digite uma chave");
            chave = Integer.parseInt(teclado.next());
            System.out.println("Digite um valor");
            texto = teclado.next();
            r = new Registro(chave, texto);
            mapa.put(r);
            System.out.println("Continua? (0: Aborta, 1: Continua)");
            continua = Integer.parseInt(teclado.next());
        } while(continua != 0);
        System.out.println("===================");
        do {
            System.out.println("Digite uma chave");
            chave = Integer.parseInt(teclado.next());
            r = mapa.get(chave);
            if (r != null) {
                System.out.println("Registro Encontrado! = "+r.getValue()+ " - Hash MD5: "+ r.hashCodeMD5());
                System.out.println("Deseja remover deletar este registro?(1: Sim, 0: Não)");
                int op = Integer.parseInt(teclado.next());
                if(op == 1) {
                    //mapa.del(r.getKey());
                    System.out.println("Registro removido com sucesso!");
                }
            } else {
                System.out.println("Registro inexistente");
            }
        } while(chave != -1);
    }
}
