/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.airline;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Son Vu
 */
@Named(value = "airportBean")
@SessionScoped
public class AirportBean implements Serializable {
    private long id;
    private String airportcode;
    private String name;
    private String city;
    private String country;    
    private List<FlightBean> arrivals;    
    private List<FlightBean> departures;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirportcode() {
        return airportcode;
    }

    public void setAirportcode(String airportcode) {
        this.airportcode = airportcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<FlightBean> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<FlightBean> arrivals) {
        this.arrivals = arrivals;
    }

    public List<FlightBean> getDepartures() {
        return departures;
    }

    public void setDepartures(List<FlightBean> departures) {
        this.departures = departures;
    }
    /**
     * Creates a new instance of AirportBean
     */
    public AirportBean() {
    }
    
}
