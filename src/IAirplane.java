import java.util.ArrayList;

public interface IAirplane {
    void addServiceCenter(ServiceCenter observer);

    void removeServiceCenter(ServiceCenter observer);

    void notifyAllServiceCenter();

    String getCurrentAlert();

    ArrayList<EngineSensor> getSensores();

    void rollSensorParameters();

    void setGoodValues();
}
