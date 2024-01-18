package Factory;

import java.util.ArrayList;
import java.util.List;

public class Pie {
    List<String> umpluturi = new ArrayList<>();
    private String name;

    public Pie(String name) {
        this.name = name;
    }

    public void punePranza(){
        umpluturi.add("Pranza");
    }

    public void puneMere(){
        umpluturi.add("Mere");
    }

    public void puneVarza(){
        umpluturi.add("Varza");
    }

    public void puneCartofi(){
        umpluturi.add("Cartofi");
    }

    @Override
    public String toString() {
        return "Factory.Pie{" +
                "umpluturi=" + umpluturi +
                ", name='" + name + '\'' +
                '}';
    }
}
