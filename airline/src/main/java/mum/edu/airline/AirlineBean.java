/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.airline;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Son Vu
 */
@Named(value = "airlineBean")
@SessionScoped
public class AirlineBean implements Serializable{
    private long id;
    private String name;    
    private List<FlightBean> flights;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlightBean> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightBean> flights) {
        this.flights = flights;
    }
    /**
     * Creates a new instance of AirlineBean
     */
    public AirlineBean() {
        flights = new ArrayList<>();
    }
    
    public String selectFlight(FlightBean f){
//        for(FlightBean fo:flights){
//            if(fo.getFlightNumber().equals(f.getFlightNumber())){
//                flights.remove(fo);
//                return;
//            }
//        }
        System.out.println("selected Flight: "+f.getFlightNumber());
        flights.add(f);
        return null;
    }
    
    public String createAirline(){
        Gson gson = new Gson();
        try{
            String response = HttpConnectionHelper.sendPostRequest("createAirline", gson.toJson(this));
            System.out.print(response);
            return "index";
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return "index";
    }
}
