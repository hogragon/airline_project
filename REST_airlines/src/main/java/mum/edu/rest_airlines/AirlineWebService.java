/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.rest_airlines;

import com.google.gson.Gson;

import cs545.airline.dao.AirlineDao;
import cs545.airline.dao.FlightDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.nonmanaged.JpaUtil;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 * REST Web Service
 *
 * @author Son Vu
 */
@Path("airline")
public class AirlineWebService {
    
//    private AirlineService airlineService = new AirlineService(new AirlineDao());
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AirlineWebService
     */
    public AirlineWebService() {
       
    }

    @Override
    protected void finalize() throws Throwable {
        JpaUtil.destroyJpaUtil();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    

    /**
     * Retrieves representation of an instance of mum.edu.rest_airlines.AirlineWebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        FlightDao dao = new FlightDao();
        FlightService flight = new FlightService(dao);        
        List<Flight> list = flight.findAll();
        return JsonHelper.listFlightToJson(list);
    }
    
    @GET
    @Path("/airline")
    @Produces(MediaType.APPLICATION_JSON)
    public String allAirLine(){
        AirlineService airlineService = new AirlineService(new AirlineDao());
//        Gson gson = new Gson();
        List<Airline> list = airlineService.findAll();
        String rs = "";
        for(Airline a:list){
            rs+=a.getName() + "\n";
//            rs+=gson.toJson(a);
        }
        //JpaUtil.getEntityManager().close();
        
        
        return rs;
    }

    /**
     * PUT method for updating or creating an instance of AirlineWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("/find/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("number") String flightNumber){
        //appInstance.getFlightService().findByNumber(flightNumber);
                
        return "{hello:text}";
    }
}
