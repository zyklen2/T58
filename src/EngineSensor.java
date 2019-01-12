import java.util.ArrayList;

public class EngineSensor {
    private int []sensorValuesMin=new int[5];
    private int []sensorValuesMax=new int[5];
    private int []currentParameter=new int[5];
    private boolean [] sensorWithError=new boolean[5];
    public EngineSensor() {
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 40 + 2);
            int random2 = (int) (Math.random() * 40 + 2);
            if(random<random2){
                sensorValuesMin[i] = random * 25;
                sensorValuesMax[i] = random2 * 25;
            }
            else{
                sensorValuesMin[i] = random2 * 25;
                sensorValuesMax[i] = random * 25;
            }
        }
    }
    /*public EngineSensor(){
        for(int i=0;i<5;i++){
            int random = (int )(Math.random() * 40 + 2);
            sensorValuesMin[i]=random*25;
            boolean notSet =true;
            while(notSet) {
                int random2 = (int) (Math.random() * 40 + 2);
                if(random2>random){
                    sensorValuesMax[i]=random2*25;
                    notSet=false;
                }
            }
        }
    }*/
    private int getCurrentValue(int min, int max){
        return (int)(Math.random() * max + min);
    }
    public int[] rollSensorParameters(){
         int[] theList = new int[5];
         for(int i=0;i<5;i++){
             theList[i]=0;
         }
        for(int i=0;i<5;i++) {
            double random = Math.random() * 1 + 0.01;
            if(random == 0.05||random==0.06||random==0.07||random==0.08||random==0.09){
                theList[i]=5;
                double d=sensorValuesMax[i]*1.05;
                currentParameter[i]=(int)d;
                sensorWithError[i]=true;
            }
            else{
                if(random==0.04||random==0.03||random==0.02){
                    theList[i]=10;
                    double d=sensorValuesMax[i]*1.1;
                    currentParameter[i]=(int)d;
                    sensorWithError[i]=true;
                }
                else{
                    if(random==0.01){
                        theList[i]=20;
                        double d=sensorValuesMax[i]*1.2;
                        currentParameter[i]=(int)d;
                        sensorWithError[i]=true;
                    }
                    else{
                        currentParameter[i]=getCurrentValue(sensorValuesMin[i],sensorValuesMax[i]);
                        sensorWithError[i]=false;
                    }
                }
            }
        }
        return theList;
    }
    public void setGoodValues(){
        for(int i=0;i<5;i++){
            if(sensorWithError[i]){
                currentParameter[i]=getCurrentValue(sensorValuesMin[i],sensorValuesMax[i]);
            }
        }
    }
}
