import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IAirplane theAirplane = new Airplane();
        ArrayList<ArrayList<IEmployee>> theEmployeeList = new ArrayList<ArrayList<IEmployee>>();
        int employeeID=0;
        for (int i = 0; i < 5; i++) {
            ArrayList<IEmployee> theNewEmployeeList = new ArrayList<IEmployee>();
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