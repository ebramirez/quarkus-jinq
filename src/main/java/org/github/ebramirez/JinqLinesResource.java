package org.github.ebramirez;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path( "/lines" )
public class JinqLinesResource {

    @Inject
    LinesRepository linesRepo;

    @GET
    @Path( "/add/{content}" )
    @Transactional
    public void add( @PathParam( "content" ) final String content ) {
        linesRepo.persist( new Lines( content ) );
    }

    @GET
    @Path( "/{id}" )
    public Lines get( @PathParam( "id" ) final Long id ) {
        return linesRepo.getStream().where( l -> l.getId().equals( id ) ).findFirst().get();
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