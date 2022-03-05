package web.models;

public class AccountForm {

    private String customerFirstName;
    private String customerLastName;
    private String password;
    private String officialFirstName;
    private String officialLastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;
    private String addressAlias;

    public AccountForm(String customerFirstName, String customerLastName, String password, String officialFirstName,
                       String officialLastName, String address, String city, String state, String zipCode,
                       String country, String mobilePhone, String addressAlias) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.password = password;
        this.officialFirstName = officialFirstName;
        this.officialLastName = officialLastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getPassword() {
        return password;
    }

    public String getOfficialFirstName() {
        return officialFirstName;
    }

    public String getOfficialLastName() {
        return officialLastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }
}
