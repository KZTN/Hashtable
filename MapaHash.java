public class MapaHash {
    private Registro valores[];
    public MapaHash() {
        valores = new Registro[100]; 
    }
    public void put(Registro registro) {
        int posicao = registro.hashCode();
        if(valores[posicao] == null) {
            valores[posicao] = registro;
            System.out.println("Posicao vazia, novo registro inserido no índice");
        } else {
            System.out.println("Colisão detectada");
            Registro reg = valores[posicao];
                while (reg.getProximo() != null) { // se ele esta no meio da lista
                    if(reg.getKey() == registro.getKey()) { // o registro que quero inserir  é o mesmo que já existe?
                        reg.setValue(registro.getValue()); // apenas substitui o valor
                        System.out.println("Registro existente, atualizando valor do existente");
                    }
                    reg = reg.getProximo();
                }
                if (reg.getProximo() == null) { // se nada foi encontrado, lista no último elemento = null
                    if(reg.getKey() == registro.getKey()) {
                        reg.setValue(registro.getValue()); // apenas substitui o valor
                        System.out.println("Registro existente, atualizando valor do existente");
                        return;
                    }
                }
                reg.setProximo(registro); // coloquei o registro na última posicão do indice X do mapa
                System.out.println("Registro adicionado no final da lista");
                return;
            }
        }
    public Registro get(int key) {
        Registro r = new Registro();
        r.setKey(key);
        int posicao = r.hashCode();
        Registro resultado = valores[posicao]; // tento encontrar o registro
        if(resultado.getKey() == key) { // é o que estou procurando?
            return resultado;
        } else {
            while(resultado != null) { // enquanto tiver gente na lista
                resultado.getProximo(); // vou para o proximo
                if(resultado != null &&  resultado.getKey() == key) { // e o cara?
                    return resultado; // se for, retorno ele
                } 
            }
        }
        return null; // registro não encontrado
    }
}