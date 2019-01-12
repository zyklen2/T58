public class Employee {
    private int id=0;
    private SmartPhone theSmartPhone;
    String theCurrentState="No Alert";
    public Employee(int id,SmartPhone theSmartPhone){
        this.id=id;
        this.theSmartPhone=theSmartPhone;
        this.theSmartPhone.addEmployee(this);
    }

    public void update() {
        String newState = theSmartPhone.getState();
        theCurrentState=newState;
        System.out.println(theCurrentState);
    }
    public SmartPhone getTheSmartPhone(){
        return theSmartPhone;
    }
    public String getState(){
        return theCurrentState;
    }
}
