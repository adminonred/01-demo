package proxy;

public class Factory implements Sell{
    @Override
    public float sell(int mount) {
        return 90*mount;
    }
}
