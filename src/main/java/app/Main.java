package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.configuration.ClassicConfiguration;

import java.io.File;

public class Main extends Application {

    public final static String DERBY_URL = "jdbc:derby:" + System.getProperty("user.dir") + File.separator + "database;create=true";


    @Override
    public void start(final Stage primaryStage) {
        ClassicConfiguration flywayConfiguration = new ClassicConfiguration();
        flywayConfiguration.setBaselineOnMigrate(true);
        flywayConfiguration.setSchemas("APP");
        flywayConfiguration.setDefaultSchema("APP");
        flywayConfiguration.setDataSource(DERBY_URL, null, null);
        Flyway flyway = new Flyway(flywayConfiguration);
        try {
            flyway.migrate();
        }
        catch (FlywayException e) {
            e.printStackTrace();
        }

        Platform.exit();
        System.exit(0);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}
