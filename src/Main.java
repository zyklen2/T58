import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Airplane theAirplane = new Airplane();
        ArrayList<ArrayList<Employee>> theEmployeeList = new ArrayList<ArrayList<Employee>>();
        int employeeID=0;
        for (int i = 0; i < 5; i++) {
            ArrayList<Employee> theNewEmployeeList = new ArrayList<Employee>();
            theEmployeeList.add(theNewEmployeeList);
            for(int j=0;j<3;j++){
                SmartPhone newSmartPhone = new SmartPhone();
                Employee newEmployee = new Employee(employeeID,newSmartPhone);
                theEmployeeList.get(i).add(newEmployee);
                employeeID++;
            }

        }
        ServiceCenter theServiceCenter = new ServiceCenter(theAirplane,theEmployeeList);
        theAirplane.rollSensorParameters();
    }
}