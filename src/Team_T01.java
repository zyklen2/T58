import java.util.ArrayList;

public class Team_T01 extends Team {
    public Team_T01(ArrayList<IEmployee> theEmployees){
        theTeamResponsibilities.add("C01");
        theTeamResponsibilities.add("C03");
        theTeamResponsibilities.add("C05");
        theTeamResponsibilities.add("C06");
        theTeamResponsibilities.add("C07");
        theTeamResponsibilities.add("C08");
        this.theEmployees=theEmployees;
    }
    @Override
    public void parse(String theAlert){
        if(canHandleAlert(theAlert)){
            System.out.println("Team T01 alerted with "+theAlert);
            notifyAllTeamMembers(theAlert);
        }
        else{
            super.parse(theAlert);
        }
    }
}
