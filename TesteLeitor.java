import java.io.File;
import Matriz.*;
import MetodoGauss.*;

public class TesteLeitor
{
    public static void main (String[] args)
    {
		try
		{
			System.out.print("Digite o nome do arquivo: ");
			String arq =  Teclado.getUmString();//Lemos o arquivo.
			Matriz coef = Leitor.LerArquivo(new File(arq));//Instaciamos uma matriz com os valores lidos pelo leitor.
			System.out.println(coef.toString());//printamos esses valores

		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}