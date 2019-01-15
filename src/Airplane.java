import java.util.ArrayList;
import java.util.List;

public class Airplane implements IAirplane {
    IEngine[] theEngines=new Engine[4];
    List<IServiceCenter> observerList = new ArrayList<IServiceCenter>();
    String theCurrentAlert="No Alert";
    int state = 0;

    public Airplane(){
        for(int i=0;i<theEngines.length;i++){
            theEngines[i]=new Engine();

        }
    }

    @Override
    public void addServiceCenter(IServiceCenter observer) {
        this.observerList.add(observer);
    }


    @Override
    public void removeServiceCenter(IServiceCenter observer) {
        //observer.removePlaneToObserve();
        this.observerList.remove(observer);
    }

    @Override
    public List<IServiceCenter> getAllServiceCenter(){
        return observerList;
    }

    @Override
    public void notifyAllServiceCenter() {
        for (IServiceCenter observer : observerList) {
            observer.getUpdate();
        }
    }

    @Override
    public String getCurrentAlert(){
        return theCurrentAlert;
    }

    private int compareValues(int[][] listOfValues,int posToCompare,int countToCompare){
        int countSame=0;
        for(int i=0;i<listOfValues.length;i++){
                if(listOfValues[i][posToCompare]>=countToCompare) {
                    countSame++;
                }
        }
        return countSame;
    }

    @Override
    public void rollSensorParameters(){
        int[][] theList= new int[4][3];
        for(int i=0;i<theEngines.length;i++){
            ArrayList<Integer> theTempList=theEngines[i].rollSensorParameters();
            for(int j=0;j<theTempList.size();j++){
                switch(theTempList.get(j)){
                    case 5:
                        theList[i][0]++;
                        break;
                    case 10:
                        theList[i][1]++;
                        break;
                    case 20:
                        theList[i][2]++;
                        break;
                    default:
                        break;
                }
            }
        }
        if(compareValues(theList,2,2)>=2){
            theCurrentAlert ="C11";
        }
        else{
            if(compareValues(theList,2,1)>=2){
                theCurrentAlert ="C10";
            }
            else{
                if(compareValues(theList,2,1)>=1){
                    theCurrentAlert ="C09";
                }
                else{
                    if(compareValues(theList,1,2)>=2){
                        theCurrentAlert ="C08";
                    }
                    else{
                        if(compareValues(theList,1,2)>=1){
                            theCurrentAlert ="C07";
                        }
                        else{
                            if(compareValues(theList,1,1)>=2){
                                theCurrentAlert ="C06";
                            }
                            else{
                                if(compareValues(theList,1,1)>=1){
                                    theCurrentAlert ="C05";
                                }
                                else{
                                    if(compareValues(theList,0,2)>=2){
                                        theCurrentAlert ="C04";
                                    }
                                    else{
                                        if(compareValues(theList,0,2)>=1){
                                            theCurrentAlert ="C03";
                                        }
                                        else{
                                            if(compareValues(theList,0,1)>=2){
                                                theCurrentAlert ="C02";
                                            }
                                            else{
                                                if(compareValues(theList,0,1)>=1){
                                                    theCurrentAlert ="C01";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.notifyAllServiceCenter();
    }
    @Override
    public void setGoodValues(){
        for(int i=0;i<theEngines.length;i++){
            theEngines[i].setGoodValues();
        }
        theCurrentAlert="No Alert";
        System.out.println("Problem solved. Good Parameters set.");
    }

    public IEngine[] getTheEngines() {
        return theEngines;
    }
}
