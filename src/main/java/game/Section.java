package game;

public class Section {
    private final int id;
    private GameObject[][] objects;

    public Section(GameObject[][] objects, int id, Section neighborLeft, Section neighborRight, Section neightborAbove, Section neightborBelow) {
        this.objects = objects;
        this.id = id;
    }


}
