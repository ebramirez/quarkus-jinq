package org.github.ebramirez;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.jinq.jpa.JPAJinqStream;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Path( "/lines" )
@ApplicationScoped
@RegisterForReflection( lambdaCapturingTypes = "org.github.ebramirez.JinqLinesResource", targets = { JinqLinesResource.class,
        com.user00.thunk.SerializedLambda.class, SerializedLambda.class, JPAJinqStream.class, Number.class, Long.class,
        String.class } )
public class JinqLinesResource implements Serializable {

    private static final long serialVersionUID = 3296098878474315412L;

    @Inject
    transient LinesRepository linesRepo;

    @GET
    @Path( "/add/{content}" )
    @Transactional
    public void add( @PathParam( "content" ) final String content ) {
        linesRepo.persist( new Lines( content ) );
    }

    @GET
    @Path( "/{id}" )
    public Lines get( @PathParam( "id" ) final Long id ) {
        return linesRepo
                        .getStream()
                        .where( l -> l.getId().equals( id ) )
                        .findFirst()
                        .get();
    }

    @GET
    public List<Lines> getAll() {
        return linesRepo.getStream().toList();
    }

    @GET
    @Path( "/disable/{id}" )
    @Transactional
    public void disable( @PathParam( "id" ) final Long id ) {
        linesRepo.getStream().where( l -> l.getId().equals( id ) ).forEach( l -> l.setEnabled( false ) );
    }
}