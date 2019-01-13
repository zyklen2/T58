import java.util.ArrayList;

public interface IEngine {
    ArrayList<EngineSensor> getSensores();

    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();
}
