import java.io.File;

public class Main
{
    public static void main (String[] args)
    {
		try
		{
			System.out.print("Digite o nome do arquivo: ");
			String arq =  Teclado.getUmString();
			Matriz coeficientes = Leitor.LerArquivo(new File(arq));
			MetodoGauss.Calcular(coeficientes);

		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}