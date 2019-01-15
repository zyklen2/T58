import java.util.ArrayList;

public interface IEngine {
    ArrayList<Integer> rollSensorParameters();

    void setGoodValues();

    IEnginePart[] getTheEngineParts();
}
