package pl.mkwiecien.releasingguide.domain.configuration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "configuration")
public class Configuration {

    @Id
    private String id;
    private ColourPalette colourPalette;
    private Instant created;

    public Configuration() {
    }

    public Configuration(String id, ColourPalette colourPalette, Instant created) {
        this.id = id;
        this.colourPalette = colourPalette;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ColourPalette getColourPalette() {
        return colourPalette;
    }

    public void setColourPalette(ColourPalette colourPalette) {
        this.colourPalette = colourPalette;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
