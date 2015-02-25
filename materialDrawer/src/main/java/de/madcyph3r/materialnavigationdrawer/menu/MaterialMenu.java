package de.madcyph3r.materialnavigationdrawer.menu;

import java.util.ArrayList;
import java.util.List;

public class MaterialMenu {

    public static int SECTION = 0;
    public static int BOTTOM_SECTION = 1;
    public static int DIVISOR = 2;

    private List<Object> sections = new ArrayList<Object>();
    //private Map<Integer, MaterialSection> sections = new HashMap<Integer, MaterialSection>();

    public List<Object> getSections() {
        return sections;
    }

    public void setSections(List<Object> sections) {
        this.sections = sections;
    }

    public void addSection(Object section) {
        getSections().add(section);
    }
}
