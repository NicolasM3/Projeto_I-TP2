import java.io.File;

public class Main
{
    public static void main (String[] args)
    {
		try
		{
			double matriz[][] = Leitor.LerArquivo(new File("dados.txt"));
			for(int i = 0; i < 4; i++)
			{
				for(int e = 0; e < 5; e++)
					System.out.print(matriz[i][e] + " ");

				System.out.println("");
			}
		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}