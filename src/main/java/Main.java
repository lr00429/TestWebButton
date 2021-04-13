import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String comicTitle = "The Amazing Spider-Man (1963) #2";
        String encodedTitle = URLEncoder.encode(comicTitle, StandardCharsets.UTF_8.toString());
        Button URLClick= new Button("Find on eBay");
        URLClick.setOnMouseClicked(e ->{
            getHostServices().showDocument("https://www.ebay.com/sch/63/i.html?_from=R40&_nkw=" + encodedTitle);
        });
        HBox box = new HBox(URLClick);
        primaryStage.setScene(new Scene(box));
        primaryStage.show();




    }
}
