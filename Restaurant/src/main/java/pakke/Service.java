package pakke;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by BrageHalse on 26.09.2017.
 */
@Path("/resBord")
public class Service {
    static Restaurant restaurant = new Restaurant("Rest");

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public boolean regBord(String nrAnt){
        return restaurant.regNyttBord(nrAnt);
    }

    @Path("/rett")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public boolean regRett(String rett){
        return restaurant.regNyRett(rett);
    }

    @Path("/bestilling")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMeny(){
        return restaurant.getMeny();
    }

    @Path("/meny")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String menyToString(){
        return restaurant.menyToString();
    }

    @Path("/reserver")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void reserverBord(String total){

        try{
            restaurant.reserverBord(total);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void nyBestilling(int resId){
        restaurant.getReservasjon(resId).nyBestilling();
    }

    @Path("/resPls")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String toString(){
        return restaurant.toString();
    }

}
