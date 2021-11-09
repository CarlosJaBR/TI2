package model;

/**
*Clase Movie, guarda las películas del sistema.
*/
public class Movie extends Product{
	
	/**
	*Nombre de la productora
	*/
	private String nameProductions;
	/**
	*Edad minima para ver la película 
	*/
	private int minimumAge;
	/**
	*Categoría de la película 
	*/
	private Category categoryMovie;
	
	/**
	*Método constructor de la clase Movie 
	*@param name String 
	*@param nameProducer String 
	*@param synopsis String 
	*@param datePremiere Date
	*@param nameProductions String 
	*@param minimumAge int
	*@param categoryMovie Category
	*/
	public Movie(String name, String nameProducer, String synopsis, Date datePremiere ,String nameProductions, int minimumAge, Category categoryMovie){
		
		super(name,nameProducer,synopsis,datePremiere); 
	
		this.nameProductions = nameProductions;
		this.minimumAge = minimumAge;
		this.categoryMovie = categoryMovie;
	}
	/**
	*Método constructor 2 de la clase Movie 
	*@param name String 
	*@param nameProducer String 
	*@param synopsis String 
	*@param day int
	*@param month int 
	*@param year int 
	*@param nameProductions String 
	*@param minimumAge int
	*@param categoryMovie Category
	*/
	public Movie(String name, String nameProducer, String synopsis, int day, int month, int year ,String nameProductions, int minimumAge, Category categoryMovie){
		
		super(name,nameProducer,synopsis,day,month,year); 
	
		this.nameProductions = nameProductions;
		this.minimumAge = minimumAge;
		this.categoryMovie = categoryMovie;
	}
	//Método get y set
	
	/**
	*@return nameProductions String 
	*/
	public String getNameProductions(){
		return nameProductions; 
	}
	/**
	*@param nameProductions String 
	*/
	public void setNameProductions(String nameProductions){
		this.nameProductions = nameProductions;
	}
	/**
	*@return minimumAge int 
	*/
	public int getMinimumAge(){
		return minimumAge;
	}
	/**
	*@param minimumAge int 
	*/
	public void setMinimumAge(int minimumAge){
		this.minimumAge = minimumAge;
	}
	/**
	*@return categoryMovie Category
	*/
	public Category getCategoryMovie(){
		return categoryMovie;
	}
	/**
	*@param categoryMovie Category
	*/
	public void setCategoryMovie(Category categoryMovie){
		this.categoryMovie = categoryMovie;
	}
	/**
	*Método toString, contiene la información de un objeto movie
	*@return out String
	*/
	public String toString(){
		String out = "";
		
		out += "***Datos de la película***\n";
		out += "Nombre: " + name + "\n"; 
		out += "Nombre del producto: "+ nameProducer + "\n";
		out += "Sinopsis: " + synopsis + "\n"; 
		out += "Fecha de estreno: " + datePremiere + "\n"; 
		out += "Nombre de la productora: " + nameProductions + "\n"; 
		out += "categoria: " + categoryMovie + "\n"; 
		return out; 
	}
	//MUY IMPORTANTE LA ETIQUETA :) 
	@Override 
	public String exampleClase(int par){
		String out = "Esta es una película " + par;
		return out; 
	}
}