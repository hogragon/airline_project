/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.airline;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.Context;
import javax.faces.context.FacesContext;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Son Vu
 */
@Named(value = "flightManagerBean")
@ApplicationScoped
public class FlightManagerBean implements Serializable {

    private List<FlightBean> flights;

    public List<FlightBean> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightBean> flights) {
        this.flights = flights;
    }
    /**
     * Creates a new instance of FlightManagerBean
     */
    public FlightManagerBean() {
       flights = new ArrayList<>();
    }
    
    public void onLoad() throws IOException{
//        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String url = "http://localhost:8080/REST_airlines/webresources/airline/listFlight";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        Gson gson = new Gson();
//        FlightBean[] allFlights = gson.fromJson(in, FlightBean[].class);
//        System.out.println(gson.toString());
//        for(FlightBean f:allFlights){
//            System.out.println(f.getFlightNumber());
//        }
        
        flights.clear();
        FlightBean f = null;
        JsonParser parser = Json.createParser(con.getInputStream());
//        System.out.println(parser.getString());
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch(event) {
               case START_OBJECT:                   
                   f = new FlightBean();
                   break;
               case END_OBJECT:
                   flights.add(f);
                   break;
               case KEY_NAME:
               {
                  String key = parser.getString();
                  if(key.equals("id")){
                      parser.next();
                      f.setId(parser.getLong());
                  }
                  else if(key.equals("flightNumber")){
                      parser.next();
                      f.setFlightNumber(parser.getString());
                  }
                  else if(key.equals("arrivalDate")){
                      parser.next();
                      f.setArrivalDate(parser.getString());
                  }
                  else if(key.equals("arrivalTime")){
                      parser.next();
                      f.setArrivalTime(parser.getString());
                  }
                  else if(key.equals("departureDate")){
                      parser.next();
                      f.setDepartureDate(parser.getString());
                  }
                  else if(key.equals("departureTime")){
                      parser.next();
                      f.setDepartureTime(parser.getString());
                  }
                  break;
               }
            }
        }
    }
}
