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
			for(int i = 0; i < coeficientes.getLinhas(); i++)
			{
				for(int j = 0; j < coeficientes.getColunas() - 1; j++)
					System.out.print(coeficientes.getValor(i, j) + " ");
				System.out.println();
			}
			double[] a = MetodoGauss.Calcular(coeficientes);

		}
		catch(Exception ex)
		{
			System.err.println("Erro:" + ex.getMessage());
		}
    }
}