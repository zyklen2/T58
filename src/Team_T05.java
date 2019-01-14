import java.util.ArrayList;

public class Team_T05 extends Team implements ITeam_T05 {
    public Team_T05(Team successor, ArrayList<IEmployee> theEmployees){
        theTeamResponsibilities.add("C11");
        this.theEmployees=theEmployees;
        setSuccessor(successor);
    }
    @Override
    public void parse(String theAlert){
        if(canHandleAlert(theAlert)){
            System.out.println("Team T05 alerted with "+theAlert);
            notifyAllTeamMembers(theAlert);
        }
        else{
            super.parse(theAlert);
        }
    }
}
