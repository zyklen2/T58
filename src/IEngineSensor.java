public interface IEngineSensor {
    int[] rollSensorParameters();

    void setGoodValues();

    int []getCurrentParameter();

    boolean[] getSensorWithError();
}
