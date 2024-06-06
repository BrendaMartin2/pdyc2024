package ar.edu.unnoba.pdyc2024.mymusic;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("ar.edu.unnoba.pdyc2024.mymusic");
    }
}
