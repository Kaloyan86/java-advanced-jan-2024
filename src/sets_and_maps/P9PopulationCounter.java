package sets_and_maps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P9PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Map<country, Map<city, population>>
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        // Map<country, totalPopulation>
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());

            countriesTotalPopulation.putIfAbsent(country, 0L);

            Long currentPopulation = countriesTotalPopulation.get(country);
            countriesTotalPopulation.put(country, currentPopulation + population);

            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countriesTotalPopulation
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(entry -> {
            System.out.printf("%s (total population: %d)\n",
                              entry.getKey(),
                              entry.getValue());
            countries.get(entry.getKey())
                     .entrySet()
                     .stream()
                     .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                     .forEach((pair) -> {
                         System.out.printf("=>%s: %d\n", pair.getKey(), pair.getValue());
                     });
        });

    }

    static class City {

        private String name;
        private long population;

        public City(String name, long population) {
            this.name = name;
            this.population = population;
        }

        @Override
        public String toString() {
            //TODO implement proper toString method
            return String.format("=>%s: %d", name, population);
        }
    }

    static class Country {

        private String name;
        private List<City> cities;

        public Country(String name) {
            this.name = name;
            this.cities = new LinkedList<>();
        }

        public long getTotalPopulation() {
            long totalPopulation = 0;
            for (City city : cities) {
                totalPopulation += city.population;
            }
            return totalPopulation;
        }

        @Override
        public String toString() {
            return String.format("%s (total population: %d)", name, getTotalPopulation());
        }
    }
}
