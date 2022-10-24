package hva.jabbarn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Library {
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
