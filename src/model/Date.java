package model;
/**
*Clase Date, implementada para organizar y manegar de manera profesional la fecha de el sistema.
*/
public class Date{

	/**
	* Guarda el día.
	*/
	private int day;
	
	/**
	*Guarda el mes. 
	*/
	private int month;
	
	/**
	*Guarda el año. 
	*/
	private int year;
	
	/**
	*Método constructor de clase Date.
	*@param day int
	*@param month int
	*@param year int 
	*/
	public Date(int day, int month, int year) {
		this.day= day;
		this.month= month;
		this.year = year;
	}
	/**
	*@return day int
	*/
	public int getDay() {
		return day;
	}
	
	/**
	*@param pday int 
	*/
	public void setDay(int pday) {
		this.day = pday;
	}
	
	/**
	*@return month int 
	*/
	public int getMonth() {
		return month;
	}
	
	/**
	*@param pmonth int
	*/
	public void setMonth(int pmonth) {
		this.month = pmonth;
	}
	
	/**
	*@return year int
	*/
	public int getYear() {
		return year;
	}
	
	/**
	*@param pyear int
	*/
	public void setYear(int pyear) {
		this.year = pyear;
	}
	
	/**
	*@return day +"/" + month + "/" + year String
	*/
	public String toString() {
		return day +"/" + month + "/" + year;
	}
}