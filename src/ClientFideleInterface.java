import classes.ClientFidele;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button ;
import java.io.IOException;


public class ClientFideleInterface {

    @FXML
    Button retour;

    public void retourClientFideleClique() {
        Stage stage=Main.stage;
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("ClientFideleLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(" Client Fidele ");
            stage.show();
            root.requestFocus();
        }
        catch (IOException e) {}
    }
    @FXML
    Button modifadress;
    public void modifierAdresseClientFideleClique(){
        ClientFidele cl ;
        cl = Noyeau.res.avoirClientFidele(ClientFideleLogin.codefid) ;
        ModifierAdresses m = new ModifierAdresses(cl);
        m.show() ;


    }
}
