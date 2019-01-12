import java.util.ArrayList;

public class Team_T02 extends Team {
    public Team_T02(Team successor, ArrayList<Employee> theEmployees){
        theTeamResponsibilities.add("C02");
        theTeamResponsibilities.add("C04");
        theTeamResponsibilities.add("C05");
        theTeamResponsibilities.add("C06");
        theTeamResponsibilities.add("C07");
        theTeamResponsibilities.add("C08");
        this.theEmployees=theEmployees;
        setSuccessor(successor);
    }
    public void parse(String theAlert){
        if(canHandleAlert(theAlert)){
            notifyAllTeamMembers(theAlert);
        }
        else{
            super.parse(theAlert);
        }
    }
}
