import java.util.ArrayList;

public class Engine implements IEngine {
    EnginePart[] theEngineParts = new EnginePart[5];

    public Engine(){
        for(int i=0;i<theEngineParts.length;i++){
            theEngineParts[i]=new EnginePart();
        }
    }

    @Override
    public ArrayList<EngineSensor> getSensores(){
        ArrayList<EngineSensor> theSensorList = new ArrayList<EngineSensor>();

        return theSensorList;
    }

    @Override
    public ArrayList<Integer> rollSensorParameters(){
        ArrayList<Integer> theList=new ArrayList<Integer>();
        for(int i=0;i<theEngineParts.length;i++){
            ArrayList<Integer> theValueList=theEngineParts[i].rollSensorParameters();
            for(int j=0;j<theValueList.size();j++){
                theList.add(theValueList.get(j));
            }
        }
        return theList;
    }
    @Override
    public void setGoodValues(){
        for(int i=0;i<theEngineParts.length;i++){
            theEngineParts[i].setGoodValues();
        }
    }
}
