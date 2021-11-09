package model; 
/**
*Channel class, instancia objetos de tipo Channel y contiene a los suscriptores
*/
public class Channel{
	/**
	* nit String, guarda el nit de el canal.
	*/
	private String nit;
	
	/**
	* address String, guarda la dirección del centro de atención y/u operaciones. 
	*/
	private String address;
	
	/**
	* website String, guarda el link de la página web del canal. 
	*/
	private String website;
	
	/**
	* subcribers Subcriber[], guarda cada uno de los objetos de tipo Subcriber.
	*/
	private Subcriber[] subcribers;
	
	/**
	*quantitySubcriber int, tiene la cantidad de usuarios límite que se puede registrar.
	*/
	private int quantitySubcriber = 50;
	
	//private Catalog catalogs;
	
	/**
	*Película  
	*/
	private Movie movie;
	/**
	*Serie
	*/
	private Serie serie;
	
	private static final int SIZE = 85;
	
	private Product[] catalog;
	
	/**
	*Método constructor de la clase Channel
	*@param nit String
	*@param address String
	*@param website String 
	*/
	public Channel(String nit, String address, String website){
		
		this.nit = nit;
		this.address = address;
		this.website = website;
		subcribers = new Subcriber[50];
		catalog = new Product[SIZE];
		
	}
	//Método agregar subcriber 
	
	/**
	*Método addSubcriber, crea y agrega Suscriptores 
	*@param posicion int
	*@param identificationNumber String
	*@param fullName String
	*@param age int 
	*@param hoursConsume int 
	*@param typeClient Type
	*@param stateClient State
	*/
	public void addSubcriber(int posicion, String identificationNumber, String fullName, int age, int hoursConsume, Type typeClient, State stateClient){
		subcribers[posicion] = new Subcriber(identificationNumber, fullName, age, hoursConsume,typeClient,stateClient);
	}
	//Verificar espacios 
	/**
	*Método sharePosition, busca una posicion vacia en el arreglo se subcribers para que el 
	*proximo suscriptor a crear sea guardado en esa posición 
	@return out int, contiene la posicion vacia donde crear el nuevo suscriptor
	*/
	public int sharePosition(){
		
		int out = -1; 
		boolean terminar = false; 
		for(int i = 0; i < subcribers.length && !terminar; i++)
		{
			if(subcribers[i]==null)
			{
				out = i; 
				terminar = true;
			}
		}
		return out; 
	}
	//Verificar si ya existe un subcriber con la misma cédula 
	
	/**
	*Método verifySubcriber, este método verifica si en la base de datos del sistema ya existe 
	*un número de identificación, y si es el caso impide la creación de otro suscriptor con el mismo número de documento.
	*@param identificacion String, contiene el número de identificacion que del suscriptor a registrar
	*@return keep boolean, retorna false si no hay un documento igual y true en caso contrario
	*/
	public boolean verifySubcriber(String identificacion){
		
		boolean keep = false;  
		boolean cerrar  = false;  
		for(int i = 0; i < subcribers.length && !cerrar; i++)
		{
			if(subcribers[i]!=null)
			{
				if(identificacion.equals(subcribers[i].getIdentificationNumber()))
				{
					keep = true; 
					cerrar = true;
				}
			}	
		}
		return keep;
	}
	//****Métodos get y set****
	
	/**
	*@return nit String 
	*/
	public String getNit(){
		return nit;
	}
	
	/**
	*@param nit String 
	*/
	public void setNit(String nit){
		this.nit=nit;
	}
	
	/**
	*@return address String 
	*/
	public String getAddress(){
		return address;
	}
	
	/**
	*@param address String 
	*/
	public void setAddress(String address){
		this.address =address;
	}
	
	/**
	*@return website String 
	*/
	public String getWebsite(){
		return website;
	}
	
	/**
	*@param website String 
	*/
	public void setWebsite(String website){
		this.website =website ;
	}
	
	/**
	*@return subcribers Subcriber[]
	*/
	public Subcriber[] getSubcribers(){
		return subcribers;
	}
	
	/**
	*@param subcribers Subcriber[]
	*/
	public void setSubcribers(Subcriber[] subcribers){
		this.subcribers = subcribers;
	}
	
	/**
	*@return quantitySubcriber int  
	*/
	public int getQuantitySubcriber(){
		return quantitySubcriber;
	}
	
	/**
	*@param quantitySubcriber int 
	*/
	public void setQuantitySubcriber(int quantitySubcriber){
		this.quantitySubcriber = quantitySubcriber;
	}
	
	//Método información de los usuarios
	
	/**
	*Método suscriptorsInfo, retorna la informción de un suscriptor que se acaba de crear
	*@param index int, la posición donde de acaba de crear el suscriptor
	*@return information String, contiene la información del suscriptor
	*/
	public String suscriptorsInfo(int index){ 
		
		String information = ""; 
		information += "***Datos del suscriptor creado***\n";
		information += "Posicion: " +  index + "\n";
		information += "Identificacion: " + subcribers[index].getIdentificationNumber() + "\n"; 
		information += "Nombre: " + subcribers[index].getFullName() + "\n"; 
		information += "Edad: " + subcribers[index].getAge() + "\n"; 
		information += "Horas dispuesto a consumir: " + subcribers[index].getHoursConsume() + "\n"; 
		information += "Tipo de suscriptor: " + subcribers[index].getTypeClient() + "\n";
		information += "Estado del suscriptor: " + subcribers[index].getStateClient() + "\n";
		return information; 
		//this.typeClient=typeClient;
		//this.stateClient=stateClient;
	}
	/**
	*Método listSuscriptor, retorna la lista de suscriptor que están registrados en el sistema
	*@return list String, contiene la lista de suscriptores
	*/
	public String listSuscriptor(){
		
		String list = ""; 
		
		for(int i = 0; i < subcribers.length; i++)
		{
			if(subcribers[i]!=null)
			{
				list += "Nombre del suscriptor: " + subcribers[i].getFullName() + "\n";
				list += "Identificacion: " + subcribers[i].getIdentificationNumber() + "\n";
				list += "Identificador en el sistema " + i + "\n";
			}
		}
		return list; 
	}
	/**
	*Método verifySubcriberInSystem, verifica la existencia de suscriptores en el sistema
	*@return out boolean, retorna false si no existen suscriptores, retorna true en caso contrario.
	*/
	public boolean verifySubcriberInSystem(){
		
		boolean out = false; 
		
		for(int i = 0; i < subcribers.length; i++)
		{
			out = out || subcribers[i]!=null; 
		}
		return out; 
	}
	/**
	*Método editState, este método modifica el estado de un suscriptor
	*@param id int, identificador del suscriptor en el sistema
	*/
	public void editState(int id){
		
		State stateSubcriber = State.INACTIVO; 
		subcribers[id].setStateClient(stateSubcriber);
	}
	
	/**
	*Método editType, este método modifica el tipo de un suscriptor a NORMAL al momento de cambiar su estado.
	*@param id int, identificador del suscriptor en el sistema
	*/
	public void editType(int id){
		
		Type typeSubcriber = Type.NORMAL;
		subcribers[id].setTypeClient(typeSubcriber);
	}
	
	/**
	*Método listSubcriberActivate, es un método que busca entre los cantidad de suscriptores activos 
	*la cantidad que pertenece a todos los tipos predeterminados en el sistema
	*@return out String, contiene la lista con la cantidad de suscriptores activos en cada tipo de suscriptores
	*/
	
	public String listSubcriberActivate(){
		
		int cantidadNormal = 0;
		int cantidadPlatino = 0;
		int cantidadOro = 0;
		int cantidadDiamante = 0; 
		
		String out = "";
		
		for(int i = 0; i < subcribers.length; i++)
		{
			if(subcribers[i]!=null)
			{
				if(subcribers[i].getStateClient()==State.ACTIVO && subcribers[i].getTypeClient()==Type.NORMAL)
				{
					cantidadNormal += 1;
				}	
				if(subcribers[i].getStateClient()==State.ACTIVO && subcribers[i].getTypeClient()==Type.PLATINO)
				{
					cantidadPlatino += 1;
				}
				if(subcribers[i].getStateClient()==State.ACTIVO && subcribers[i].getTypeClient()==Type.ORO)
				{
					cantidadOro += 1;
				}
				if(subcribers[i].getStateClient()==State.ACTIVO && subcribers[i].getTypeClient()==Type.DIAMANTE)
				{
					cantidadDiamante += 1;
				}
			}
		}
		out += "NORMAL:   " + cantidadNormal + "\n";
		out += "PLATINO:  " + cantidadPlatino + "\n";
		out += "ORO:      " + cantidadOro + "\n";
		out += "DIAMANTE: " + cantidadDiamante + "\n";
 		
		return out; 
	}
	
	
	/**
	*Método nameSubcriberMoreHours, este método busca el menor de edad con el 
	*mayor número de horas dispuesto a consumir contenido Streaming.
	*@return outList String, contiene el nombre del menor de edad.
	*/
	public String nameSubcriberMoreHours(){
		
		String outList = ""; 
		boolean cerrarB = false; 
		int cantidadMayor = 0;
		int posicion = 0; 
		
		for(int i = 0; i < subcribers.length && !cerrarB; i++)
		{
			if(subcribers[i]!=null)
			{
				if(subcribers[i].getAge()<18)
				{
					cantidadMayor = subcribers[i].getHoursConsume();
					posicion = i; 
					cerrarB = true; 
				}
			}
		}
		for(int i = 0; i < subcribers.length; i++)
		{
			if(subcribers[i]!=null)
			{
				if(subcribers[i].getAge()<18 && subcribers[i].getHoursConsume()>cantidadMayor)
				{
					cantidadMayor = subcribers[i].getHoursConsume();
					posicion = i; 
				}
			}
		}
		if(subcribers[posicion].getAge()<18)
		{
			outList = "Nombre del suscriptor: " + subcribers[posicion].getFullName();
		}
		else 
		{
			outList = "No hay menores de edad en el sistema";
		}
		return outList;
	}
	/**
	*Método addMovie
	*@param index int
	*@param name String 
	*@param nameProducer String
	*@param synopsis String
	*@param day int 
	*@param month int 
	*@param year int 
	*@param nameProductions String 
	*@param minimumAge int 
	*@param categotyMovie Category
	*/
	public void addMovie(int index, String name, String nameProducer, String synopsis, int day, int month, int year, String nameProductions, int minimumAge, Category categotyMovie){
		
		catalog[index] = new Movie(name, nameProducer,synopsis,day,month,year,nameProductions,minimumAge,categotyMovie);
	}
	
	/**
	*@param index int 
	*@param name String 
	*@param nameProducer String 
	*@param synopsis String 
	*@param day int 
	*@param month int 
	*@param year int 
	*@param nameProtagonist String[]
	*@param quantityProtagonist int 
	*@param censures Censure
	*@param message String 
	*@param quantitySeasons int 
	*/
	public void addSerie(int index, String name, String nameProducer, String synopsis,int day, int month, int year,String[] nameProtagonist, int quantityProtagonist, Censure censures,String message, int quantitySeasons){
		catalog[index] = new Serie(name,nameProducer,synopsis,day,month,year,nameProtagonist,quantityProtagonist,censures,message,quantitySeasons);
	}
	
	//Método get y set
	/**
	*@return movie Movie 
	*/
	public Movie getMovie(){
		return movie;
	}
	/**
	*@param movie Movie 
	*/
	public void setMovie(Movie movie){
		this.movie = movie;
	}
	
	/**
	*@return serie Serie 
	*/
	public Serie getSerie(){
		return serie;
	}
	/**
	*@param serie Serie 
	*/
	public void setSerie(Serie serie){
		this.serie = serie;
	}
	
	/**
	*Método sharePositionP, este método busca una posición vacia en el arreglo catalog
	*para ahí sea guardado el nuevo producto registrado.
	*@return position int, posición en la que el producto se va a crear.
	**/
	public int sharePositionP(){
		int position = -1;
		boolean flag = false;
		
		for(int i = 0; i < catalog.length && !flag; i++)
		{
			if(catalog[i]==null)
			{
				position = i;
				flag = true;
			}
		}
		return position;
	}
	
	/**
	*@return catalog Product[]
	*/
	public Product[] getCatalog(){
		return catalog;
	}
	
	/**
	*@param catalog Product[]
	*/
	public void setCatalog(Product[] catalog){
		this.catalog = catalog;
	}
	/**
	*Método nameProducts, retorna la lista de los productos creados y guardados en el sistema.
	*@return out String, cadena con los nombres de los productos.
	*/
	public String nameProducts(){
		String out = "";
		
		for(int i = 0; i < catalog.length; i++)
		{
			if(catalog[i]!=null)
			{
				out += "* " + catalog[i].getName() + "\n"; 
			}
		}
		return out; 
	}
	
	/**
	*Método verifyProducts, verifica la existencia de productos en el sistema.
	*@return flag boolean, retorna false si no hay productos, retorna true si existen en el sistema. 
	*/
	public boolean verifyProducts(){
		boolean flag = false; 
		
		for(int i = 0; i < catalog.length; i++)
		{
			flag = flag || catalog[i]!=null; 
		}
		return flag; 
	}
	/**
	*Método shareProducts, busca en producto especifico en la colección de productos y muestra la información al usuario.
	*@param nameProduct String, nombre ingresado por el usuario. 
	*@return out String, información del producto ingresado por el usuario. 
	*/
	public String shareProducts(String nameProduct){
		
		String nameShare = nameProduct; 
		String out = ""; 
		for(int i = 0; i < catalog.length; i++)
		{
			if(catalog[i]!=null)
			{
				if(catalog[i].getName().equalsIgnoreCase(nameShare))
				{
					if(catalog[i] instanceof Movie)
					{
						out = catalog[i].toString();
					}
					if(catalog[i] instanceof Serie)
					{
						out = catalog[i].toString();
					}
				}
			}
		}
		return out; 
	}
	/**
	*Método shareName, busca la existencia del nombre de un producto en el sistema.
	*@param nameProduct String, nombre ingresado por el usuario. 
	*@return out boolean, false si no hay existencia del nombre, true si ya existe.  
	*/
	public boolean shareName(String nameProduct){
		String nameShare = nameProduct; 
		boolean out = false; 
		for(int i = 0; i < catalog.length && !out; i++)
		{
			if(catalog[i]!=null)
			{
				if(nameShare.equalsIgnoreCase(catalog[i].getName()))
				{
					out = true; 
				}
			}
		}	
		return out; 
	}
	/**
	*Método nameSeries, crea una lista con todos los nombres de las series registradas en el sistema. 
	*@return infoName String, lista con los nombres de las series registradas. 
	*/
	public String nameSeries(){
		String infoName = "";
		
		for(int i = 0; i<catalog.length;i++)
		{
			if(catalog[i] instanceof Serie)
			{
				infoName += "* " + catalog[i].getName() + "\n"; 
			}
		}
		return infoName; 
	}
	/**
	*Método verifySeries, verifica la existencia de series en el sistema.
	*@return flag boolean, false si no existen series en sistema, true en el caso de que si existan.
	*/
	public boolean verifySeries(){
		boolean flag = false; 
		
		for(int i = 0; i < catalog.length && !flag; i++)
		{
			if(catalog[i]!=null && catalog[i] instanceof Serie)
			{
				flag = true; 
			}
		}
		return flag; 
	}
	/**
	*Método shareIndex, busca la posición de la serie ingresada
	*@param nameProduct String, nombre del la serie. 
	*@return index int, posición de la serie. 
	*/
	public int shareIndex(String nameProduct){
		int index = -1;
		String name = nameProduct; 
		boolean flag = false; 
		for(int i = 0; i<catalog.length && !flag; i++){
			if(catalog[i]!=null && catalog[i] instanceof Serie)
			{
				if(nameProduct.equalsIgnoreCase(catalog[i].getName()))
				{
					index = i; 
					flag = true; 
				}
			}
		}
		return index; 
	}
	
	/**
	*Método informationSerie, retorna la información del registro de las temporadas de una serie.
	*@param position int, posición del arreglo catalog.
	*@return info String, esto de las temporadas. 
	*/
	public String informationSerie(int position){
		
		int index = position; 
		String info = ""; 
		Serie s = (Serie) catalog[index];
		info += "Cantidad de temporadas " + s.getQuantitySeasons() + "\n";
		
		for(int i = 0; i < s.getQuantitySeasons(); i++)
		{
			if(s.getSeasons()[i]!=null)
			{
				info += "Temporada " + (i+1) + ":" + " registrada\n"; 
			}
			else
			{
				info += "Temporada " + (i+1) + ":" + " sin registrar\n";
			}
		}
		return info; 
	}
	/**
	*Método stateSeason, verifica si hay espacio para crear temporadas en una serie.
	*@param position int, posición del arreglo catalog. 
	*@return flag boolean, retorna false si no hay espacio, true en caso de que si haya espacio. 
	*/
	public boolean stateSeason(int position){
		boolean flag = false; 
		int index = position; 
		Serie s = (Serie) catalog[index];
		for(int i = 0; i < s.getQuantitySeasons(); i++)
		{
			flag = flag || s.getSeasons()[i]==null; 
		}
		return flag; 
	}
	/**
	*Método verifyMovies, verifica la existencia de movies en el sistema. 
	*@return flag boolean, false si no existen, true si hay movies en el sistema.
	*/
	public boolean verifyMovies(){
		boolean flag = false; 
		
		for(int i = 0; i < catalog.length && !flag; i++)
		{
			if(catalog[i]!=null && catalog[i] instanceof Movie)
			{
				flag = true; 
			}
		}
		return flag; 
	}
	/**
	*Método listMoviesForCategory, crea la lista de las películas según la categoría que ingrese el usuario. 
	*@param movieC Category, categoría elegida por el usuario.
	*@return listM String, lista de películas.
	*/
	public String listMoviesForCategory(Category movieC){
		
		Category option = movieC;
		String listM = ""; 
		Movie m; 
		
		for(int i = 0; i < catalog.length; i++)
		{
			if(catalog[i] instanceof Movie)
			{
				m = (Movie)catalog[i];
				if(m.getCategoryMovie()==option)
				{
					listM += " * " + catalog[i].getName() + "\n";
				}
			}
		}
		return listM; 
	}
	
	/**
	*Método listAllSeries, hace una lista de todas las series con su ultima temporada registrada. 
	*@return out String, lista de las series con su respectiva temporada.
	*/
	public String listAllSeries(){
		
		String out = ""; 
		Serie s; 
		boolean flag = false; 
		
		for(int i = 0; i<catalog.length;i++)
		{
			if(catalog[i] instanceof Serie)
			{
				s = (Serie)catalog[i]; 
				out += s.getName() + "\n";
				for(int j = s.getQuantitySeasons()-1; j>=0 && !flag; j--)
				{
					if(s.getSeasons()[j]!=null)
					{
						out += s.getSeasons()[j].toString() + "\n"; 
						flag = true; 
					}
				}
				flag = false; 
			}
		}
		return out; 
	}
}