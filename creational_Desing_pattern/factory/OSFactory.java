package creational_Desing_pattern.factory;

public class OSFactory {
    public OS getInstance(String userInput){
        if(userInput.toLowerCase().equals("android")){
            return new Android();
        }
        if(userInput.toLowerCase().equals("windows")){
            return new Windows();
        }
        if(userInput.toLowerCase().equals("ios")){
            return new IOS();
        }
        return null;
    }
}
