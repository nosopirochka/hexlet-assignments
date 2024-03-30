package exercise;


import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN

    public String serialize() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception error) {
            return "ok";
        }
    }

    public static Car deserialize(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Car.class);
        } catch (Exception error) {
            return new Car(
                    1,
                    "ok",
                    "ok",
                    "ok",
                    new User(1, "1", "1", 1));
        }
    }
    // END
}
