public interface ISmartPhone {
    void addEmployee(IEmployee theEmployee);

    void removeEmployee();

    void notifyEmployee();

    String getState();

    void setState(String state);
}
