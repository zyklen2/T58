import java.util.ArrayList;

public class Team_T05 extends Team {
    public Team_T05(Team successor, ArrayList<Employee> theEmployees){
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
