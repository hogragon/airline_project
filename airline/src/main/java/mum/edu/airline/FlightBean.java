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
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Son Vu
 */
@Named(value = "flightBean")
@SessionScoped
public class FlightBean implements Serializable {

    private long id;
	private String flightnr;
	
	private Date departureDate;
	
	private Date departureTime;
	
	private Date arrivalDate;
	
	private Date arrivalTime;
	
	private AirlineBean airline;
	
	private AirportBean origin;
	
	private AirportBean destination;

    public long getId() {
        return id;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public AirlineBean getAirline() {
        return airline;
    }

    public AirportBean getOrigin() {
        return origin;
    }

    public AirportBean getDestination() {
        return destination;
    }

    public AirplaneBean getAirplane() {
        return airplane;
    }

    public static DateFormat getDf() {
        return df;
    }

    public static DateFormat getTf() {
        return tf;
    }
	
    private AirplaneBean airplane;

    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                    Locale.US);
    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                    Locale.US);
    
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
    }
    
}
