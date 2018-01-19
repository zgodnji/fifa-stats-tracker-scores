package com.zgodnji.fifastatstracker;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("scores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScoreResource {

    @Inject
    @Metric(name = "scores_counter")
    private Counter scoresCounter;

    @GET
    public Response getAllScores() {
        List<Score> scores = Database.getScores();
        return Response.ok(scores).build();
    }

    @GET
    @Path("{scoreId}")
    public Response getScore(@PathParam("scoreId") String scoreId) {
        Score score = Database.getScore(scoreId);
        return score != null
                ? Response.ok(score).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewScore(Score score) {
        Database.addScore(score);

        scoresCounter.inc();

        return Response.noContent().build();
    }

    @DELETE
    @Path("{scoreId}")
    public Response deleteScore(@PathParam("scoreId") String scoreId) {
        Database.deleteScore(scoreId);

        scoresCounter.dec();

        return Response.noContent().build();
    }

    @GET
    @Path("create")
    public Response fillDatabase() {
        Database.addScore(new Score(
            "1",
                "1",
                "2",
                "2",
                3,
                0
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "2",
                "1",
                "2",
                "2",
                0,
                1
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "3",
                "1",
                "2",
                "2",
                2,
                2
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "3",
                "1",
                "2",
                "2",
                1,
                2
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "4",
                "2",
                "1",
                "3",
                1,
                2
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "5",
                "1",
                "2",
                "3",
                1,
                0
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "6",
                "1",
                "2",
                "3",
                0,
                0
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "7",
                "1",
                "2",
                "3",
                5,
                1
        ));
        scoresCounter.inc();
        Database.addScore(new Score(
                "8",
                "1",
                "2",
                "1",
                3,
                3
        ));
        scoresCounter.inc();
        return Response.noContent().build();
    }

    @Inject
    private ScoreProperties properties;

    @GET
    @Path("config")
    public Response getConfig() {
        String response =
                "{" +
                        "\"stringProperty\": \"%s\"," +
                        "\"booleanProperty\": %b," +
                        "\"integerProperty\": %d" +
                        "}";

        response = String.format(
                response,
                properties.getStringProperty(),
                properties.getBooleanProperty(),
                properties.getIntegerProperty());

        return Response.ok(response).build();
    }
}
