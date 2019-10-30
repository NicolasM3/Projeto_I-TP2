import java.util.StringTokenizer;
import java.io.*;

public class Leitor
{
	public static Matriz LerArquivo(File file) throws Exception
	{
		if((!file.exists()))
			throw new Exception("nenhum documento definido");

		if(file == null)
			throw new Exception("Arquivo null");

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