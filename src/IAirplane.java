import java.util.List;
import java.util.ArrayList;

public interface IAirplane {
    void addServiceCenter(IServiceCenter observer);

    void removeServiceCenter(IServiceCenter observer);

    List<IServiceCenter> getAllServiceCenter();

    void notifyAllServiceCenter();

    String getCurrentAlert();

    void rollSensorParameters();

    void setGoodValues();

    IEngine[] getTheEngines();
}
