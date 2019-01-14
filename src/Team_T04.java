import java.util.ArrayList;

public class Team_T04 extends Team implements ITeam_T04 {
    public Team_T04(Team successor, ArrayList<IEmployee> theEmployees){
        theTeamResponsibilities.add("C10");
        this.theEmployees=theEmployees;
        setSuccessor(successor);
    }
    @Override
    public void parse(String theAlert){
        if(canHandleAlert(theAlert)){
            System.out.println("Team T04 alerted with "+theAlert);
            notifyAllTeamMembers(theAlert);
        }
        else{
            super.parse(theAlert);
        }
    }
}
