package ch2;

public class Ex9 {
    public static class Car {
        private final double fuelEfficiency;
        private double traveledDistance = 0;
        private double gasLevel = 0;

        public Car(double fuelEfficiency) {
            this.fuelEfficiency = fuelEfficiency;
        }

        public double getTraveledDistance() {
            return traveledDistance;
        }

        public double getGasLevel() {
            return gasLevel;
        }

        public void reFill(double gasAmount) {
            gasLevel += gasAmount;
        }

        public void move(double distance) throws Exception {
            double neededGas = distance / fuelEfficiency;

            if (gasLevel > neededGas) {
                gasLevel -= neededGas;
                traveledDistance += distance;
            } else {
                throw new IllegalArgumentException("Not Enough Gas");
            }
        }
    }
}
