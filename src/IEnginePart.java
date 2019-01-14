import java.util.ArrayList;

public interface IEnginePart {
    ArrayList<IEngineSensor> getSensores();

    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();
}
