import java.util.ArrayList;

public interface IAirplane {
    void addServiceCenter(IServiceCenter observer);

    void removeServiceCenter(IServiceCenter observer);

    void notifyAllServiceCenter();

    String getCurrentAlert();

    ArrayList<IEngineSensor> getSensores();

    void rollSensorParameters();

    void setGoodValues();
}
