// RootDecoder.java
import java.math.BigInteger;
import java.util.*;
import com.google.gson.*;

public class RootDecoder {
    public static List<BigInteger> decodeRoots(JsonObject obj) {
        List<BigInteger> roots = new ArrayList<>();

        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            String key = entry.getKey();
            if (key.equals("keys")) continue; // skip metadata

            JsonObject rootObj = entry.getValue().getAsJsonObject();
            int base = Integer.parseInt(rootObj.get("base").getAsString());
            String value = rootObj.get("value").getAsString();

            BigInteger root = new BigInteger(value, base);
            roots.add(root);
        }
        return roots;
    }
}
