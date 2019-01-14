import java.util.ArrayList;

public interface IEngine {
    ArrayList<IEngineSensor> getSensores();

    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();
}
