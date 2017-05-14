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
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author Son Vu
 */
@Named(value = "arilineManagerBean")
@SessionScoped
public class ArilineManagerBean implements Serializable{
    
    private List<AirlineBean> airlines;
    
    @Inject
    private AirlineBean selectedAirline;

    public List<AirlineBean> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<AirlineBean> airlines) {
        this.airlines = airlines;
    }
    /**
     * Creates a new instance of ArilineManagerBean
     */
    public ArilineManagerBean() {
        airlines = new ArrayList<>();
    }
    
    public void addAirline(ActionEvent e){
        
        for(FlightBean f:selectedAirline.getFlights()){
            System.out.println("flight number: "+f.getFlightNumber());
        }
//        System.out.println("selected airline="+selectedAirline.getName());
//        airlines.add(selectedAirline);
        
//        Gson gson = new Gson();
//        gson.toJson(selectedAirline);
        
       
        
//        Map<String,String> m = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        
//        Set<String> keys = m.keySet();
//        for(String k:keys){
//            System.out.println("key = "+k);
//        }
//        AirlineBean a = (AirlineBean) m.get("airlineBean");
//        
//        airlines.add(a);
    }
    
    public void createAirline(){
        
    }
}
