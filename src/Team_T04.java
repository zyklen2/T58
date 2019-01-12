import java.util.ArrayList;

public class Team_T04 extends Team {
    public Team_T04(Team successor, ArrayList<Employee> theEmployees){
        theTeamResponsibilities.add("C10");
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
