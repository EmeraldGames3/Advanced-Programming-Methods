package Factory;

public class Placintarie {

    public Pie coace(String ceFel){
        Pie pie = new Pie(ceFel);

        if(ceFel == "Placinta cu cartofi"){
            pie.punePranza();
            pie.puneCartofi();
        } else if ("Placinta cu mere".equals(ceFel)) {
            pie.puneMere();
            pie.puneCartofi();
        }

        return pie;
    }
}
