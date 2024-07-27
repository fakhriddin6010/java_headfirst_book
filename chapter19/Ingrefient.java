import java.lang.reflect.Type;

import lombok.Data;
@Data
public class Ingrefient{
    private final String id;
    private final String name;
    private final Type type;
    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}