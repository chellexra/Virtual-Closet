package persistence;

import org.json.JSONObject;

// Referenced from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
