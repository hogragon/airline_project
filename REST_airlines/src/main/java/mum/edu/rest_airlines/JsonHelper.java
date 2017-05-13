/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.rest_airlines;

import cs545.airline.model.*;
import java.io.StringWriter;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 *
 * @author Son Vu
 */
public class JsonHelper {
    
    
    private static JsonObjectBuilder flightToJson(Flight f){
        JsonObjectBuilder model = Json.createObjectBuilder();
        model.add("id", f.getId());
        model.add("flightNumber", f.getFlightnr());
        model.add("arrivalDate", f.getArrivalDate());
        model.add("arrivalTime", f.getArrivalTime());
        model.add("departureDate", f.getDepartureDate());
        model.add("departureTime", f.getDepartureTime());
        return model;
    }
    
    private static JsonObject flightInfoToJson(Flight f){
        JsonObjectBuilder model = flightToJson(f);
        
        model.add("airplane",airPlaneToObjectBuilder(f.getAirplane()));
        model.add("destination",airPortToObjectBuilder(f.getDestination()));
        model.add("origin",airPortToObjectBuilder(f.getOrigin()));
        return model.build();
    }
    
    private static JsonObjectBuilder airlineToJson(Airline f){
        JsonObjectBuilder model = Json.createObjectBuilder();
        model.add("id", f.getId());
        model.add("name", f.getName());
        return model;
    }
    
    private static JsonObjectBuilder airPlaneToObjectBuilder(Airplane f){
        JsonObjectBuilder model = Json.createObjectBuilder();
        model.add("id", f.getId());
        model.add("serialNumber", f.getSerialnr());
        model.add("capacity", f.getCapacity());
        model.add("model", f.getModel());
        return model;
    }
    
    private static JsonObject airPlaneToJson(Airplane f){
        return airPlaneToObjectBuilder(f).build();
    }
    
    private static JsonObjectBuilder airPortToObjectBuilder(Airport f){
        JsonObjectBuilder model = Json.createObjectBuilder();
        model.add("id", f.getId());
        model.add("name", f.getName());
        model.add("serialNumber", f.getAirportcode());
        model.add("capacity", f.getCity());
        model.add("model", f.getCountry());
        //model.add("arrivals", listFlightToJsonArray(f.getArrivals()));
        //model.add("departures", listFlightToJsonArray(f.getDepartures()));
        return model;
    }
    
    private static JsonObjectBuilder airPortInfoToObjectBuilder(Airport f){
        JsonObjectBuilder model = airPortToObjectBuilder(f);
        
        model.add("arrivals", listFlightInfoToJsonArrayBuilder(f.getArrivals()));
        model.add("departures", listFlightInfoToJsonArrayBuilder(f.getDepartures()));
        return model;
    }
    
    private static JsonObject airPortToJson(Airport f){
        return airPortInfoToObjectBuilder(f).build();
    }
    
    public static String airPortToJsonString(Airport f){
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeObject(airPortToObjectBuilder(f).build());
        return strWriter.toString();       
    }
    
    public static String listAirportToJson(List<Airport> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Airport f:list){
            arrFlight.add(airPortToJson(f));
        }
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeArray(arrFlight.build());
        return strWriter.toString();
    }
    
    public static String listAirplaneToJson(List<Airplane> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Airplane f:list){
            arrFlight.add(airPlaneToJson(f));
        }
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeArray(arrFlight.build());
        return strWriter.toString();
    }
    
    public static String listAirlineToJson(List<Airline> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Airline f:list){
            arrFlight.add(airlineToJson(f));
        }
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeArray(arrFlight.build());
        return strWriter.toString();
    }
    
    
    
    private static JsonArrayBuilder listFlightInfoToJsonArray(List<Flight> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Flight f:list){
            arrFlight.add(flightInfoToJson(f));
        }
        
        return arrFlight;
    }
    
    private static JsonArrayBuilder listFlightInfoToJsonArrayBuilder(List<Flight> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Flight f:list){
            arrFlight.add(flightToJson(f));
        }
        
        return arrFlight;
    }
    
    public static String listFlightToJson(List<Flight> list){

        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeArray(listFlightInfoToJsonArray(list).build());
        return strWriter.toString();
    }
    
}
