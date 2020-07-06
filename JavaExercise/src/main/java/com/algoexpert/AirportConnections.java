package com.algoexpert;

        import java.util.*;

public class AirportConnections {

    public static int airportConnections( List<String> airports, List<List<String>> routes, String startingAirport) {

        //Step 1
        Map<String,AirportNode> airportGraph = new HashMap<>();
        for(String airport: airports){
            airportGraph.put(airport,new AirportNode(airport));
        }
        for(List<String> route : routes){
            airportGraph.get(route.get(0)).connections.add(route.get(1));
        }


        //Step 2
        List<AirportNode> unReachableAirports = new ArrayList<>();
        depthFirst(airportGraph,startingAirport);
        for(String airport : airports){
            if(!airportGraph.get(airport).visited){
                unReachableAirports.add(airportGraph.get(airport));
            }
        }

        //Step 3
        for(AirportNode airportNode : unReachableAirports){

            String airportName = airportNode.airport;
            List<String> unReachableAirport = new ArrayList<>();
            Set<String> visitedAirport = new HashSet<>();
            depthFirstMarkUnreachableConnections(airportGraph,airportName,unReachableAirport,visitedAirport);
            airportNode.unReachableConnections = unReachableAirport;
        }

        unReachableAirports.sort((a1,a2) -> a2.unReachableConnections.size() - a1.unReachableConnections.size());
        int num = 0;

        for(AirportNode airportNode : unReachableAirports){

            if(airportNode.visited) continue;
            num++;
            for(String connection : airportNode.unReachableConnections){
                airportGraph.get(connection).visited = true;
            }

        }

        return num;
    }

    private static void depthFirstMarkUnreachableConnections(Map<String, AirportNode> airportGraph, String airportName, List<String> unReachableAirport, Set<String> visitedAirport) {

        if(airportGraph.get(airportName).visited) return;
        if(visitedAirport.contains(airportName)) return;
        visitedAirport.add(airportName);
        unReachableAirport.add(airportName);
        for(String airportConn : airportGraph.get(airportName).connections){
            depthFirstMarkUnreachableConnections(airportGraph,airportConn,unReachableAirport,visitedAirport);
        }

    }

    private static void depthFirst(Map<String, AirportNode> airportGraph, String startingAirport) {

        AirportNode airport = airportGraph.get(startingAirport);

        if(airport.visited) return;

        airport.visited = true;

        for(String airportConn : airport.connections){
            depthFirst(airportGraph,airportConn);
        }

    }

    static class AirportNode {

        String airport;
        List<String> connections;
        List<String> unReachableConnections;
        boolean visited;

        AirportNode(String airport){
            this.airport = airport;
            this.connections = new ArrayList<>();
            visited = false;
        }

    }

}
