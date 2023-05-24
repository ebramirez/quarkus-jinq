package org.github.ebramirez;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class LinesRepository implements PanacheRepositoryBase<Lines, String> {

    @Inject
    protected EntityManager entityManager;
    protected JinqJPAStreamProvider streams;

    @PostConstruct
    void init() {
        if ( streams == null ) {
            streams = new JinqJPAStreamProvider( entityManager.getMetamodel() );
        }
    }

    public JPAJinqStream<Lines> getStream() {
        return streams.streamAll( entityManager, Lines.class );
    }
}
