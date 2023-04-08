package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;


public class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double average = components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
        return super.getOverallPerformance() + average;
    }

    @Override
    public double getPrice() {
        double componentsSum = components.stream().mapToDouble(Component::getPrice).sum();
        double peripheralSum = peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return super.getPrice() + componentsSum + peripheralSum;
    }

    public void addComponent(Component component) {
        if (components.stream().anyMatch(comp -> comp.getClass() == component.getClass())) {
            String msg = String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId());
            throw new IllegalArgumentException(msg);
        }

        this.components.add(component);
    }

    public Component removeComponent(String componentType) {
        if(components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(),this.getId()));
        }
        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            if(component.getClass().getSimpleName().equals(componentType)){
                index = i;
                break;
            }
        }
        return components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(per -> per.getClass() == peripheral.getClass())) {
            String msg = String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId());
            throw new IllegalArgumentException(msg);
        }

        this.peripherals.add(peripheral);
    }

    public Peripheral removePeripheral(String peripheralType) {
        if(peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(),this.getId()));
        }
        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral = peripherals.get(i);
            if(peripheral.getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;
            }
        }
        return peripherals.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(super.toString()).append(System.lineSeparator());
        message.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, components.size())).append(System.lineSeparator());

        for (Component component : components) {
            message.append("  ").append(component.toString()).append(System.lineSeparator());
        }

        double averageOverallPerformancePeripherals = peripherals.stream()
                .mapToDouble(Peripheral::getOverallPerformance).average().orElse(0);
        message.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), averageOverallPerformancePeripherals));
        message.append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            message.append("  ").append(peripheral.toString()).append(System.lineSeparator());
        }

        return message.toString().trim();
    }
}
