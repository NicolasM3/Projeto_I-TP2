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
			double[] a = MetodoGauss.Calcular(coeficientes);
			//for(int i = 0; i < coeficientes.getLinhas(); i++)
			//	System.out.println(a[i]);

		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}