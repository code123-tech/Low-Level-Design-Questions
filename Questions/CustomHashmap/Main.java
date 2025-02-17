package Questions.CustomHashmap;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>(45);
        customHashMap.put(64, "house64");
        customHashMap.put(128, "house128");
        customHashMap.put(100, "house100");
        customHashMap.put(192, "house192");
        System.out.println(customHashMap.get(192));
        String aa = "chf";
        Integer val = 1;
        val.hashCode();
        aa.hashCode();
    }
}