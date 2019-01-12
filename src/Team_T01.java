import java.util.ArrayList;

public class Team_T01 extends Team {
    public Team_T01(ArrayList<Employee> theEmployees){
        theTeamResponsibilities.add("C01");
        theTeamResponsibilities.add("C03");
        theTeamResponsibilities.add("C05");
        theTeamResponsibilities.add("C06");
        theTeamResponsibilities.add("C07");
        theTeamResponsibilities.add("C08");
        this.theEmployees=theEmployees;
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
