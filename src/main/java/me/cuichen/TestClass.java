package me.cuichen;

import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.opensearch.common.xcontent.DeprecationHandler;
import org.opensearch.common.xcontent.NamedXContentRegistry;
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.rest.BytesRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@ApplicationScoped
public class TestClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestClass.class);

    void onStart(@Observes StartupEvent ev) throws IOException {
        var parser = XContentType.JSON.xContent().createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.IGNORE_DEPRECATIONS, "rate limited");
        BytesRestResponse.errorFromXContent(parser);
        LOGGER.info("The application is starting...");
    }}