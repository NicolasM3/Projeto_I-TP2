import java.io.File;

public class Main
{
    public static void main (String[] args)
    {
		try
		{
			Matriz coeficientes = Leitor.LerArquivo(new File("dados.txt"));
			System.err.println(coeficientes.toString());
		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}