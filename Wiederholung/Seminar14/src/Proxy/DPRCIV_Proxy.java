package Proxy;

public class DPRCIV_Proxy implements Police{
    private DPRCIV dprciv = new DPRCIV();

    @Override
    public void registerPlate(String plateNumber) {
        //Validate plate
        if (!plateNumber.contains("xxx")){
            dprciv.registerPlate(plateNumber);
        }
        else {
            throw new RuntimeException("Invalid plateNumber!");
        }
    }
}
