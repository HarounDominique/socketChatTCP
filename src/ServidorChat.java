import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServidorChat {
    private static final long serialVersionUID = 1L;
    static ServerSocket servidor;
    static final int PUERTO = 44444; //puerto por el que escucha
    static int CONEXIONES =0; //cuenta las conexiones
    static int ACTUALES =0; //número de conexiones activas actualmente
    static int MAXIMO = 10; //número máximo de conexiones permitidas
    static Socket tabla[] = new Socket[10]; //almacena 10 sockets de clientes
    public static void main(String[] args) throws IOException {

        servidor = new ServerSocket(12345);
        System.out.println("Servidor iniciado...");

        /*Se hace un bucle para controlar el número de conexiones. Dentro del bucle el servidor espera la
         conexión del cliente y cuando se conecta se crea un socket*/
        //Se admiten hasta 10 conexiones:
        while(CONEXIONES < MAXIMO){
            Socket s = new Socket();
            try{
                s=servidor.accept();//esperando cliente
            }catch (SocketException e){
                break; //sale por aquí si cerramos y no se ejecuta el bucle entero
            }
            tabla[CONEXIONES]=s;
            CONEXIONES++;
            ACTUALES++;

        }
    }
}
