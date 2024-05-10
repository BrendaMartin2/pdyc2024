package ar.edu.unnoba.pdyc2024.mymusic;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("ar.edu.unnoba.pdyc2024.mymusic.resource");
    }
}
