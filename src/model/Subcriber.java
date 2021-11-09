package model;

/**
*Subcriber class, permite instanciar objetos de tipo Subcriber, contiene enumeración, State y Type
*/
public class Subcriber{

	/**
	* identificationNumber String, guarda el número de identificación de un suscriptor.
	*/
	private String identificationNumber;
	
	/**
	* fullName String, guarda el nombre del suscriptor.
	*/
	private String fullName;
	
	/**
	* age int, guarda la edad de un suscriptor.
	*/
	private int age;
	
	/**
	* hoursConsume int, guarda las horas que un suscriptor está dispuesto a consumir en contenido
	*streaming.
	*/
	private int hoursConsume;
	
	/**
	* typeClient Type, guarda el tipo de cliente, propiedad especial de un suscriptor.
	*/
	private Type typeClient;
	
	/**
	*stateClient State, guarda el estado de un cliente, propiedad especial de un suscriptor, 
	*Activo si mantiene una conexión constante con la plaforma e inactivo sino frecuenta tanto el programa.
	*/
	private State stateClient;
	
	/**
	*Método constructor de la clase Subcriber.
	*@param identificationNumber String
	*@param fullName String
	*@param age int 
	*@param hoursConsume int
	*@param typeClient Type
	*@param stateClient State
	*/
	public Subcriber(String identificationNumber, String fullName, int age, int hoursConsume, Type typeClient, State stateClient){
		
		this.identificationNumber=identificationNumber;
		this.fullName=fullName;
		this.age=age;
		this.hoursConsume=hoursConsume;
		this.typeClient=typeClient;
		this.stateClient=stateClient;
	}
	
	//****Métodos get y set****
	
	/**
	* @return identificationNumber String 
	*/
	public String getIdentificationNumber(){
		return identificationNumber;
	}
	
	/**
	*@param identificationNumber String 
	*/
	public void setIdentificationNumber(String identificationNumber){
		this.identificationNumber = identificationNumber;
	}
	
	/**
	*@return fullName String 
	*/
	public String getFullName(){
		return fullName;
	}
	
	/**
	*@param fullName String 
	*/
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
	
	/**
	*@return age int
	*/
	public int getAge(){
		return age;
	}
	
	/**
	*@param age int 
	*/
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	*@return hoursConsume int 
	*/
	public int getHoursConsume(){
		return hoursConsume;
	}
	
	/**
	*@param hoursConsume int 
	*/
	public void setHoursConsume(int hoursConsume){
		this.hoursConsume = hoursConsume;
	}
	
	/**
	*@return typeClient Type 
	*/
	public Type getTypeClient(){
		return typeClient;
	}
	
	/**
	*@param typeClient Type 
	*/
	public void setTypeClient(Type typeClient){
		this.typeClient = typeClient;
	}
	
	/**
	*@return stateClient State
	*/
	public State getStateClient(){
		return stateClient;
	}
	
	/**
	*@param stateClient State
	*/
	public void setStateClient(State stateClient){
		this.stateClient = stateClient;
	}

}