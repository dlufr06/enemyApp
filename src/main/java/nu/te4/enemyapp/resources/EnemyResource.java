/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.enemyapp.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.enemyapp.beans.EnemyBean;
import nu.te4.enemyapp.enteties.Enemy;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnemyResource {

    @EJB
    EnemyBean enemyBean;

    @GET
    @Path("enemies")
    public Response getEnemies() {
        List<Enemy> enemies = enemyBean.getEnemys();
        return Response.ok(enemies).build();
    }

    @GET
    @Path("enemy")
    public Response getEnemy(@QueryParam("id") int id) {
        Enemy enemy = enemyBean.getEnemy(id);
        return Response.ok(enemy).build();
    }

    @POST
    @Path("enemy")
    public Response postEnemy(Enemy enemy) {
        int result = enemyBean.saveEnemy(enemy);
        if (result == 1) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("enemy")
    public Response updateEnemy(Enemy enemy) {
        int result = enemyBean.updateEnemy(enemy);
        if (result == 1) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
