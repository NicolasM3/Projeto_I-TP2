import java.io.File;
import Matriz.*;
import MetodoGauss.*;

public class TesteMetodoGauss
{
    public static void main (String[] args)
    {
		double[] valor1 = {0, 3, 2, 28, 4, 0, 2, 24, 2, 3, 0, 16};
		double[] valor2 = {0, 15, -1, -16, -4, -57, 6, 0, -15, -5, 13, 74, -3, 8, 0, 16, -6, -20, 2, -11, 17, 0, -9, 12, 12, 12, 9, -9, 0, 75};
		double[] valor3 = {1, 1, 2, 1, 1, 5};
		try{
			Matriz m1 = new Matriz(3);
			int aux=0;
			for(int i=0; i<m1.getLinhas(); i++)
				for(int j=0; j<m1.getColunas(); j++){
					m1.incluir(i, j, valor1[aux]);
					aux++;
				}
			System.out.println("1° Matriz: ");
			double[] a = MetodoGauss.Calcular(m1);                    //Resolvemos a equaÃ§Ã£o e armazenamos o resultado em um vetor.
			for(int i=0; i<a.length; i++){
				int auxiliar = i+1;
				System.out.print(auxiliar+"° valor: ");
				System.out.println(a[i]);                                       //Printamos o resultado na tela.
			}
			System.out.println();
		}
		catch(Exception e){}

		try{
			Matriz m2 = new Matriz(5);
			int aux=0;
			for(int i=0; i<m2.getLinhas(); i++)
				for(int j=0; j<m2.getColunas(); j++){
					m2.incluir(i, j, valor2[aux]);
					aux++;
				}
			System.out.println("2° Matriz: ");
			double[] a = MetodoGauss.Calcular(m2);                    //Resolvemos a equaÃ§Ã£o e armazenamos o resultado em um vetor.
			for(int i=0; i<a.length; i++){
				int auxiliar = i+1;
				System.out.print(auxiliar+"° valor: ");
				System.out.println(a[i]);                                       //Printamos o resultado na tela.
			}
			System.out.println();
		}
		catch(Exception e){}

		try{
			Matriz m3 = new Matriz(2);
			int aux=0;
			for(int i=0; i<m3.getLinhas(); i++)
				for(int j=0; j<m3.getColunas(); j++){
					m3.incluir(i, j, valor3[aux]);
					aux++;
				}
			System.out.println("3° Matriz: ");
			double[] a = MetodoGauss.Calcular(m3);                    //Resolvemos a equaÃ§Ã£o e armazenamos o resultado em um vetor.
			for(int i=0; i<a.length; i++){
				int auxiliar = i+1;
				System.out.print(auxiliar+"° valor: ");
				System.out.println(a[i]);                                       //Printamos o resultado na tela.
			}
			System.out.println();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
    }
}