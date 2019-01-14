public class SmartPhone implements ISmartPhone {
    IEmployee theEmployee;

    String state = "No Alert";

    @Override
    public void addEmployee(IEmployee theEmployee) {
        this.theEmployee=theEmployee;
    }

    @Override
    public void removeEmployee() {
        this.theEmployee=null;
    }


    @Override
    public void notifyEmployee() {
        if(theEmployee!=null){
            theEmployee.update();
        }
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
        this.notifyEmployee();
    }
}
