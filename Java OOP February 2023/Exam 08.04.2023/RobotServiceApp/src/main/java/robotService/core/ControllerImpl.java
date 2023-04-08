package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service = null;

        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        services.add(service);

        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement = null;

        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplements.addSupplement(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(supplement);
                supplements.removeSupplement(supplement);
            }
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;

        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service service = this.services.stream().filter(ser -> ser.getName().equals(serviceName))
                .findFirst().orElse(null);

        String serviceType = service.getClass().getSimpleName();

        boolean suitableService = (serviceType.equals("MainService") && robotType.equals("MaleRobot")) ||
                (serviceType.equals("SecondaryService")) && robotType.equals("FemaleRobot");

        if (suitableService) {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        } else {
            return UNSUITABLE_SERVICE;
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        int countFeedingRobot = 0;

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                Collection<Robot> robots = service.getRobots();
                for (Robot robot : robots) {
                    robot.eating();
                    countFeedingRobot++;
                }
            }
        }
        return String.format(FEEDING_ROBOT, countFeedingRobot);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().findFirst()
                .filter(service1 -> service1.getName().equals(serviceName)).orElse(null);

        double totalSum = 0;

        Collection<Supplement> supplements1 = service.getSupplements();

        for(Supplement supplement : supplements1) {
            totalSum += supplement.getPrice();
        }

        Collection<Robot> robots = service.getRobots();
        for (Robot robot : robots) {
            totalSum += robot.getPrice();
        }

        return String.format(VALUE_SERVICE, serviceName, totalSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        for (Service service : services) {
            statistics.append(service.getStatistics()).append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
