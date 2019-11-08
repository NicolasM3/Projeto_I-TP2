import java.io.*;
import Matriz.*;

public class TesteMatriz
{
	public static void main (String[] args)
	{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Matriz m = null;
		System.out.print ("Capacidade desejada para a Matriz: ");
		try
		{
			int cap = Integer.parseInt (entrada.readLine ());
			m = new Matriz(cap);
		}
		catch (IOException e)
		{}
		catch (Exception e)
		{
			System.err.println (e.getMessage()+"\n\n");
		}
		for (;;)
		{
			try
			{
				System.out.println("Digite a linha: ");
				int linha = Teclado.getUmInt();
				System.out.println("digite a coluna");
				int coluna = Teclado.getUmInt();

				if(linha < 1 || coluna < 1 || linha > m.getLinhas() || coluna > m.getColunas())
					throw new Exception("linha ou coluna invalidas");

				System.out.println("Digite a opção:");
				System.out.println("1: incluir um valor nessa posição");
				System.out.println("2: obter o valor dessa posição");
				int opcao = Teclado.getUmInt();
				switch(opcao){
					case 1: System.out.println("Digite o valor a incluir");double valor=Teclado.getUmDouble();m.incluir(linha, coluna, valor);break;
					case 2:System.out.println("O valor é: "+m.getValor(linha,coluna));
				}

				System.out.println("\n\n");

			}
			catch (NumberFormatException e)
			{
				System.err.println ("Nao foi digitado um numero inteiro\n\n");
			}
			catch (Exception e)
			{
				System.err.println (e.getMessage()+"\n\n");
			}
		}
	}
}