package ExercicioAula2;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecebeDados {
	
	private String nome;
	private int idade;
	private double altura;
	private double peso;
	double[] c = {0, 0, 0, 0, 0, 0, 0, 0};
	Scanner scanner = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}	
	
	public void recebeDadosUsuario(){
		boolean c = true;
		
		while(c){
			try{
				System.out.print("Digite seu nome: ");
				setNome(scanner.nextLine());
				System.out.print("Digite sua idade: ");
				setIdade(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Digite sua altura: ");
				setAltura(scanner.nextDouble());
				scanner.nextLine();
				System.out.print("Digite seu peso em Kg: ");
				setPeso(scanner.nextDouble());
				scanner.nextLine();
				System.out.println("");
				c = false;
			} 
			catch(InputMismatchException ime){
				System.out.println("\nTipo de dado inválido.\n");
				scanner.nextLine();
			}
		}
	}
	
	public String calculaImcInicial(){
		double imc;
		DecimalFormat df = new DecimalFormat("0.00"); 
		
		imc = (getPeso() / (getAltura() * getAltura()));		 
		String str = df.format(imc); 
		
		return str;
	}
	
	public void recebeCalorias(){//outof bounds
		double cal = 0.000001;
		int i = 0;
		boolean b = true;
		
		while(b){
			try{
				while(cal != 0){
					System.out.print("Digite quantas mil calorias gastas no " + (i+1) + "º dia da semana: ");
					cal = scanner.nextDouble();
					c[i] = cal;
					i++;
				}
				b = false;
			}
			catch(ArrayIndexOutOfBoundsException aioobe){
				System.out.println("\nO limite de dias da semana foi ultrapassado.\n");
			}
			catch(InputMismatchException ime){
				System.out.println("\nTipo de dado Invalido.\n");
				scanner.nextLine();
			}
			finally{
				i = 0;
			}
		}
	}
	
	public String calculaImcFinal(){
		int i;
		double imc, somaDeCalorias = 0, pesoPerdido, pesoFinal;
		DecimalFormat df = new DecimalFormat("0.00"); 
		
		for(i = 0; i <(c.length - 1); i++){
			somaDeCalorias = somaDeCalorias + c[i];
		}
		pesoPerdido = (somaDeCalorias / 7000);
		pesoFinal = (getPeso() - pesoPerdido);
		imc = (pesoFinal / (getAltura() * getAltura()));
		 
		String str = df.format(imc); 
		String str2 = df.format(pesoFinal);
				
		System.out.println("Peso Final: " + str2 + " Kg");
		return str;
	}
	
	public void imprimeDados(){
		System.out.println("*************************************************");
		System.out.println("Nome: " + getNome());
		System.out.println("Idade: " + getIdade() + " anos");
		System.out.println("Altura: " + getAltura() + " cm");
		System.out.println("Peso Inicial: " + getPeso() + "kg");		
	}
	
	public void imprimeCalorias(){
		int i;
		
		for(i=0; i<(c.length - 1); i++){
			System.out.println("Calorias gastar no " + (i+1) + "º dia: " + c[i] + " Kcal");
		}
	}
}
