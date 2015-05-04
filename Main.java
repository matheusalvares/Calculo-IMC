package ExercicioAula2;

public class Main {

	public static void main(String[] args) {
		RecebeDados r = new RecebeDados();
		
		r.recebeDadosUsuario();
		r.recebeCalorias();
		System.out.println("");
		r.imprimeDados();
		System.out.println("IMC inicial: " + r.calculaImcInicial() + "\n");
		r.imprimeCalorias();
		System.out.println("");
		System.out.println("IMC Final: " + r.calculaImcFinal());		
	}
}
