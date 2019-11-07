import java.io.File;
import Matriz.*;
import MetodoGauss.*;

public class Main
{
    public static void main (String[] args)
    {
		try
		{
			System.out.print("Digite o nome do arquivo: ");
			String arq =  Teclado.getUmString();//Lemos o arquivo.
			Matriz coeficientes = Leitor.LerArquivo(new File(arq));//Instaciamos uma matriz com os valores lidos pelo leitor.
			double[] a = MetodoGauss.Calcular(coeficientes); //Resolvemos a equação e armazenamos o resultado em um vetor.
			for(int i=0; i<a.length; i++){
				int aux= i+1;
				System.out.print(""+aux+"° variavel: ");
				System.out.println(a[i]);//Printamos o resultado na tela.
			}

		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}