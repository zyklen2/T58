import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
public class TheTest {
    private static ArrayList<String>theTeamStatus;
    private static IAirplane theAirplane;
    private static ArrayList<ArrayList<IEmployee>> theEmployeeList;
    private static ServiceCenter theServiceCenter;
   @BeforeAll
    public static void Test()
    {
        theAirplane = new Airplane();
        theEmployeeList = new ArrayList<ArrayList<IEmployee>>();
        int employeeID = 0;
        for (int i = 0; i < 5; i++) {
            ArrayList<IEmployee> theNewEmployeeList = new ArrayList<IEmployee>();
            theEmployeeList.add(theNewEmployeeList);
            for (int j = 0; j < 3; j++) {
                SmartPhone newSmartPhone = new SmartPhone();
                Employee newEmployee = new Employee(employeeID, newSmartPhone);
                theEmployeeList.get(i).add(newEmployee);
                employeeID++;
            }

        }
        theServiceCenter = new ServiceCenter(theAirplane, theEmployeeList);
        theTeamStatus=theServiceCenter.theTeams.get(0).getTeamMemberStatus();
    }

    @Test
    public void Test1(){
        assertEquals("No Alert", theTeamStatus.get(0));
    }
    @Test
    public void Test2(){
        theAirplane.rollSensorParameters();
        theTeamStatus=theServiceCenter.theTeams.get(0).getTeamMemberStatus();
        assertEquals("No Alert", theTeamStatus.get(0));
    }
}
