package desafios;
import java.util.Scanner;

public class ClassificarMatrizes {
    public static void main(String args[]) {
          
     Scanner input = new Scanner(System.in);
      int i, aux;
	  //System.out.println("Digite o tamanho do Array: ");
      int N = input.nextInt();
    	int [] nums = new int[N];

    	for (i = 0; i < N; i++)
    	{
			//System.out.println("Digite o " + (i+1) +"�" + " n�mero: ");
    		nums[i] = input.nextInt();
    	}     	
		
		for (i = 0; i < N; i++)
    	{
			if (nums[i] % 2 != 0){

				for (int j = (i+1); j < N; j++)
				{
					if (nums[j] % 2 == 0) {
						aux = nums[i];
						nums[i] = nums[j];
						nums[j] = aux;
						j = N;
					}					
				}
			}
    	}
		
		for (i = 0; i < N; i++)
    	{
			System.out.println(nums[i]);
    	}  		
  	}
}