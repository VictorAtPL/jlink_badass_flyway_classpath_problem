module jlink_badass_flyway_classpath_problem {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.apache.derby.tools;
    requires org.apache.derby.commons;
    requires org.apache.derby.engine;

    requires org.flywaydb.core;
    requires java.sql;

    exports db.migration;

    opens app;
    opens db.migration;
}