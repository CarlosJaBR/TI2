package model;

/**
*Clase Serie, guarda cada una las series que posee el catálogo.
*/
public class Serie extends Product{

	///**
	//*Fecha de trasmisión 
	//*/
	//private Date dateBroadcast;
	/**
	*Cantidad de protagonistas. 
	*/
	private int quantityProtagonist;
	/**
	*Nombre de los protagonistas. 
	*/
	private String[] nameProtagonist;
	/**
	*Fue censurada
	*/
	private Censure censures;
	/**
	*Motivo por el que fue censurada
	*/
	private String message;
	/**
	*Número de temporadas 
	*/
	private int quantitySeasons;
	/**
	*Arreglo de temporadas
	*/
	private Season[] seasons;
	
	
	
	/**
	*Método constructor de la clase Serie
	*@param name String
	*@param nameProducer String 
	*@param synopsis String 
	*@param datePremiere Date
	*@param nameProtagonist String[]
	*@param quantityProtagonist int 
	*@param censures Censure
	*@param message String
	*@param quantitySeasons int 
	*/
	public Serie(String name, String nameProducer, String synopsis,Date datePremiere, String[] nameProtagonist, int quantityProtagonist, Censure censures,String message, int quantitySeasons){
		
		super(name,nameProducer,synopsis,datePremiere);
		this.quantityProtagonist = quantityProtagonist;
		this.nameProtagonist = nameProtagonist;
		nameProtagonist = new String[quantityProtagonist];
		this.censures = censures;
		this.message = message;
		this.quantitySeasons = quantitySeasons;
		
		seasons = new Season[quantitySeasons];
		
	}
	/**
	*Método constructor 2 de la clase Serie
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
	public Serie(String name, String nameProducer, String synopsis,int day, int month, int year, String[] nameProtagonist, int quantityProtagonist, Censure censures,String message, int quantitySeasons){
		
		super(name,nameProducer,synopsis,day,month,year);
		
		this.quantityProtagonist = quantityProtagonist;
		this.censures = censures;
		this.message = message;
		this.quantitySeasons = quantitySeasons;
		this.nameProtagonist = nameProtagonist;
		
		seasons = new Season[quantitySeasons];
		
	}
	
	//Métodos get y set 
	
	/**
	*@return censures Censure; 
	*/
	public Censure getCensures(){
		return censures;
	}
	/**
	*@param censures Censure 
	*/
	public void setCensures(Censure censures){
		this.censures = censures;
	}
	/**
	*@return message String 
	*/
	public String getMessage(){
		return message; 
	}
	/**
	*@param message String 
	*/
	public void setMessage(String message){
		this.message = message;
	}
	/**
	*@return seasons Season[]
	*/
	public Season[] getSeasons(){
		return seasons; 
	}
	/**
	*@param seasons Season[]
	*/
	public void setSeason(Season[] seasons){
		this.seasons = seasons;
	}
	/**
	*@return nameProtagonist String[]
	*/
	public String[] getNameProtagonist(){
		return nameProtagonist;
	}
	/**
	*@param nameProtagonist String[]
	*/
	public void setNameProtagonist(String[] nameProtagonist){
		this.nameProtagonist = nameProtagonist;
	}
	/**
	*@return quantitySeasons int 
	*/
	public int getQuantitySeasons(){
		return quantitySeasons;
	}
	/**
	*@param quantitySeasons int 
	*/
	public void setQuantitySeasons(int quantitySeasons){
		this.quantitySeasons = quantitySeasons;
	}
	
	/**
	*Método toString, contiene la información de un objeto serie
	*@return out String
	*/
	public String toString(){
		String out = "";
		
		out += "***Datos de la serie***\n";
		out += "Nombre: " + name + "\n"; 
		out += "Nombre de los protagonistas: " + namesP() + "\n";
		out += "Fecha de estreno: " + datePremiere + "\n";
		out += "Nombre del productor: "+ nameProducer + "\n";
		out += "Sinopsis: " + synopsis + "\n";  
		out += "Censurada: " + censures + "\n";
		out += "Motivo: "+ message + "\n"; 
		out += "cantidad de temporadas: " + quantitySeasons + "\n";
		return out; 
	}
	@Override
	public String exampleClase(int par){
		String out = "Esta es una serie " + (par+10); 
		return out; 
	}
	/**
	*Método addSeason
	*@param number int 
	*@param episodesToProgram int 
	*@param episodesToPublish int 
	*@param trailer String 
	*@param day int 
	*@param month int 
	*@param year int 
	*/
	public void addSeason(int number,int episodesToProgram, int episodesToPublish,String trailer,int day,int month,int year){
		
		seasons[number-1] = new Season(number,episodesToProgram,episodesToPublish,trailer,day,month,year);
	}
	/**
	*Método positionSeason, retorna la posición de una temporada
	*@return index positionSeason
	*/
	public int positionSeason(){
		int index = -1;
		for(int i = 0; i < quantitySeasons; i++)
		{
			if(seasons[i]==null)
			{
				index = i; 
			}
		}
		return index; 
	}
	/**
	*Método namesP, asigna al arreglo los nombres de los protagonistas de una serie.
	*@return out String, lista de nombres 
	*/
	public String namesP(){
		String out = "";
		for(int i = 0; i < nameProtagonist.length; i++)
		{
			out += nameProtagonist[i] + ",";
		}
		return out; 
	}
}