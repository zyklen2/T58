import java.util.ArrayList;

public interface IEnginePart {

    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();

    IEngineSensor[] getTheEngineSensors();
}
