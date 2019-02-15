package za.co.wethinkcode.avaj.weather;

import za.co.wethinkcode.avaj.aircrafts.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public	class	Simulator {
	public static PrintWriter writer;

	public static void main(String[] arg) throws InterruptedException {
		WeatherTower weatherTower;
		try {
			List<Flyable> flyables = new ArrayList<Flyable>();
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			File simulationFile = new File("simulation.txt");
			writer = new PrintWriter(simulationFile);

			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
						AircraftFactory.newAircraft(
							line.split(" ")[0],
							line.split(" ")[1],
							Integer.parseInt(line.split(" ")[2]),
							Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4])
						).registerTower(weatherTower);
				}

				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
				writer.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify simulation file");
		} catch (NullPointerException e) {
		 	System.out.println("value is null " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("not a valid number entered in file");
		} finally {
			writer.close();
		}
	}
}
