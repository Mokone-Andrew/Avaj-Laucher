package za.co.wethinkcode.avaj.aircrafts;

import	za.co.wethinkcode.avaj.weather.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public	void	updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): AHH ITS A BEAUTIFUL DAY!");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): TURN ON THE WINDSHIELD WIPERS");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): ITS GETTING FOGGY IM SCARED!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): OH GOD ITS FREEZING UP HERE");
			break;
			default:
			Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): THE WEATHERTOWER ISN'T RESPONDING");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
			Simulator.writer.println("Tower  says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	public	void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
		weatherTower.register(this);
	}

}
