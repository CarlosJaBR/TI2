package model;

/**
*Clase product, es una clase abstracta
*/
public abstract class Product{
	
	/**
	*nombre del producto
	*/
	protected String name;
	/**
	*nombre del productor
	*/
	protected String nameProducer;
	/**
	*sinopsis del producto
	*/
	protected String synopsis;
	/**
	*fecha de estreno 
	*/
	protected Date datePremiere;
	
	/**
	*Método constructor de la clase Product
	*@param name String
	*@param nameProducer String 
	*@param synopsis String
	*@param datePremiere Date
	*/
	public Product(String name, String nameProducer, String synopsis, Date datePremiere){
		
		this.name = name;
		this.nameProducer = nameProducer;
		this.synopsis = synopsis;
		this.datePremiere = datePremiere;
	}
	/**
	*Método constructor 2 de la clase Product
	*@param name String
	*@param nameProducer String 
	*@param synopsis String
	*@param day int 
	*@param month int 
	*@param year int 
	*/
	public Product(String name, String nameProducer, String synopsis, int day, int month, int year){
		
		this.name = name;
		this.nameProducer = nameProducer;
		this.synopsis = synopsis;
		datePremiere = new Date(day,month,year);
	}
	//Método abstract
	/**
	*@param par int 
	*/
	public abstract String exampleClase(int par);
	//Métodos get y set
	/**
	*@return name String
	*/
	public String getName(){
		return name;
	}
	/**
	*@param name String 
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	*@return nameProducer String 
	*/
	public String getNameProducer(){
		return nameProducer;
	}
	/**
	*@param nameProducer String 
	*/
	public void setNameProducer(String nameProducer){
		this.nameProducer = nameProducer;
	}
	/**
	*@return synopsis String
	*/
	public String getSynopsis(){
		return synopsis;
	}
	/**
	*@param synopsis String 
	*/
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}
	/**
	*@return datePremiere Date
	*/
	public Date getDatePremiere(){
		return datePremiere;
	}
	/**
	*@param datePremiere Date
	*/
	public void setDatePremiere(Date datePremiere){
		this.datePremiere = datePremiere;
	}
}