package factory_pattern;

public class CompanyNameFactory {

    public InterfaceCompanyName getCompany(String name){

        switch (name){
            case "Tibco":
                return new Tibco();
            case "Javis":
                return  new Javis();
            case "HUST":
                return  new HUST();
        }
        return null;
    }
}
