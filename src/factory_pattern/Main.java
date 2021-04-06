package factory_pattern;

public class Main {
    public static void main(String[] args) {
        CompanyNameFactory companyNameFactory = new CompanyNameFactory();
        InterfaceCompanyName javis = companyNameFactory.getCompany("Tibco");
        javis.printCompanyName();
        InterfaceCompanyName hust = companyNameFactory.getCompany("HUST");
        hust.printCompanyName();
    }
}
