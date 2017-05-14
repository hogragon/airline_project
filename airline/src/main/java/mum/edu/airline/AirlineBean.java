/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.airline;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Son Vu
 */
@Named(value = "airlineBean")
@ApplicationScoped
public class AirlineBean {
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
    }
    
}
