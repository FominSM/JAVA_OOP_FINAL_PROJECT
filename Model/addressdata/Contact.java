package Model.addressdata;

public abstract class Contact{
    protected String dataContact;
    protected abstract String addContactMethod();
    protected abstract boolean dataValidation();
    public String getData(){return dataContact;}
}
