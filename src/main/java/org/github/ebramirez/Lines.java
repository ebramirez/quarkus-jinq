/**
 *
 */
package org.github.ebramirez;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author eramirez
 *
 */
@Entity
public class Lines implements Serializable {
    private static final long serialVersionUID = -8159455548711409815L;

    @Id
    @GeneratedValue
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId( final Long id ) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent( final String content ) {
        this.content = content;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled( final boolean enabled ) {
        this.enabled = enabled;
    }

    private boolean enabled;

    public Lines() {
    }

    /**
     * @param content
     */
    public Lines( final String content ) {
        this.content = content;
        this.enabled = true;
    }

}
