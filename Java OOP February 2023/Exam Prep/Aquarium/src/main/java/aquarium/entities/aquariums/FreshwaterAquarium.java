package aquarium.entities.aquariums;

import aquarium.entities.decorations.BaseDecoration;

public class FreshwaterAquarium extends BaseAquarium {
    private static final int CAPACITY = 50;
    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}
