import java.util.ArrayList;
import java.util.List;

public class EnginePart implements IEnginePart {
    IEngineSensor[] theEngineSensors = new EngineSensor[10];

    public EnginePart(){
        for(int i=0;i<theEngineSensors.length;i++){
            theEngineSensors[i]=new EngineSensor();
        }
    }

    @Override
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
    @Override
    public void setGoodValues(){
        for(int i=0;i<theEngineSensors.length;i++){
            theEngineSensors[i].setGoodValues();
        }
    }

    public IEngineSensor[] getTheEngineSensors() {
        return theEngineSensors;
    }
}
