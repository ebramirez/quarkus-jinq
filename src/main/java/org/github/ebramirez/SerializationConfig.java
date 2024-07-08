package org.github.ebramirez;

import java.lang.invoke.SerializedLambda;

import org.jinq.jpa.JPAJinqStream;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(
    lambdaCapturingTypes = { "org.github.ebramirez.JinqLinesResource" },
    targets = { SerializedLambda.class, Long.class, Number.class, String.class, JinqLinesResource.class, com.user00.thunk.SerializedLambda.class, JPAJinqStream.class },
    serialization = true
)
public class SerializationConfig {
}
