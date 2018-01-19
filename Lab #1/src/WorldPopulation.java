import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("unused")
public class WorldPopulation {
	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!

	// Lab Exercise: After creating some strategy classes -- set the default
	// strategy here.
	public WorldPopulation() {
		sortStrategy = new BubbleSort(); // Set the default strategy here.
	}

	public void readInputFile() {
		population = readPopulationFile("src//WorldPopulation.csv");
	}

	public void setStrategy(SortStrategy strategy) {
		sortStrategy = strategy;
	}

	// Lab Exercise: Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int i = 0;
			String s = br.readLine();
			while (s != null) {
				String[] s2 = s.split(",");
				population[i] = Long.parseLong(s2[2]);
				i++;
				s = br.readLine();
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("Unable to open file '" + fileName + "'");
			ex.printStackTrace();
		}
		return population;
	}

	// Lab Exercise. Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation() {
		long[] sortedResults = sortStrategy.sort(population);
		System.out.println("Sorted using \"" + sortStrategy.getStrategyName() + "\" in " + sortStrategy.getSortTime() + " miliseconds.");

	}

	public void getSortTime() {
		sortStrategy.getSortTime();
	}

	public void computeTotalPopulation() {
		long sum = 0;
		for (int i = 0; i < population.length; i++) {
			sum = sum + population[i];
		}
		System.out.println(sum);
	}

	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new InsertionSort());
		worldPopulation.sortPopulation();
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new SelectionSort());
		worldPopulation.sortPopulation();
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new BubbleSort());
		worldPopulation.sortPopulation();
	}

}
