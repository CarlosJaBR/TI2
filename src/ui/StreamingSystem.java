package ui; 
/*
import java.util.Scanner;
import model.Channel; 
import model.Type;
import model.Censure;
import model.Category;
import model.State;
*/
import java.util.Scanner;
import model.*;

/**
*StreamingSystem class, package ui en el cual el usuario interactua con el sistema 
*/
public class StreamingSystem{

	/**
	* cBlackSnail Channel, es el canal de servicios Streaming.
	*/
	private Channel cBlackSnail;
	
	/**
	*sc Scanner, permite la lectura de entradas. 
	*/
	private Scanner sc;

	
	/**
	*Método constructor de la clase StreamingSystem. 
	*/
	public StreamingSystem(){
		
		sc = new Scanner(System.in);
	}
	
	/**
	*Método main
	*@param args String[]
	*/
	
	public static void main(String[] args){
		
		StreamingSystem sS = new StreamingSystem();
			
		System.out.println("***Iniciando el programa***");
		System.out.println("Bienvenido :)");
		
		// Opción del menú ingresada por el usuario.
		int opcion = 0; 
		System.out.println("Bienvenidos a el BlackSnail, canal y proveedor de servicios streaming");
		
		do {
		    opcion = sS.menu();
		    sS.menuOptions(opcion);
		}while (opcion !=0);
		
		
	}
	// Creación del objeto canal, acá se ingresan los datos del objeto. 
	
	/**
	*Método startChannel, permite crear e inicializar un objetio de tipo Channel
	*/
	public void startChannel(){
		
		System.out.println("Bienvenidos a  BlackSnail, canal y proveedor de servicios streaming");
		System.out.println("Por favor, ingrese los siguientes datos:"); 
		
		System.out.println("Nit del canal: ");
		String nit = sc.nextLine();
		
		System.out.println("DirecciOn: ");
		String address = sc.nextLine(); 
		
		System.out.println("Website: ");
		String website = sc.nextLine();
		
		cBlackSnail = new Channel(nit,address,website);
		
		System.out.println("*** Datos de BlackSnail guardados con éxito :) ***");
	}
	/**
	*Método menu, permite visualizar el menú del sistema e ingresar la opción deseada.
	*@return out int, opción del menú seleccionada.
	*/
	public int menu(){
		
		int out;
		System.out.println("\n\nMenu de la sistema, digite una opciOn\n"+ 
		                    " (1) Registrar datos de la tienda\n" +
		                    " (2) Registrar suscriptor\n" +
		                    " (3) Desactivar suscriptor\n"+
							" (4) Ver lista de suscriptores\n"+
							" (5) Ver suscriptor menor de edad con mayor número de horas dispuesto a consumir\n"+
							" (6) Registrar productos\n" +
							" (7) Información sobre los productos\n" + 
							" (8) Agregar temporada\n" + 
							" (9) Lista de películas por categoría\n" +
							"(10) Lista de series \n" +
							"(0) Para salir del sistema"
	
		);
		out = sc.nextInt();
		sc.nextLine();
		return out;
	}
	
	/**
	*Método menuOptions, permite hacer el llamado de métodos de StreamingSystem según la elección del usuario.
	*@param opcionUser int, opción ingresada por el usuario en el método menu
	*/
	public void menuOptions(int opcionUser){
		
		switch(opcionUser)
		{
		case 0:
			System.out.println("***Cerrando sistema***");
			break;
		case 1:
			startChannel();
			break;
		case 2:
			registerSubcriber();
			break;
		case 3:
			deactivateSubcriber(); 
			break;
		case 4:
			informationSuscriberActive();
			break;
		case 5:
			consultSubcriberMoreHours();
			break;
		
		case 6:
			System.out.println("Registrar productos");
			registerProduct();
			break;
		case 7: 
			System.out.println("Información de productos");
			infoProducts();
			break;
		case 8: 
			System.out.println("Agregar temporada");
			registerNextSeason();
			break;
		case 9: 
			System.out.println("Lista de películas");
			listMovies();
			break; 
		case 10:
			System.out.println("Lista de series");
			listSeries();
			break;
		}
	}
	
	/**
	*Método verifyChannel, permite validar la existencia de un objeto de la clase Channel
	*@return out boolean, retorna false si no existe el objeto, y true en caso contrario. 
	*/
	public boolean verifyChannel(){
		
		boolean out = false; 
		
		if(cBlackSnail==null)
		{
			out = true; 
		}
		return out; 
	}
	
	/**
	*Método registerSubcriber, permite registrar un suscriptor en el sistema. 
	*/
	public void registerSubcriber(){
		
		int posicion;  
		String identificacion; 
		String name; 
		int age; 
		int hoursConsume; 
		int opcion; 
		Type typeClient; 
		State stateClient; 
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear suscriptores hasta que no cree e ingrese los datos del canal");
		}
		else 
		{
			posicion = cBlackSnail.sharePosition(); 
			if(posicion==-1)
			{
				System.out.println("Se ha llego al límite de suscriptores, ya no queda espacio :( ");
			}
			else 
			{
				System.out.println("***Crear un suscriptor*** " + posicion);
				
				System.out.println("Ingrese los siguientes datos: ");
				
				System.out.println("Número de identificación:");
				identificacion = sc.nextLine();
				
				if(cBlackSnail.verifySubcriber(identificacion))
				{
					System.out.println("Ya existe un usuario con este número de identificacion");
				}
				else 
				{
					System.out.println("Nombre completo: ");
					name = sc.nextLine();
					
					System.out.println("Edad: ");
					age = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Horas dispuesto a consumir: ");
					hoursConsume = sc.nextInt();
					
					System.out.println("Tipo de cliente: ");
					opcion = typeOpcion();
					typeClient = opcionType(opcion);
					
					stateClient = State.ACTIVO; 
					
					cBlackSnail.addSubcriber(posicion,identificacion,name,age,hoursConsume,typeClient,stateClient);
					System.out.println(cBlackSnail.suscriptorsInfo(posicion));
				}
				
			}
		}
	}
	/**
	*Método typeOpcion, permite mostrar el menú de tipos de suscriptores y elegir uno.
	*@return eleccion int, opción del menú seleccionada
	*/
	public int typeOpcion()
	{
		int eleccion; 
		System.out.println("\n\nTipos de suscriptor, digite una opciOn\n"+ 
		                    "(1) Normal\n" +
		                    "(2) Platino\n" +
		                    "(3) Oro\n"+
							"(4) Diamante\n"
		);
		do{
			eleccion = sc.nextInt();
			sc.nextLine();
		}while(eleccion<1 && eleccion>4);
		return eleccion;
	}
	
	/**
	*Método opcionType, permite asignar el tipo de suscriptor según sea la elección del usuario.
	*@param opcion, contiene el número del tipo de suscriptor a asignar 
	*@return typeC Type, contiene el tipo de suscriptor
	*/
	public Type opcionType(int opcion){
		Type typeC = null; 		
		switch(opcion)
		{
		case 1:
			typeC = Type.NORMAL;
			break; 
		case 2:
			typeC = Type.PLATINO;
			break; 
		case 3:
			typeC = Type.ORO;
			break; 
		case 4:
			typeC = Type.DIAMANTE;
			break; 
		}
		return typeC;
	}
	
	/**
	*Método deactivateSubcriber, permite desactivar un suscriptor
	*/
	public void deactivateSubcriber(){
		
		int identificador;  
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear suscriptores hasta que no cree e ingrese los datos del canal");
		}	
		else 
		{
			if(cBlackSnail.verifySubcriberInSystem())
			{
				System.out.println("***Suscriptores registrados en el sistema***");
				System.out.println(cBlackSnail.listSuscriptor());
				
				System.out.println("Ingrese el identificador de sistema del suscriptor a desactivar ");
				identificador = sc.nextInt();
				
				cBlackSnail.editState(identificador);
				cBlackSnail.editType(identificador);
				System.out.println(cBlackSnail.suscriptorsInfo(identificador));
				
				
			}
			else 
			{
				System.out.println("No existen suscriptores en el sistema, registre e intente más tarde"); 
			}
		}
		//CODIGO GENERAL PARA LA CONSTRUCCIÓN DE UN MÉTODO, CONTIENE VALIDACIONES QUE EVITAN EXCEPCIONES
		
		/*
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear suscriptores hasta que no cree e ingrese los datos del canal");
		}	
		else 
		{
			if(cBlackSnail.verifySubcriberInSystem())
			{
				System.out.println("Si existen subcribers");
			}
			else 
			{
				System.out.println("NO existen subcribers"); 
			}
		}
		*/
	}
	
	/**
	*Método informationSuscriberActive, permite ver la cantidad de usuarios que pertenecen a cada tipo de suscriptor
	*/
	public void informationSuscriberActive(){
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear suscriptores hasta que no cree e ingrese los datos del canal");
		}	
		else 
		{
			if(cBlackSnail.verifySubcriberInSystem())
			{
				System.out.println("***Cantidad de usuarios activos y su tipo de suscriptor***");
				System.out.println(cBlackSnail.listSubcriberActivate());
			}
			else 
			{
				System.out.println("No existen suscriptores en el sistema, registre e intente más tarde"); 
			}
		}
	}
	/**
	*Método consultSubcriberMoreHours, permite encontrar el nombre del menor de edad con 
	*mayor número de horas dispuesto a consumir contenido Streaming
	*/
	public void consultSubcriberMoreHours(){
		
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear suscriptores hasta que no cree e ingrese los datos del canal");
		}	
		else 
		{
			if(cBlackSnail.verifySubcriberInSystem())
			{
				System.out.println("***Menor de edad con el mayor número de horas dispuestas a consumir contenido Streaming***");
				System.out.println(cBlackSnail.nameSubcriberMoreHours());
			}
			else 
			{
				System.out.println("No existen suscriptores en el sistema, registre e intente más tarde"); 
			}
		}
	}
	/**
	*Método registerProduct, permite registrar un producto. Pueden ser películas y series. 
	*/
	public void registerProduct(){
		
		//Registro de películas y series 
		
		int optionProduct = 0;
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede crear productos hasta que no cree e ingrese los datos del canal");
		}
		else
		{
			if(cBlackSnail.sharePositionP()!=-1)
			{
				System.out.println("Ingrese el producto que desea registrar");
				System.out.println("1 - Película");
				System.out.println("2 - Serie");
		
				do{
					System.out.println("***Opción***");
					optionProduct = sc.nextInt();
				}while(optionProduct<1 && optionProduct>2);
		
				switch(optionProduct)
				{
				case 1:
					registerMovie();
					break;
				case 2: 
					registerSerie();
					break; 
				}
			}
			else
			{
				System.out.println("Se alcalzo el límite de productos, intente más tarde");
			}
		}
	}
	/**
	*Método censureOption, método que permite escoger una opción y retorna un valor que sera 
	*usado como parámetro
	*@return option int
	*/
	public int censureOpcion()
	{
		int option; 
		System.out.println("\n\nIngresa opción\n"+ 
		                    "(1) SI\n" +
		                    "(2) NO\n" 
		);
		do{
			option = sc.nextInt();
			sc.nextLine();
		}while(option<1 && option>2);
		return option;
	}
	
	/**
	*Método opcionCensure, asigna la opción de censura a una serie
	*@param option int, elección del usuario.
	*@return censuresS, opción asignada.
	*/
	public Censure opcionCensure(int option){
		Censure censuresS = null; 		
		switch(option)
		{
		case 1:
			censuresS = Censure.SI;
			break; 
		case 2:
			censuresS = Censure.NO;
			break; 
		}
		return censuresS;
	}
	/**
	*Método categoryOption, método que permite escoger una opción y retorna un valor que sera 
	*usado como parámetro
	*@return punto int
	*/
	public int categoryOpcion()
	{
		int punto; 
		System.out.println("\n\nTipos de película\n"+ 
		                    "(1) ROMANTICA\n" +
		                    "(2) ACCION\n" + 
							"(3) SUSPENSO\n"+
							"(4) TERROR\n"+
							"(5) COMEDIA\n"
		);
		do{
			punto = sc.nextInt();
			sc.nextLine();
		}while(punto<1 && punto>2);
		return punto;
	}
	/**
	*Método opcionCategory, permite asignar la categoría de pelicula según sea la elección del usuario.
	*@param punto int, contiene el número de la categoría de la película a asignar 
	*@return categoryM Category, contiene la categoria
	*/
	public Category opcionCategory(int punto){
		Category categoryM = null; 		
		switch(punto)
		{
		case 1:
			categoryM = Category.ROMANTICA;
			break; 
		case 2:
			categoryM = Category.ACCION;
			break; 
		case 3:
			categoryM = Category.SUSPENSO;
			break; 
		case 4:
			categoryM = Category.TERROR;
			break; 
		case 5:
			categoryM = Category.COMEDIA;
			break;
		}
		return categoryM;
	}
	/**
	*Método registerMovie, permite guardar y registrar productos de tipo película. 
	*/
	public void registerMovie(){
		
		
		String name; 
		String nameProducer;
		String nameProductions;
		String synopsis; 
		int day; 
		int month; 
		int year;
		int age; 
		Category categoryMovie;
		int punto; 
		int index = cBlackSnail.sharePositionP();
		boolean flag = false; 
		
		sc.nextLine();
		
		do{
			System.out.println("Ingrese el nombre de la película");
			name = sc.nextLine();
			flag = cBlackSnail.shareName(name);
		}while(flag != false);
		//System.out.println("Ingrese el nombre de la pelicula");
		//name = sc.nextLine();
			
		System.out.println("Ingrese el nombre del productor");
		nameProducer = sc.nextLine();
			
		System.out.println("Ingrese la sinopsis");
		synopsis = sc.nextLine();
			
		System.out.println("Ingrese el día del estreno mundial");
		day = sc.nextInt();
			
		System.out.println("Ingrese el mes del estreno mundial");
		month = sc.nextInt();
			
		System.out.println("Ingrese el año del estreno mundial");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre de la productora");
		nameProductions = sc.nextLine();
			
		System.out.println("Ingrese la edad mínima");
		age = sc.nextInt();
			
		System.out.println("categoria de la película");
		punto = categoryOpcion();
			
		categoryMovie = opcionCategory(punto);
			
		cBlackSnail.addMovie(index,name, nameProducer,synopsis,day,month,year, nameProductions,age,categoryMovie);
		System.out.println(cBlackSnail.getCatalog()[index].toString());
		
	}
	/**
	*Método registerSerie, permite guardar y registrar productos de tipo serie.
	*/
	public void registerSerie(){
	
		String name; 
		String nameProducer;
		String synopsis; 
		int day; 
		int month; 
		int year;
		String message;
		int quantitySeasons;
		int age; 
		int quantityProtagonist;
		String[] nameProtagonist;
		Censure censures; 
		int eleccion; 
		int index = cBlackSnail.sharePositionP();
		boolean flag = false; 
		
		sc.nextLine();
		
		do{
			System.out.println("Ingrese el nombre de la serie");
			name = sc.nextLine();
			flag = cBlackSnail.shareName(name);
		}while(flag != false);	
		
		System.out.println("Cantidad de protagonistas");
		quantityProtagonist = sc.nextInt();
					
		sc.nextLine();
		nameProtagonist = new String[quantityProtagonist];
		
		for(int i = 0; i < quantityProtagonist; i++)
		{
			System.out.println("Nombre del/la protagonistas # " + (i+1) + "\n");
			nameProtagonist[i] = sc.nextLine();
		}
		System.out.println("Ingrese el día de primera emisión");
		day = sc.nextInt();
		
		System.out.println("Ingrese el mes de primera emisión");
		month = sc.nextInt();
		
		System.out.println("Ingrese el año de primera emisión");
		year = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Ingrese el nombre del productor");
		nameProducer = sc.nextLine();
		
		System.out.println("Ingrese la sinopsis");
		synopsis = sc.nextLine();
			
		System.out.println("La serie fue censurada");
		eleccion = censureOpcion();
			
		censures = opcionCensure(eleccion);
		
		if(eleccion == 1)
		{
			System.out.println("Motivo de censura");
			message = sc.nextLine();
		}
		else
		{
			message = "La serie no fue censurada.";
		}
		System.out.println("Cantidad de temporadas");
		quantitySeasons = sc.nextInt();
		
		cBlackSnail.addSerie(index,name,nameProducer,synopsis,day,month,year,nameProtagonist,quantityProtagonist,censures,message,quantitySeasons);
		System.out.println(cBlackSnail.getCatalog()[index].toString());
		registerSeason();
	}
	/**
	*Método registerSeason, permite guardar y registrar la temporada de una serie guardada en el sistema. 
	*/
	public void registerSeason(){
		int index = cBlackSnail.sharePositionP();
		int number; 
		int episodesToProgram;
		int episodesToPublish;
		String trailer = "";
		int day;
		int month;
		int year; 
		
		System.out.println("***Registro de temporadas***");
		
		System.out.println("Número de la temporada ");
		number = sc.nextInt(); 
		
		System.out.println("Número de capítulos programados: ");
		episodesToProgram = sc.nextInt();
		
		System.out.println("Número de capítulos publicados: ");
		episodesToPublish = sc.nextInt();
		
		System.out.println("Día de estreno");
		day = sc.nextInt();
		
		System.out.println("Mes de estreno");
		month = sc.nextInt();
		
		System.out.println("Año de estreno");
		year = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Trailer");
		trailer = sc.nextLine();
	
		//System.out.println("numerito " + index);
		Serie s = (Serie)cBlackSnail.getCatalog()[index-1];
		//System.out.println(cBlackSnail.getCatalog()[index].toString());
		//System.out.println(s.toString());
		s.addSeason(number,episodesToProgram,episodesToPublish,trailer,day,month,year);
		System.out.println(s.getSeasons()[number-1].toString());
	}
	
	/**
	*Método infoProducts, muestra la información del producto ingresado por el usuario. 
	*/
	public void infoProducts(){
		String nameProduct = ""; 
		String out = "";
		String answer = ""; 
		boolean flag = false; 
		
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede mostrar la información de productos hasta que no cree e ingrese los datos del canal");
		}
		else
		{
			if(cBlackSnail.verifyProducts()!=true)
			{
				System.out.println("No exiten productos en el sistema, registrelos e intente más tarde");
			}
			else 
			{
				out = cBlackSnail.nameProducts();
				System.out.println("***Productos en el sistema***");
				System.out.println(out);
				
				do{
					System.out.println("Ingrese el nombre del producto a consultar");
					nameProduct = sc.nextLine();
					flag = cBlackSnail.shareName(nameProduct);
				}while(flag != true);
				answer = cBlackSnail.shareProducts(nameProduct);
				System.out.println(answer);
			}	
		}
	}
	/**
	*Método registerNextSeason, permite registrar las temporadas faltantes de una serie registrada en el sistema.
	*/
	public void registerNextSeason(){
		
		String list = ""; 
		String optionSerie = ""; 
		boolean flag = false; 
		boolean key = false; 
		int indexS; 
		int number; 
		int episodesToProgram;
		int episodesToPublish;
		String trailer = "";
		int day;
		int month;
		int year; 
		String stateSeason = ""; 
		if(verifyChannel()==true)
		{
			System.out.println("No se puede mostrar la información de productos hasta que no cree e ingrese los datos del canal");
		}
		else 
		{
			if(cBlackSnail.verifySeries()==true)
			{
				list = cBlackSnail.nameSeries();
				System.out.println("***Series***");
				System.out.println(list);
				
				//sc.nextLine();
				
				do{
					System.out.println("Ingrese el nombre de la serie");
					optionSerie = sc.nextLine();
					flag = cBlackSnail.shareName(optionSerie);
				}while(flag != true);
				
				indexS = cBlackSnail.shareIndex(optionSerie);
				//System.out.println("Posición " + indexS);
				
				stateSeason = cBlackSnail.informationSerie(indexS); 
				System.out.println(stateSeason);
				
				key = cBlackSnail.stateSeason(indexS);
				
				if(key==true)
				{
					System.out.println("***Registro de temporadas***");
		
					System.out.println("Número de la temporada ");
					number = sc.nextInt(); 
		
					System.out.println("Número de capítulos programados: ");
					episodesToProgram = sc.nextInt();
		
					System.out.println("Número de capítulos publicados: ");
					episodesToPublish = sc.nextInt();
		
					System.out.println("Día de estreno");
					day = sc.nextInt();
		
					System.out.println("Mes de estreno");
					month = sc.nextInt();
		
					System.out.println("Año de estreno");
					year = sc.nextInt();
		
					sc.nextLine();
		
					System.out.println("Trailer");
					trailer = sc.nextLine();
					
					Serie s = (Serie)cBlackSnail.getCatalog()[indexS];
					s.addSeason(number,episodesToProgram,episodesToPublish,trailer,day,month,year);
					System.out.println(s.getSeasons()[number-1].toString());
				}
				else
				{
					System.out.println("La serie ya tiene todas las temporadas registradas");
				}
			}
			else
			{
				System.out.println("No existen series en el programa, registre e intente más tarde");
			}
		
		}
	}
	
	/**
	*Método listMovies, muestra la lista de las peliculas según sea la elección del usuario.
	*/
	public void listMovies(){
		
		int option; 
		Category movieC; 
		String listMovies = ""; 
		
		if(verifyChannel()==true)
		{
			System.out.println("No se puede mostrar la información de productos hasta que no cree e ingrese los datos del canal");
		}
		else
		{
			if(cBlackSnail.verifyMovies()!=true)
			{
				System.out.println("No exiten películas en el sistema, registrelos e intente más tarde");
			}
			else
			{
				option = categoryOpcion();
				movieC = opcionCategory(option);
				listMovies = cBlackSnail.listMoviesForCategory(movieC);
				
				System.out.println("***Lista de películas***");
				if(listMovies.equals(""))
				{
					System.out.println("No hay películas registradas de este tipo de categoría");
				}
				else
				{
					System.out.println(listMovies);
				}	
				//System.out.println("numerito " + option + "categoria " + movieC);
				
			}
		}
	}
	
	/**
	*Método listSeries, muestra la lista de series con su última temporada
	*/
	public void listSeries(){
		
		String listSerie = ""; 
		if(verifyChannel()==true)
		{
			System.out.println("No se puede mostrar la información de productos hasta que no cree e ingrese los datos del canal");
		}
		else 
		{
			if(cBlackSnail.verifySeries()==true)
			{
				listSerie = cBlackSnail.listAllSeries(); 
				System.out.println(listSerie);
			}
			else 
			{
				System.out.println("No existen series en el programa, registre e intente más tarde");
			}	
		}	
		
	}
}