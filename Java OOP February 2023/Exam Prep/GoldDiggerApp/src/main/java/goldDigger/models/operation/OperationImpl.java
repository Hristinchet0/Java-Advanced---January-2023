package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Iterator;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        for (Discoverer discoverer : discoverers) {
            Iterator<String> iterator = spot.getExhibits().iterator();

            while (iterator.hasNext()) {
                if (!discoverer.canDig()) {
                    break;
                }
                discoverer.dig();

                String item = iterator.next();
                discoverer.getMuseum().getExhibits().add(item);
                iterator.remove();
            }
        }
    }
}
