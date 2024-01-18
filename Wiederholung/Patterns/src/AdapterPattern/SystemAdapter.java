package AdapterPattern;

public class SystemAdapter implements NewSystem{
    private OldSystem oldSystem;
    public SystemAdapter(OldSystem oldSystem){
        this.oldSystem = oldSystem;
    }
    @Override
    public void request() {
        oldSystem.request();
    }
}
