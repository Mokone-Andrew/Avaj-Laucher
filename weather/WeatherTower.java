package za.co.wethinkcode.avaj.weather;

import za.co.wethinkcode.avaj.weather.*;
import za.co.wethinkcode.avaj.aircrafts.*;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
	void	changeWeather() {
		conditionsChanged();
	}
}
