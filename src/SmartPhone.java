public class SmartPhone {
    Employee theEmployee;

    String state = "No Alert";

    public void addEmployee(Employee theEmployee) {
        this.theEmployee=theEmployee;
    }

    public void removeEmployee() {
        this.theEmployee=null;
    }


    public void notifyEmployee() {
        if(theEmployee!=null){
            theEmployee.update();
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        this.notifyEmployee();
    }
}
