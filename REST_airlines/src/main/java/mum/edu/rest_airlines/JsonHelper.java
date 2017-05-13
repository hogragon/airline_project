/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.rest_airlines;

import cs545.airline.model.Flight;
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
    private static JsonObject flightToJson(Flight f){
        JsonObjectBuilder model = Json.createObjectBuilder();
        model.add("flightNumber", f.getFlightnr());
        model.add("arrivalDate", f.getArrivalDate());
        model.add("arrivalTime", f.getArrivalTime());
        model.add("departureDate", f.getDepartureDate());
        model.add("departureTime", f.getDepartureTime());
        return model.build();
    }
    public static String listFlightToJson(List<Flight> list){
        JsonArrayBuilder arrFlight = Json.createArrayBuilder();
        for(Flight f:list){
            arrFlight.add(flightToJson(f));
        }
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonWrite = Json.createWriter(strWriter);
        jsonWrite.writeArray(arrFlight.build());
        return strWriter.toString();
    }
}
