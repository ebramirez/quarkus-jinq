package org.github.ebramirez;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint( JinqLinesResource.class )
class JinqLinesResourceTest {

    @Test
    void testAddLineEndpoint() {
        given()
                .when()
                .get( "/add/AddLine" )
                .then()
                .statusCode( 204 );

        Lines newLine = given().when()
                .get( "/1")
                .then()
                .statusCode( 200 )
                .extract()
                .as( Lines.class );

        assertThat( newLine.getId() ).isEqualTo( 1 );
        assertThat( newLine.getContent() ).isEqualTo( "AddLine" );
    }

}