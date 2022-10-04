public class Account {

    private double amount = 0.00;
    private int age;
    private static String name, location, bankName, routingNumber, accountNumber, password;

    public Account() {}
    public Account(String actNum, int age, String userName, String userLocation, String bankname, String routingnumber, String password) {
        accountNumber = actNum ;
        this.age = age;
        name = userName;
        location = userLocation;
        bankName = bankname;
        routingNumber = routingnumber;
        System.out.printf("\n\n\t-- Hello! Welcome to %s, %s! Located at %s. --\n", bankName, name, location);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankName() {
        return bankName;
    }

    public static void setPassword(String password2) {
        password = password2;
    }
    public String getPassword() {
        return password;
    }

    public void insertMoney(double insertAmount) {
        amount += insertAmount;
    }
    public void extractMoney(double extractAmount) {
        amount -= extractAmount;
    }

    public void changePassword(String password) {
        setPassword(password);
        System.out.println("New password is: " + password + "\n");
    }
    



}