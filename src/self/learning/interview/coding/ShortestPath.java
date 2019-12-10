package self.learning.interview.coding;

import java.util.*;

public class ShortestPath {
    /**
     * Represents Station in the rail network. Each station is identified by unique name.
     * Station is connected with other stations - this information is stored in the 'neighbours' field.
     * Two station objects with the same name are equal therefore they are considered to be same station.
     */
    private static class Station {
        private String name;
        private List<Station> neighbours;

        Station(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>(3);
        }

        String getName() {
            return name;
        }

        void addNeighbour(Station v) {
            this.neighbours.add(v);
        }

        List<Station> getNeighbours() {
            return this.neighbours;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Station && this.name.equals(((Station) obj).getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }
    }

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2 stations
     * is of same constant distance unit. This implies that shortest distance between any
     * 2 stations depends only on number of stations in between
     */
    private static class TrainMap {

        private HashMap<String, Station> stations;

        TrainMap() {
            this.stations = new HashMap<>();
        }

        TrainMap addStation(String name) {
            Station s = new Station(name);
            this.stations.putIfAbsent(name, s);
            return this;
        }

        Station getStation(String name) {
            return this.stations.get(name);
        }

        TrainMap connectStations(Station fromStation, Station toStation) {
            if (fromStation == null) throw new IllegalArgumentException("From station is null");
            if (toStation == null) throw new IllegalArgumentException("From station is null");

            fromStation.addNeighbour(toStation);
            toStation.addNeighbour(fromStation);
            return this;
        }

        List<Station> shortestPath(final String from, final String to) {
            final Station fromStation = this.getStation(from);
            final Station toStation = this.getStation(to);

            final Stack<Station> dfs = new Stack<>();
            dfs.push(fromStation);

            Station pathStation = null;
            final List<Station> shortestPath = new ArrayList<>();
            while (!dfs.empty()) {
                pathStation = dfs.pop();

                if (pathStation.getName().equalsIgnoreCase(toStation.getName())) {

                }

                dfs.addAll(pathStation.getNeighbours());
            }


            return Collections.emptyList();
        }

        static String convertPathToStringRepresentation(List<Station> path) {
            if (path.isEmpty()) {
                return "";
            }
            return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
        }
    }


    private static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
                .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
                .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
                .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
                .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
                .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
                .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
                .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
                .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
                .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";

        return solution.equals(TrainMap.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
