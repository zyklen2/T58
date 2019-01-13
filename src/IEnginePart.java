import java.util.ArrayList;

public interface IEnginePart {
    ArrayList<EngineSensor> getSensores();

    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();
}
