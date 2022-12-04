// IMPORTANTE: Para ler os dados de entrada do usuário, utilize a classe Scanner, 
// instanciando seu leitor da seguinte forma: "Scanner leitor = new Scanner(System.in);". 
// Por outro lado, para imprimir suas saídas, utilize System.out.print ou System.out.println. 

package desafios;
import java.util.Scanner;

public class ChecagemPalindromo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        String palindromo = "";

        //TODO: Retorne TRUE ou FALSE, caso a "palavra" seja ou não um Palíndromo.
        
        
        for(int i = palavra.length() - 1; i >= 0; i--){
          palindromo += palavra.charAt(i);
        }
        
        if(palindromo.equals(palavra)){
          System.out.println("TRUE");
        }else{
          System.out.println("FALSE");
        }
        
        
        
        
    }
}