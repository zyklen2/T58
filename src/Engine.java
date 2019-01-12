import java.util.ArrayList;

public class Engine {
    EnginePart[] theEngineParts = new EnginePart[5];

    public Engine(){
        for(int i=0;i<theEngineParts.length;i++){
            theEngineParts[i]=new EnginePart();
        }
    }

    public ArrayList<EngineSensor> getSensores(){
        ArrayList<EngineSensor> theSensorList = new ArrayList<EngineSensor>();

        return theSensorList;
    }

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
    public void setGoodValues(){
        for(int i=0;i<theEngineParts.length;i++){
            theEngineParts[i].setGoodValues();
        }
    }
}
