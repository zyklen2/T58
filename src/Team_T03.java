import java.util.ArrayList;

public class Team_T03 extends Team {
    public Team_T03(Team successor, ArrayList<Employee> theEmployees){
        theTeamResponsibilities.add("C06");
        theTeamResponsibilities.add("C08");
        theTeamResponsibilities.add("C09");
        theTeamResponsibilities.add("C11");
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
