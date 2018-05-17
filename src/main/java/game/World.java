package game;

import java.util.List;

public class World {
    private List<Section> sections;
    private Section currentSection;

    public World() {

    }

    public void setCurrentSection(int id) {
        for (Section section : sections) {
            if (section.getId() == id) {
                currentSection = section;
            }
        }
    }
}
