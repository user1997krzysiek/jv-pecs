package core.mate.academy.service;

import core.mate.academy.model.*;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<T> getAll(Class<T> type) {
        if (type == Bulldozer.class) {
            return (List<T>) new BulldozerProducer().get();
        }
        if (type == Excavator.class) {
            return (List<T>) new ExcavatorProducer().get();
        }
        if (type == Truck.class) {
            return (List<T>) new TruckProducer().get();
        }
        throw new IllegalArgumentException("Unknown machine type: " + type);
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
