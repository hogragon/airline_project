/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.rest_airlines;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Son Vu
 */
public class MemoryDBA {
    private List<Airport> airportList;// = new ArrayList<>();
    private List<Flight> flightList;// = new ArrayList<>();
    private List<Airplane> airplaneList;// = new ArrayList<>();
    private List<Airline> airlineList;// = new ArrayList<>();

    public List<Airport> getAirportList() {
        return airportList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public List<Airline> getAirlineList() {
        return airlineList;
    }
    
    private static MemoryDBA instance;
    
    public static MemoryDBA getInstance(){
        if(instance==null){
            instance = new MemoryDBA();
        }
        return instance;
    }
    
    public MemoryDBA(){
        airportList = new ArrayList<>();
        flightList = new ArrayList<>();
        airplaneList = new ArrayList<>();
        airlineList = new ArrayList<>();
        this.init();
    }
    
    private void init(){
        createAirports();
        createAirline();
        createAirplane();
        createFlight();
    }
    
    private void createAirports(){
        Airport o;
        o = new Airport("AMS","Amsterdam","The Netherlands","Schiphol");
        airportList.add(o);
        o = new Airport("DTW","Detroid","USA","Detroid City");
        airportList.add(o);
        o = new Airport("NRT","Tokyo","Japan","Narita International Airport");
        airportList.add(o);       
        
        int i=0;
        for(Airport a:airportList){
            a.setId(++i);
        }
    }
    
    private void createAirline(){
        Airline o;
        o = new Airline("Sky Team");
        o.setId(1);
        airlineList.add(o);
        
        o = new Airline("North Star");
        o.setId(2);
        airlineList.add(o);
        
        o = new Airline("Vietjet");
        o.setId(3);
        airlineList.add(o);
        
    }
    
    private void createAirplane(){
        Airplane o;
        o = new Airplane("747","32154",416);
        airplaneList.add(o);
        o = new Airplane("747","32155",416);
        airplaneList.add(o);
        o = new Airplane("747","62154",416);
        airplaneList.add(o);
        o = new Airplane("747","92154",416);
        airplaneList.add(o);
        o = new Airplane("747","72154",416);
        airplaneList.add(o);
        
        int i=0;
        for(Airplane a:airplaneList){
            a.setId(++i);
        }
    }
    
    private void createFlight(){
        Flight f;
        f = new Flight ("1","2015/06/25","09:00 AM","2009/08/06","19:10 PM");
        flightList.add(f);
        f = new Flight ("6","2015/06/25","13:45 PM","2009/08/06","15:05 PM");
        flightList.add(f);
        f = new Flight ("9","2015/06/25","06:15 AM","2009/08/05","22:30 PM");
        flightList.add(f);        
        f = new Flight ("14","2015/06/25","06:55 AM","2009/08/06","21:55 PM");
        flightList.add(f);
        
        int i=0;
        for(Flight a:flightList){
            a.setId(++i);
        }
    }
}
