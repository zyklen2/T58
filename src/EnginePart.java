import java.util.ArrayList;
import java.util.List;

public class EnginePart {
    EngineSensor[] theEngineSensors = new EngineSensor[10];

    public EnginePart(){
        for(int i=0;i<theEngineSensors.length;i++){
            theEngineSensors[i]=new EngineSensor();
        }
    }

    public ArrayList<EngineSensor> getSensores(){
        ArrayList<EngineSensor> theSensorList = new ArrayList<EngineSensor>();

        return theSensorList;
    }

    public ArrayList<Integer> rollSensorParameters(){
        ArrayList<Integer> theList=new ArrayList<Integer>();
        for(int i=0;i<theEngineSensors.length;i++){
            int [] theValueList=theEngineSensors[i].rollSensorParameters();
            for(int j=0;j<theValueList.length;j++){
                theList.add(theValueList[j]);
            }
        }
        return theList;
    }
    public void setGoodValues(){
        for(int i=0;i<theEngineSensors.length;i++){
            theEngineSensors[i].setGoodValues();
        }
    }
}
