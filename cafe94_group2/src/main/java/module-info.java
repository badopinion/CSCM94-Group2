module cafepackage.cafe94_group2 {
    requires javafx.graphics;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens cafepackage.cafe94_group2 to javafx.fxml, javafx.base;
    opens backend to javafx.fxml, javafx.base;
    exports cafepackage.cafe94_group2;
}