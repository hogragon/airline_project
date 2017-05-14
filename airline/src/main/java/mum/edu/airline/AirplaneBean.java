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
@Named(value = "airplaneBean")
@SessionScoped
public class AirplaneBean implements Serializable {
    
    private long id;
    private String serialnr;
    private String model;
    private int capacity;    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialnr() {
        return serialnr;
    }

    public void setSerialnr(String serialnr) {
        this.serialnr = serialnr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<FlightBean> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightBean> flights) {
        this.flights = flights;
    }
    private List<FlightBean> flights;
    
    /**
     * Creates a new instance of AirplaneBean
     */
    public AirplaneBean() {
    }
    
}
