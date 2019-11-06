import java.util.StringTokenizer;
import java.io.*;

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
		if(!file.exists())
			throw new Exception("nenhum documento definido");

		Matriz ret = null;

		try
		{
			BufferedReader arquivo = new BufferedReader (new FileReader (file));

			int qtdEquacoes = Integer.parseInt(arquivo.readLine());
			String a = "";

			ret = new Matriz(qtdEquacoes);

			for (int i=0; i < qtdEquacoes; i++)
			{
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
				int coeficiente = 0;
				while (quebrador.hasMoreTokens())
				{
					a = quebrador.nextToken();
					ret.incluir(i, coeficiente, Double.parseDouble(a.trim()));
					coeficiente++;
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Erro: " + ex);
		}
		return ret;
	}
}