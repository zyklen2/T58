import java.util.ArrayList;

public abstract class Team {
    ArrayList<String> theTeamResponsibilities=new ArrayList<String>();
    ArrayList<Employee> theEmployees = new ArrayList<Employee>();
    private Team successor;
    public void parse(String theAlert){
        if(getSuccessor() != null){
            getSuccessor().parse(theAlert);
        }
        else{
            System.out.println("Kein zuständiges Team");
        }
    }
    public boolean canHandleAlert(String theAlert){
        for(int i=0;i<theTeamResponsibilities.size();i++){
            if(theTeamResponsibilities.get(i)==theAlert){
                return true;
            }
        }
        return false;
    }
    public Team getSuccessor(){
        return successor;
    }
    public void setSuccessor(Team successor){
        this.successor=successor;
    }
    public Team(){}
    public Team(ArrayList<Employee> theEmployees,ArrayList<String> theTeamResponsibilities){
            this.theEmployees=theEmployees;
            this.theTeamResponsibilities=theTeamResponsibilities;
    }

    public ArrayList<String> getTheTeamResponsibilities(){
        return theTeamResponsibilities;
    }

    public void notifyAllTeamMembers(String theCurrentAlert){
        for(int i=0;i<theEmployees.size();i++){
            theEmployees.get(i).getTheSmartPhone().setState(theCurrentAlert);
        }
        System.out.println("Teammeeting");
        resetAlert();
    }

    public void resetAlert(){
        for(int i=0;i<theEmployees.size();i++) {
            theEmployees.get(i).getTheSmartPhone().setState("No Alert");
        }
    }
}
