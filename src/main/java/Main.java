import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/**
	 * estas variables son estaticas debido a que se usan sin necesidad de instanciar un objeto de la clase Main, de hecho lo mismo
	 * sucede con los metodos, si notas, los metodos no solo son publicos sino que tambien son estaticos, investiga la accesibilidad
	 * de los metodos para saber mas.
	 * */
	//se declara la variable myname, contendra el nombre del usuario
	static String myName;
	//se declara la variable myage, contendra la edad del usuario
	static Integer myAge;
	//se declara el ArrayList de tipo character, contendra el cifrado final
	static ArrayList<Character> cifrado = new ArrayList();

	public static void main(String[] args) {
		Main.getUserInput();
		cifrado.addAll(Main.stringToArray());
		cifrado.addAll(Main.integerToArray());
		System.out.println(cifrado);
	}
	
	public static void getUserInput() {
		//declarando el objeto scanner, para posterior utilizacion
		Scanner sc = new Scanner(System.in);
		//pedimos el nombre del usuario
		System.out.println("ingresa tu nombre: ");
		myName = sc.nextLine();
		//pedimos la edad del usuario
		System.out.println("Ingresa tu edad: ");
		myAge = sc.nextInt();
		
	}
	
	public static ArrayList<Character> stringToArray() {
		//se crea una lista de tipo char, se supone que almacenara los caracteres del nombre
		ArrayList<Character> list = new ArrayList();
		//Separando el nombre
		String[] palabras = myName.split(" ");
		//el ciclo for nos sirve para recorrer las palabras y seccionarlas en letras
		for(int i = 0; i < palabras.length; i++) {
			//la funcion toCharArray nos sirve para separar cada caracter del string myName por letra
			char[] chars = palabras[i].toCharArray();
			//por cada elemento en chars, un nuevo elemento letra debe ser creado e inicializado
			for(char letra : chars) {
				//si la letra resulta ser z, el valor se cambia a 'a' (sensible a Z mayuscula)
				switch(letra) {
				case 'z':
					//dado que la letra pasa a ser a, lo que sucede es que el resultado arroja b debido al incrmento en la linea 45, por eso se usa el operador -- (menos, menos) para convertir la 'b' en 'a'
					letra = 'a';
					letra --;
					break;
				case 'Z':
					letra = 'A';
					letra --;
					break;
				}
				//este operador incrementa el valor char en secuencia alfabetica
				letra ++;
				//se agrega cada letra a la lista incializada al principio
				list.add(letra);
			}
		}
		//se regresa la lista ya populada
		return list;
	}
	
	public static ArrayList<Character> integerToArray() {
		//se crea una nueva lista de  tipo char, contendra los cracrteres de la edad
		ArrayList<Character> list = new ArrayList();
		//se convierten los valores int a string y posteriormente a char con la funcion toCharArray
		char[] chars = String.valueOf(myAge).toCharArray();
		//por cada elemento dentro de chars se crea un elemento de tipo char llamado numero
		for(char numero : chars){
			//se incrementa el numero a uno
			numero++;
			//se agrega el valor a la lista
			list.add(numero);
		}
		//se debe regresar el valor ya que el metodo exige se le regrese un valor de tipo ArrayList<Character>
		return list;
	}

}
