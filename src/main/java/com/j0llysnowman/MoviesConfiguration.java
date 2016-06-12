package com.j0llysnowman;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by david on 6/12/16.
 */
public class MoviesConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String defaultMovieTitle = "Space Jam";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String getDefaultMovieTitle() {
        return defaultMovieTitle;
    }

    @JsonProperty
    public void setDefaultMovieTitle(String defaultMovieTitle) {
        this.defaultMovieTitle = defaultMovieTitle;
    }
}
