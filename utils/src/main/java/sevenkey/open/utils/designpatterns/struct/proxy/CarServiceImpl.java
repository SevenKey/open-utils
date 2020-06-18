package sevenkey.open.utils.designpatterns.struct.proxy;

/**
 * @author weijianyu
 */
public class CarServiceImpl implements CarService{

    @Override
    public String drive(){
        return "drive car";
    }
}
