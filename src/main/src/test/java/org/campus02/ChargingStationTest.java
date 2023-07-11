package org.campus02;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChargingStationTest {
    ChargingStation cs;

    @BeforeEach
    void setUp() {
        cs = new ChargingStation("Standard", 2.0, 0.1);

    }

    @Test
    @DisplayName("constructorRate")
    void testConstructor() {
        cs.setChargingStationRate("Standard");
        Assertions.assertEquals("Standard", cs.getChargingStationRate());
        cs.setChargingStationRate("Fix");
        Assertions.assertEquals("Fix", cs.getChargingStationRate());
        cs.setChargingStationRate("Smart");
        Assertions.assertEquals("Smart", cs.getChargingStationRate());
    }

    @Test
    @DisplayName("constructorCost")
    void testConstructor2() {
        Assertions.assertEquals(2.0, cs.getFixCosts());
        Assertions.assertEquals(0.1, cs.getVarCosts());

        cs.setChargingStationRate("Fix");
        cs.setFixCosts(25.0);
        cs.setVarCosts(0.0);
        Assertions.assertEquals(25.0, cs.getFixCosts());
        Assertions.assertEquals(0.0, cs.getVarCosts());

        cs.setChargingStationRate("Smart");
        cs.setFixCosts(0.0);
        cs.setVarCosts(0.29);
        Assertions.assertEquals(0.0, cs.getFixCosts());
        Assertions.assertEquals(0.29, cs.getVarCosts());
    }

    @Test
    void powerPerMinute() {
        Assertions.assertEquals(2.0, cs.powerPerMinute(100,50));
        Assertions.assertEquals(2.0, cs.powerPerMinute(200,100));
    }

    @Test
    void calculateCosts() {
        Assertions.assertEquals(22, cs.calculateCosts(100, 20));

        cs.setChargingStationRate("Fix");
        cs.setFixCosts(25.0);
        cs.setVarCosts(0.0);
        Assertions.assertEquals(25.0, cs.calculateCosts(100,20));

        cs.setChargingStationRate("Fix");
        cs.setFixCosts(83.0);
        cs.setVarCosts(0.0);
        Assertions.assertEquals(83.0, cs.calculateCosts(100,20));

        cs.setChargingStationRate("Smart");
        cs.setFixCosts(0.0);
        cs.setVarCosts(0.29);
        Assertions.assertEquals(0.29*100.00, cs.calculateCosts(100.00,20));

    }
}