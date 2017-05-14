/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.airline;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Son Vu
 */
@Named(value = "flightBean")
@SessionScoped
public class FlightBean implements Serializable {

    private long id;
    
    private String flightnr;

    private String departureDate;

    private String departureTime;

    private String arrivalDate;

    private String arrivalTime;

    private AirlineBean airline;

    private AirportBean origin;

    private AirportBean destination;
	
    private AirplaneBean airplane;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightnr;
    }

    public void setFlightNumber(String flightnr) {
        this.flightnr = flightnr;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public AirlineBean getAirline() {
        return airline;
    }

    public void setAirline(AirlineBean airline) {
        this.airline = airline;
    }

    public AirportBean getOrigin() {
        return origin;
    }

    public void setOrigin(AirportBean origin) {
        this.origin = origin;
    }

    public AirportBean getDestination() {
        return destination;
    }

    public void setDestination(AirportBean destination) {
        this.destination = destination;
    }

    public AirplaneBean getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneBean airplane) {
        this.airplane = airplane;
    }

//    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
//                    Locale.US);
//    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
//                    Locale.US);
//    
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
    }
    
}
