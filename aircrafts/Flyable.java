package za.co.wethinkcode.avaj.aircrafts;

import za.co.wethinkcode.avaj.aircrafts.*;
import za.co.wethinkcode.avaj.weather.*;

public interface Flyable {

	public Coordinates getCoordinates();
	public void updateConditions();
	public	void registerTower(WeatherTower weatherTower);
}
