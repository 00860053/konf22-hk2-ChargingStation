package org.campus02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChargingStationTest {

    ChargingStation defaultChargingStation;

    String defaultChargingStationRate;

    double defaultFixCosts;

    double defaultVarCosts;
    @BeforeEach
    void setUp() {
        defaultChargingStationRate = "Standard";

        defaultVarCosts = 0.1;
        defaultFixCosts = 2;
        defaultChargingStation = new ChargingStation(defaultChargingStationRate,defaultFixCosts,defaultVarCosts);

        //setup erstellen

    }
@Test
@DisplayName("Test Constructor")
void testConstructor(){
        Assertions.assertEquals(defaultFixCosts, defaultChargingStation.getFixCosts());
        Assertions.assertEquals(defaultVarCosts,defaultChargingStation.getVarCosts());
        Assertions.assertEquals(defaultChargingStationRate,defaultChargingStation.getChargingStationRate());
}
    @Test
    @DisplayName("Power per Minute Test")
    void powerPerMinute() {

    }

    @Test
    void getChargingStationRate() {
        Assertions.assertEquals(defaultChargingStationRate,defaultChargingStation.getChargingStationRate());
        defaultChargingStationRate = "Fix";
        Assertions.assertEquals(defaultChargingStationRate,defaultChargingStation.getChargingStationRate());
    }

    @Test
    void getFixCosts() {
        Assertions.assertEquals(defaultFixCosts,defaultChargingStation.getFixCosts());
    }

    @Test
    void getVarCosts() {
        Assertions.assertEquals(defaultVarCosts, defaultChargingStation.getVarCosts());
    }
}