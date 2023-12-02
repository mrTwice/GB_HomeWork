package Chat;

public class Server {
    private boolean isServerWorking;
    private final IServerListener listener;

    public Server(IServerListener listener) {
        isServerWorking = false;
        this.listener = listener;
    }

    public void start(){
        if(isServerWorking) {
            listener.receiveMessage("Server is already working");
            return;
        }
        listener.receiveMessage("Server started");
        isServerWorking = true;
    }

    public void stop() {
        if(!isServerWorking) {
            listener.receiveMessage("Server is stopped");
        return;
        }
        listener.receiveMessage("Server stopped");
        isServerWorking = false;
    }

    public boolean authorization () {
        return true;
    }
}
