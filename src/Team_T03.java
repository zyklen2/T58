import java.util.ArrayList;

public class Team_T03 extends Team implements ITeam_T03 {
    public Team_T03(Team successor, ArrayList<Employee> theEmployees){
        theTeamResponsibilities.add("C06");
        theTeamResponsibilities.add("C08");
        theTeamResponsibilities.add("C09");
        theTeamResponsibilities.add("C11");
        this.theEmployees=theEmployees;
        setSuccessor(successor);
    }
    @Override
    public void parse(String theAlert){
        if(canHandleAlert(theAlert)){
            System.out.println("Team T03 alerted with "+theAlert);
            notifyAllTeamMembers(theAlert);
        }
        else{
            super.parse(theAlert);
        }
    }
}
