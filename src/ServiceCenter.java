import java.util.ArrayList;

public class ServiceCenter implements IServiceCenter {
    private IAirplane planeToObserve;
    ArrayList<Team> theTeams=new ArrayList<Team>();

    public ServiceCenter(IAirplane planeToObserve,ArrayList<ArrayList<IEmployee>> theEmployees){
        this.planeToObserve=planeToObserve;
        this.planeToObserve.addServiceCenter(this);
        Team theTeam_T01=new Team_T01(theEmployees.get(0));
        theTeams.add(theTeam_T01);
        Team theTeam_T02=new Team_T02(theTeam_T01,theEmployees.get(1));
        theTeams.add(theTeam_T02);
        Team theTeam_T03=new Team_T03(theTeam_T02,theEmployees.get(2));
        theTeams.add(theTeam_T03);
        Team theTeam_T04=new Team_T04(theTeam_T03,theEmployees.get(3));
        theTeams.add(theTeam_T04);
        Team theTeam_T05=new Team_T05(theTeam_T04,theEmployees.get(4));
        theTeams.add(theTeam_T05);
    }

    @Override
    public void getUpdate(){
        String theCurrentAlert = planeToObserve.getCurrentAlert();
        if(theCurrentAlert!="No Alert") {
            theTeams.get(4).parse(theCurrentAlert);
            planeToObserve.setGoodValues();
        }
    }
    /*public void resetAlerts(){
        for(int i=0;i<theTeams.size();i++){
            theTeams.get(i).resetAlert();
        }
    }*/
}
