package org.github.ebramirez;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class JinqLinesResourceIT extends JinqLinesResourceTest {

    // Execute the same tests but in native mode.
}