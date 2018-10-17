import com.porterlaw.*;

import javax.xml.crypto.Data;
import java.util.Arrays;

public class Consultant {
    public static void main(String[] args){
        /*Client[] initialize = new Client[0];
        Database.save(initialize);*/
        Client[] clients = Database.load();
        for(Client client:clients){
            System.out.println(client.toString());
        }
        Client currentClient = new Client();
        String userName = Client.getStringFromUser("Enter a Username: ");
        boolean userFound=false;
        for(int i=0;i<clients.length;i++){
            if(clients[i].getUserName().equalsIgnoreCase(userName)){
                userFound=true;
                currentClient = clients[i];
                i=clients.length;
            }
        }
        if(!userFound&&userName.equalsIgnoreCase("jwp91")){
            currentClient = new Admin("jwp91");
        }else if(!userFound){
            currentClient = new Client(userName);
        }
        clients = Arrays.copyOf(clients, clients.length+1);
        clients[clients.length-1]=currentClient;
        Database.save(clients);
    }
}
