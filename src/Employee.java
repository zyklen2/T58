public class Employee implements IEmployee {
    private int id=0;
    private ISmartPhone theSmartPhone;
    String theCurrentState="No Alert";
    public Employee(int id,ISmartPhone theSmartPhone){
        this.id=id;
        this.theSmartPhone=theSmartPhone;
        this.theSmartPhone.addEmployee(this);
    }

    @Override
    public void update() {
        String newState = theSmartPhone.getState();
        theCurrentState=newState;
        System.out.println("Worker"+id+" assigned to State '"+theCurrentState+"'");
    }
    @Override
    public ISmartPhone getTheSmartPhone(){
        return theSmartPhone;
    }
    @Override
    public String getState(){
        return theCurrentState;
    }
}
