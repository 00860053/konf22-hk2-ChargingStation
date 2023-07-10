package org.campus02;

/*
* TODO: <<git log>>: ed5b789a79b9550894b556024a6154440e322694
 * */

public class ChargingStation {
    private String chargingStationRate;
    private double fixCosts;
    private double varCosts;

    /**
     * ein chargingStationRate (Tarif für eine Ladestation) kann folgende Werte annehmen: Standard, Fix, Smart
     * wird keiner dieser chargingStationRate übergeben, soll eine IllegalArgumentException geworfen werden
     *
     * @param chargingStationTarif der gewählte ChargingStationTarif Typ
     *
     */
    public ChargingStation(String chargingStationTarif, double fixCosts, double varCosts) {
        if (chargingStationTarif.equals("Standard") || chargingStationTarif.equals("Fix") || chargingStationTarif.equals("Smart")) {
            this.chargingStationRate = chargingStationTarif;
            this.fixCosts = fixCosts;
            this.varCosts = varCosts;
            setCosts(chargingStationTarif);
        } else
        throw new IllegalArgumentException("falscher ChargingStationTarif gewählt");

    }


    public String getChargingStationRate() {
        return chargingStationRate;
    }

    public void setChargingStationRate(String ChargingStationTarif) {
        this.chargingStationRate = ChargingStationTarif;
    }

    public double getFixCosts() {
        return fixCosts;
    }

    public void setFixCosts(double fixCosts) {
        this.fixCosts = fixCosts;
    }

    public double getVarCosts() {
        return varCosts;
    }

    public void setVarCosts(double varCosts) {
        this.varCosts = varCosts;
    }

    private void setCosts(String chargingStationTarif) {
        switch (chargingStationTarif) {
            case "Standard":
                this.fixCosts = 2;
                this.varCosts = 0.1;
                break;
            case "Fix":
                this.fixCosts = 25;
                this.varCosts = 0;
                break;
            case "Smart":
                this.fixCosts = 0;
                this.varCosts = 0.29;
                break;
        }
    }

    public double powerPerMinute(double powerConsumption, int minutes) {
        return powerConsumption / minutes;
    }


    public double calculateCosts(double powerConsumption, int minutes) {
        double costs = 0;
        switch (chargingStationRate) {
            case "Standard":

                double varCosts = this.varCosts;
                if (powerPerMinute(powerConsumption, minutes) > 2.5) {
                    varCosts = varCosts * 2;
                }

                costs = fixCosts + varCosts * powerConsumption;
                break;
            case "Fix":
                costs = fixCosts;
                break;
            case "Smart":
                costs = this.varCosts + powerConsumption;
                break;
        }
        return costs;
    }
}
