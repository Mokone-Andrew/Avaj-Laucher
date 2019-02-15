package za.co.wethinkcode.avaj.aircrafts;

import za.co.wethinkcode.avaj.aircrafts.*;

public class Aircraft{

  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 1 ;

  protected Aircraft(String name, Coordinates coordinates){

    this.coordinates = coordinates;
    this.name = name;
    this.idCounter = nextId();
    this.id = nextId();
  }
  private long nextId(){
	  id = idCounter++;
    return (id);
  }
  public	Coordinates getCoordinates() {
		return this.coordinates;
	}
}
