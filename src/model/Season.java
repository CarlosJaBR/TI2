package model;

/**
*Clase Season, representa la temporada de una serie
*/
public class Season{
	
	/**
	*Número de temporada
	*/
	private int number;
	
	/**
	*Episodios programados de la temporada
	*/
	private int episodesToProgram;
	
	/**
	*Episodios publicados de la temporada
	*/
	private int episodesToPublish;
	
	/**
	*Trailer de la temporada
	*/
	private String trailer;
	
	/**
	*Fecha del estreno de la temporada
	*/
	private Date seasonDatePremiere; 
	
	/**
	*Método constructor clase Season
	*@param number int
	*@param episodesToProgram int 
	*@param episodesToPublish int
	*@param trailer String
	*@param seasonDatePremiere Date
	*/
	
	public Season(int number,int episodesToProgram, int episodesToPublish, String trailer, Date seasonDatePremiere){
		
		this.number = number;
		this.episodesToProgram = episodesToProgram;
		this.episodesToPublish = episodesToPublish;
		this.trailer = trailer;
		this.seasonDatePremiere = seasonDatePremiere;
	} 
	/**
	*Método constructor 2 clase Season
	*@param number int
	*@param episodesToProgram int 
	*@param episodesToPublish int
	*@param trailer String
	*@param day int 
	*@param month int 
	*@param year int 
	*/
	public Season(int number,int episodesToProgram, int episodesToPublish, String trailer, int day, int month, int year){
		
		this.number = number;
		this.episodesToProgram = episodesToProgram;
		this.episodesToPublish = episodesToPublish;
		this.trailer = trailer;
		seasonDatePremiere = new Date(day,month,year);
	} 
	
	//Método get y set
	
	/**
	*@return number int 
	*/
	public int getNumber(){
		return number;
	}
	
	/**
	*@param number int 
	*/
	public void setNumber(int number){
		this.number = number;
	}
	
	/**
	*@return episodesToProgram int
	*/
	public int getEpisodesToProgram(){
		return episodesToProgram;
	}
	
	/**
	*@param episodesToProgram int 
	*/
	public void setEpisodesToProgram(int episodesToProgram){
		this.episodesToProgram = episodesToProgram;
	}
	
	/**
	*@return episodesToPublish int
	*/
	public int getEpisodesToPublish(){
		return episodesToPublish;
	}
	
	/**
	*@param episodesToPublish int 
	*/
	public void setEpisodesToPublish(int episodesToPublish){
		this.episodesToPublish = episodesToPublish;
	}
	
	/**
	*@return trailer String
	*/
	public String getTrailer(){
		return trailer;
	}
	
	/**
	*@param trailer String 
	*/
	public void setTrailer(String trailer){
		this.trailer = trailer;
	}
	
	/**
	*@return seasonDatePremiere Date
	*/
	public Date seasonDatePremiere(){
		return seasonDatePremiere;
	}
	
	/**
	*@param seasonDatePremiere Date
	*/
	public void getSeasonDatePremiere(Date seasonDatePremiere){
		this.seasonDatePremiere = seasonDatePremiere;
	}
	
	//Método toString 
	/**
	*Método toString clase Season, reporta el estado de un objeto seasons
	*@return out, contiene la información del objeto.
	*/
	public String toString() {
		String out = "";
		
		out += "***Datos de la temporada***\n";
		out += "N° temporada: " + number + "\n";
		out += "Episodios programados: " + episodesToProgram + "\n";
		out += "Episodios publicados: " + episodesToPublish + "\n";
		out += "Trailer: " + trailer + "\n";
		out += "Fecha de estreno: " + seasonDatePremiere + "\n";
		
		return out;
	}
}