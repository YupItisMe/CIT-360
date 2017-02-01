
import javax.xml.ws.handler.*;

public class Handlers implements Handler {

    @Override
    public boolean handleMessage(MessageContext context) {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    // Does not override methods from its superclass
}