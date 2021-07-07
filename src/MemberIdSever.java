import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class MemberIdServer implements Serializable {
    private int idCounter;
    private static  MemberIdServer server;

    private MemberIdServer() {
        idCounter = 1;
    }

    static MemberIdServer instance() {
        if (server == null) {
            return (server = new MemberIdServer());
        } else {
            return server;
        }
    }

    public static void retrieve(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.readObject();
    }

    public int getId() {
        return idCounter++;
    }
}
