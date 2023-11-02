
package Model;

import java.util.HashMap;
import java.util.Map;


public class UserFactory {
        static Map<String, Model.User> users = new HashMap<String, Model.User>(){{
          put("restaurant", new Model.Restaurant());
          put("customer", new Model.Castomer());
        }};

        public static Model.User getUser(String type){
            return users.get(type);
        }
        
}