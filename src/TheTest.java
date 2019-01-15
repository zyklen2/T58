
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;
public class TheTest {
    private static IAirplane theAirplane;
    private static ISmartPhone theSmartPhone;
    private static IEmployee theEmployee;
    private static ArrayList<ArrayList<IEmployee>> theEmployeeList;
    private static IEngine theEngine;
    private static IEnginePart theEnginePart;
    private static IEngineSensor theEngineSensor;
    private static IServiceCenter theServiceCenter;
    @BeforeAll
    public static void Initialize() {
        theAirplane = new Airplane();
        theSmartPhone = new SmartPhone();
        theEmployee = new Employee(1, theSmartPhone);
        theEmployeeList = new ArrayList<ArrayList<IEmployee>>();
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
        theEngine = new Engine();
        theEnginePart = new EnginePart();
        theEngineSensor = new EngineSensor();
        theServiceCenter = new ServiceCenter(theAirplane,theEmployeeList);
    }

    @Test
    public void TestIAirplane(){
        theAirplane.addServiceCenter(theServiceCenter);
        assertEquals(theServiceCenter,theAirplane.getAllServiceCenter().get(1));//Airplane hat vom erstellen an ein ServiceCenter
                                                                                //also liegt das neu hinzugefügte an der Stelle 1
        theAirplane.removeServiceCenter(theServiceCenter);
        assertEquals(1,theAirplane.getAllServiceCenter().size());      //nach dem löschen des neu hinzugefügten
                                                                                //ServiceCenter düfte nurnoch 1 vorhanden sein
                                                                                //-> Länge der Liste ist 1
        assertEquals(theAirplane.getCurrentAlert(),"No Alert");          //Da noch kein Notfall ausgelöst wurde sollte der
                                                                                //Alarm "No Alert" sein also kein Alarm
        int []currentParameter=new int[5];
        theAirplane.rollSensorParameters();
        //Vor dem wechseln der Sensorparameter sind diese alle 0, da die liste lediglich mit 0 initialisiert wird.
        //nach rollSensorParameters wurde aber allen Sensoren neue Werte zugewiesen
        assertFalse(currentParameter==theAirplane.getTheEngines()[0].getTheEngineParts()[0].getTheEngineSensors()[0].getCurrentParameter());
        //setGoodValues kann nicht getestet werden, da es in rollSensorParameters enthalten ist und lediglich eine Reihe von
        //Aufrufen auslöst, um alle Sensorparameter nach dem "Teammeeting" auf einen Akzeptablen Wert zu setzen.
        //Da aber Teil dieser Reihe ist die Fehlersensoren zurückzusetzen, kann immerhin darauf getestet werden, ob noch Fehlerhafte
        // Sensoren vorhanden sind, wenn nein hat setGoodValues erfolgreich seine Aufgabe erledigt
        int sensorsWithError=0;
        for(int i=0;i<theAirplane.getTheEngines().length;i++){
            for(int j=0;j<theAirplane.getTheEngines()[i].getTheEngineParts().length;j++){
                for(int k=0;k<theAirplane.getTheEngines()[i].getTheEngineParts()[j].getTheEngineSensors().length;k++){
                    for(int l=0;l<theAirplane.getTheEngines()[i].getTheEngineParts()[j].getTheEngineSensors()[k].getCurrentParameter().length;l++){
                        if(theAirplane.getTheEngines()[i].getTheEngineParts()[j].getTheEngineSensors()[k].getSensorWithError()[l]){
                            sensorsWithError++;
                        }
                    }
                }
            }
        }
        assertEquals(0,sensorsWithError);
        assertEquals(theAirplane.getCurrentAlert(),"No Alert");//Auch hier sollte wieder "No Alert" herauskommen,
        //da der Fehler innerhalb der rollSensorParameters Methode direkt behoben wird
    }
    @Test
    public void TestIEmployeeAndSmartPhone(){
        assertEquals(theSmartPhone.getTheEmployee(),theEmployee);//Hat das erstellen des Smartphones und Employee richtig
        //funktioniert, wurde theEmployee an das Smartphone übergeben.
        theSmartPhone.removeEmployee();
        assertFalse(theSmartPhone.getTheEmployee()==theEmployee);
        theSmartPhone.addEmployee(theEmployee);
        assertEquals(theSmartPhone.getTheEmployee(),theEmployee);
        assertEquals(theEmployee.getState(),"No Alert");
        assertEquals(theSmartPhone.getState(),"No Alert");
        theSmartPhone.setState("C11");//Hierbei wird im hintergurnd sowohl notifyEmployee(Smartphone) als auch
        //Update(Employee) ausgeführt. Hat alles Funktioniert sollten beide die Alert "C11" haben.
        assertEquals(theSmartPhone.getState(),"C11");
        assertEquals(theEmployee.getState(),"C11");
        assertEquals(theEmployee.getTheSmartPhone(),theSmartPhone);
        }

    @Test
    public void TestIEngineAndIPart(){
        //Fast alle Methoden dieser Beiden Klassen wurden bereits in TestIAirplane genutzt und so als richtig bestätigt
        assertEquals(theEngine.getTheEngineParts().length,5);
        assertEquals(theEngine.getTheEngineParts()[0].getTheEngineSensors().length,10);
    }
    //Es wurden bereits alle Methoden von EngineSensor, ServiceCenter und den Teamklassen in anderen Tests genutzt, weshalb
    //sie übersprungen werden können, da ohne sie in den anderen Fällen keine richtigen Werte herausgekommen wären.

}
