import java.util.StringTokenizer;
import java.io.*;
import Matriz.*;

public class Leitor
{
	/**
	Lê um arquivo.
	Lê uma file e retorna um objeto da classe Matriz contendo todos os valores,
	lançando exceções se o arquivo não existir.
	@param file arquivo a ser lido, instância da classe File.
	@throws Exception se a instância da classe file não existir.
	*/
	public static Matriz LerArquivo(File file) throws Exception
	{
		if(!file.exists())//Verificamos se o arquivo existe
			throw new Exception("nenhum documento definido");

		Matriz ret = null;

		try
		{
			BufferedReader arquivo = new BufferedReader (new FileReader (file));

			int qtdEquacoes = Integer.parseInt(arquivo.readLine());//Lemos a primeira linha que contem quantas equações serão.
			String a = "";

			ret = new Matriz(qtdEquacoes);//Instaciamos uma matriz que recebe quantas equações serão.

			for (int i=0; i < qtdEquacoes; i++)
			{
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());//Instaciamos uma classe que quebra a string em partes.
				int coeficiente = 0;
				while (quebrador.hasMoreTokens())
				{
					a = quebrador.nextToken();
					ret.incluir(i, coeficiente, Double.parseDouble(a.trim()));//Inserimos na matriz o valor separado pelo separador.
					coeficiente++;
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Erro: " + ex);
		}
		return ret;//R
		etornamos a matriz.
	}
}