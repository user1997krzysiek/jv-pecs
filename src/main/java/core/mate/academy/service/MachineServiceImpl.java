package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<T> getAll(Class<? extends T> type) {
        List<? extends Machine> machines;

        if (Bulldozer.class.equals(type)) {
            machines = new BulldozerProducer().get();
        } else if (Excavator.class.equals(type)) {
            machines = new ExcavatorProducer().get();
        } else if (Truck.class.equals(type)) {
            machines = new TruckProducer().get();
        } else {
            machines = List.of();
        }

        return new ArrayList<>((List<T>) machines);
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
