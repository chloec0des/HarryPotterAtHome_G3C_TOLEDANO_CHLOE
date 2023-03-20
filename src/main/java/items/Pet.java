package items;

public enum Pet {
    OWL("Hedwig"), RAT("Scabbers"), CAT("Crookshanks"), TOAD("Trevor");

    private final String name;

    Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
