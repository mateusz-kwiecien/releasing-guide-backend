package pl.mkwiecien.releasingguide.domain.configuration;

public class ColourPalette {
    private String released;
    private String complex;
    private String blocked;

    public ColourPalette() {
    }

    public ColourPalette(String released, String complex, String blocked) {
        this.released = released;
        this.complex = complex;
        this.blocked = blocked;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getComplex() {
        return complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
}
