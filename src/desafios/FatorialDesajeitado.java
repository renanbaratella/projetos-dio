package desafios;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FatorialDesajeitado {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());
        int res;
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            //Calcule o valor do fatorial de "n", atrinbuindo o retorno a "res".
            nums.add(n);
            n--;
        }
        List<Integer> passoDaExpressao = nums;
        for (int i = 4; i > 1; i--) {
            //Escreve a expressão correspondente do passo 4 ao 2.
            passoDaExpressao = escreverExpressao(passoDaExpressao, i);
        }
        res = passoSomar(passoDaExpressao);//Soma dos valores da última expressão.
        System.out.println(res);
    }

    /**
     * Adiciona a operação correspondente ao passo.
     * @param lista inteiros
     * @param passo 4-> multiplicar; 3-> dividir; 2-> negativar;
     * @return lista de inteiros.
     */
    private static List<Integer> escreverExpressao(List<Integer> lista, int passo) {
        int contar = passo;   //contar os números conforme o passo.
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (passo == 2) contar = escreverNegativos(lista, passo, resultado, contar, i);
            else {
                //é multiplicar ou dividir.
                boolean temProximo = lista.size() != (i + 1);
                if ((contar == passo) && (temProximo)) {
                    if (passo == 4) {
                        resultado.add(lista.get(i) * lista.get(i + 1));//primeiro valor * segundo.
                    } else if (passo == 3) {
                        resultado.add(lista.get(i) / lista.get(i + 1));//primeiro valor / segundo.
                    }
                    contar = contar - 2;//pegou 2 numeros da contagem.
                    i++;//passa para o próximo elemento.
                } else {
                    resultado.add(lista.get(i));//copia os próximos valores: terceiro ou quarto.
                    if (contar > 1) contar--; //continua a contagem até 1.
                    else contar = passo; //reinicia a contagem.
                }
            }
        }
        return resultado;
    }

    /**
     * Adiciona o operador negativo ao número correspondente.
     * @param lista interios
     * @param passo inteiro
     * @param resultado lista de inteiros
     * @param contar inteiro
     * @param i inteiro
     * @return int
     */
    private static int escreverNegativos(List<Integer> lista, int passo, List<Integer> resultado, int contar, int i) {
        if ((contar == passo) && (i > 1)) {//copia o primeiro e o segundo valor = i(0, 1);
            resultado.add(-1 * lista.get(i));//aplica o operador negativo ao número.
            contar--;
        } else {
            resultado.add(lista.get(i));//copia o próximo valor.
            if (contar > 1) contar--; //continua a contagem até 1.
            else contar = passo; //reinicia a contagem.
        }
        return contar;
    }

    /**
     * Último passo, apenas soma os elementos da expressão final.
     * @param lista inteiros
     * @return int
     */
    private static int passoSomar(List<Integer> lista) {
        int resultado = 0;
        //Percorrer a lista inteira.
        for (Integer elemento : lista) {
            resultado += elemento;//soma cada elemento ao resultado.
        }
        return resultado;//valor final.
    }
}