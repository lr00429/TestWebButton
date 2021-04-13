import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String comicTitle = "The Amazing Spider-Man (1963) #2";
        double comicPrice=4.99;
        String encodedTitle = URLEncoder.encode(comicTitle, StandardCharsets.UTF_8.toString());
        Button URLClick= new Button("Find on eBay");
        Button playStore = new Button();
        Image playImage = new Image (getClass().getResource("/google-play-badge.png").toExternalForm());
        ImageView playImageView= new ImageView(playImage);
        playImageView.setFitHeight(60);
        playImageView.setPreserveRatio(true);
        playStore.setGraphic(playImageView);
        playStore.setStyle("-fx-background-color: transparent;");

        Button appStore = new Button();
        Image appImage = new Image (getClass().getResource("/appStore.png").toExternalForm());
        ImageView appImageView= new ImageView(appImage);
        appImageView.setFitHeight(45);
        appImageView.setPreserveRatio(true);
        appStore.setGraphic(appImageView);
        appStore.setStyle("-fx-background-color: transparent;");

        Label ebayLabel = new Label("Search for the comic on eBay!");
        Label marvelLabel = new Label("Get a digital copy on the Marvel Comics app for $"+comicPrice);


        playStore.setOnMouseClicked(e -> getHostServices().showDocument("https://play.google.com/store/apps/details?id=com.marvel.comics&hl=en_US"));

        appStore.setOnMouseClicked(e -> getHostServices().showDocument("https://apps.apple.com/us/app/marvel-comics/id350027738"));


        URLClick.setOnMouseClicked(e -> getHostServices().showDocument("https://www.ebay.com/sch/63/i.html?_from=R40&_nkw=" + encodedTitle));

        HBox box = new HBox(playStore, appStore);
        VBox vbox = new VBox(ebayLabel,URLClick, marvelLabel, box);

        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();




    }
}
