
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MATCHER;


class VehicleTest {

    // - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void checkObjectCarIsInstanceOfVehile(){
        Car ford = new Car("Ford", "Focus", 2023);
        assertThat(ford).isInstanceOf(Vehicle.class);

    }

    // - проверка того, объект Car создается с 4-мя колесами
    @Test
    void checkObjectCarHaveFourWheels(){
        Car volvo = new Car("Volvo", "XC90", 2022);
        assertThat(volvo.getNumWheels()).isEqualTo(4);

    }

    // - проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void checkObjectMotorcycleHaveTwoWheels(){
        Motorcycle harleyDavidson = new Motorcycle("Harley-Davidson", "V-Rod", 2023);
        assertThat(harleyDavidson.getNumWheels()).isEqualTo(2);
    }

    // - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void checkObjectCarCanAccelerateTo60kmphInTestDrive(){
        Car toyota = new Car("Toyota", "Camry", 2019);
        toyota.testDrive();
        assertThat(toyota.getSpeed()).isEqualTo(60);

    }

    // - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void checkObjectMotorcyclerCanAccelerateTo75kmphInTestDrive(){
        Motorcycle honda = new Motorcycle("Honda", "CBR1000RR Fireblad", 2023);
        honda.testDrive();
        assertThat(honda.getSpeed()).isEqualTo(75);
    }

    // - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void checkObjectCarHaveZeroSpeedInParckingMode(){
        Car uaz = new Car("УАЗ", "Буханка", 1986);
        uaz.testDrive();
        uaz.park();
        assertThat(uaz.getSpeed()).isEqualTo(0);

    }

    // - проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void checkObjectMotorcycleHaveZeroSpeedInParckingMode(){
        Motorcycle jawa = new Motorcycle("Jawa", "350", 2020);
        jawa.testDrive();
        jawa.park();
        assertThat(jawa.getSpeed()).isEqualTo(0);

    }

}
