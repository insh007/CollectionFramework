import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ComplexDataStructure {
    public static String[] vehicles = {
            "ambulance", "helicopter", "lifeboat"
    };

    public static String[][] drivers = {
            {"Fred", "Sue", "Pete"},
            {"Sue", "Richard", "Bob", "Fred"},
            {"Pete", "Mary", "Bob"}
    };

     public static void main(String[] args) {
         Map<String, Set<String>> personnel = new HashMap<>();

         for(int i=0; i<vehicles.length; i++){
             String vehicle = vehicles[i];
             String[] driverList = drivers[i];

             Set<String> driverSet = new LinkedHashSet<>();

             for(String driver : driverList){
                 driverSet.add(driver);
             }

             personnel.put(vehicle, driverSet);
         }

//         for (Map.Entry<String, Set<String>> entry : personnel.entrySet()) {
//             String key = entry.getKey();
//             Set<String> value = entry.getValue();
//
//             System.out.println("Key " + key + " Value " + value);
//         }

         Set<String> driverList =  personnel.get("helicopter");
         for(String driver : driverList) {
             System.out.println(driver);
         }
     }
}
