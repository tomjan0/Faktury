package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        //---MAIN MENU BUTTONS---
        Button addInv = new Button("Dodaj fakturę");
        Button addCus = new Button("Dodaj klienta");
        Button addArt = new Button("Dodaj artykuł");
        Button showInv = new Button("Wyświetl fakturę");
//        Button view = new Button("Przeglądaj bazę");
        Button exit = new Button("ZAMKNIJ");
        Button invBack = new Button("←");
        Button cusBack = new Button("←");
        Button artBack = new Button("←");
        Button invArtBack = new Button("←");
        Button showInvBack = new Button("←");
        Button showInvBack2 = new Button("←");


        //---BUTTONS TO VBOX---
        VBox buttons = new VBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.TOP_CENTER);
        buttons.getChildren().addAll(addInv,addCus,addArt,showInv);
        //buttons.setStyle("-fx-background-color: #ac383d");

        //---BUTTONS STYLE---
        for (Node b : buttons.getChildren()){
            b.setStyle(Styles.menu_button);
            Styles.set_Hover_Style((Button) b);
        }
        exit.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(exit);
        invBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(invBack);
        cusBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(cusBack);
        showInvBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(showInvBack);
        showInvBack2.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(showInvBack2);
        artBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(artBack);
        invArtBack.setStyle(Styles.menu_button);
        Styles.set_Hover_Style(invArtBack);


        //---MENU BORDER PANE---
        BorderPane left = new BorderPane();
        left.setPadding(new Insets(50, 0, 20, 0));
        left.setCenter(buttons);
        left.setBottom(exit);
        left.setStyle("-fx-background-color: #ac383d");
//        Label menu_title = new Label("MENU");
//        menu_title.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
//                "-fx-font-size: 25;-fx-text-fill: #000000;-fx-background-color: #970500;-fx-alignment: Center");
//        left.setTop(menu_title);

        //--CENTER PANES---
        //-------------------
        //IVOICE CENTER
        //-------------------
        BorderPane invoice_center = new BorderPane();
        //invoice_center.setPadding(new Insets(0,0,0,0));
        Label choose_customer_title = new Label("Wybierz klienta");
        choose_customer_title.setStyle("-fx-min-width: 250;-fx-min-height: 50;-fx-max-height: 50;-fx-font-weight: 500;" +
                "-fx-font-size: 20;-fx-text-fill: #ffffff;-fx-background-color: transparent;-fx-alignment: Center;" +
                "-fx-background-color: #ac383d");
        VBox choose_cust_menu = new VBox();
        choose_cust_menu.setPadding(new Insets(0,0,0,0));
        choose_cust_menu.getChildren().addAll(invBack,choose_customer_title);
        choose_cust_menu.setStyle("-fx-background-color: #9a2533");
        invoice_center.setLeft(choose_cust_menu);
//        ArrayList<Button> buttonList = new ArrayList<>();
//        System.out.println(Database.customers.size());
        for (Customer cust : Database.customers){

//            System.out.println(cust.getName());
            Button temp = new Button(cust.getName());
            temp.setStyle(Styles.menu_button);
            Styles.set_Hover_Style(temp);
//            buttonList.add(temp);
            choose_cust_menu.getChildren().addAll(temp);

            temp.setOnMouseClicked(event -> {
                addInvCustButAction(invArtBack, invoice_center, cust);

            });
        }

        //-------------------
        //ADD CUSTOMER CENTER
        //-------------------

        GridPane customer_center = new GridPane();
        customer_center.setStyle("-fx-background-color: #9a2533");
        Label add_customer_title = new Label("Wprowadź dane");
        add_customer_title.setStyle(Styles.menu_button +
                "-fx-background-color: #ac383d;");
        customer_center.add(cusBack,0,0);
        customer_center.add(add_customer_title,0,1);
        Label dump = new Label(" ");
        dump.setStyle(Styles.menu_button);
        customer_center.add(dump,0,2);
        //customer_center.setVgap(10);

        Label nip_label = new Label("NIP");
        Label name_label = new Label("Nazwa");
        Label address_label = new Label("Adres");
        Label phone_label = new Label("Telefon");

        TextField nip_tf = new TextField();
        TextField name_tf = new TextField();
        TextField address_tf = new TextField();
        TextField phone_tf = new TextField();

        customer_center.add(nip_label, 0,3);
        customer_center.add(name_label,0,4);
        customer_center.add(address_label,0,5);
        customer_center.add(phone_label,0,6);

        customer_center.add(nip_tf,1,3);
        customer_center.add(name_tf,1,4);
        customer_center.add(address_tf,1,5);
        customer_center.add(phone_tf,1,6);

        nip_label.setStyle(Styles.menu_button);
        name_label.setStyle(Styles.menu_button);
        address_label.setStyle(Styles.menu_button);
        phone_label.setStyle(Styles.menu_button);

        nip_tf.setStyle(Styles.text_field);
        name_tf.setStyle(Styles.text_field);
        address_tf.setStyle(Styles.text_field);
        phone_tf.setStyle(Styles.text_field);

        Button add_customer = new Button("Dodaj");
        add_customer.setStyle(Styles.menu_long_button);
        Styles.set_Hover_Style2(add_customer);
        customer_center.add(add_customer,0,7,3,1);

        TextField error_tf = new TextField();
        error_tf.setEditable(false);
        error_tf.setStyle(Styles.menu_button+"-fx-text-fill: #ff0000");
        customer_center.add(error_tf,0,8,4,1);

        //-------------------
        //ADD ARTICLE CENTER
        //-------------------

        GridPane article_center = new GridPane();
        article_center.setStyle("-fx-background-color: #9a2533");
        Label add_article_title = new Label("Wprowadź dane");
        add_article_title.setStyle(Styles.menu_button +
                "-fx-background-color: #ac383d;");
        article_center.add(artBack,0,0);
        article_center.add(add_article_title,0,1);
        Label dump2 = new Label(" ");
        dump2.setStyle(Styles.menu_button);
        article_center.add(dump2,0,2);
        //article_center.setVgap(10);

        Label id_label = new Label("ID");
        Label add_art_name_label = new Label("Nazwa");
        Label add_price_label = new Label("Cena");

        TextField id_tf = new TextField();
        TextField art_name_tf = new TextField();
        TextField price_tf = new TextField();

        article_center.add(id_label, 0,3);
        article_center.add(add_art_name_label,0,4);
        article_center.add(add_price_label,0,5);

        article_center.add(id_tf,1,3);
        article_center.add(art_name_tf,1,4);
        article_center.add(price_tf,1,5);

        id_label.setStyle(Styles.menu_button);
        add_art_name_label.setStyle(Styles.menu_button);
        add_price_label.setStyle(Styles.menu_button);

        id_tf.setStyle(Styles.text_field);
        art_name_tf.setStyle(Styles.text_field);
        price_tf.setStyle(Styles.text_field);

        Button add_article = new Button("Dodaj");
        add_article.setStyle(Styles.menu_long_button);
        Styles.set_Hover_Style2(add_article);
        article_center.add(add_article,0,7,3,1);

        TextField art_error_tf = new TextField();
        art_error_tf.setEditable(false);
        art_error_tf.setStyle(Styles.menu_button+"-fx-text-fill: #ff0000");
        article_center.add(art_error_tf,0,8,4,1);

        //-------------------
        //SHOW INVOICE CENTER
        //-------------------

        BorderPane show_invoice_center = new BorderPane();

        Label choose_cust_show_title = new Label("Wybierz Klienta");
        choose_cust_show_title.setStyle(Styles.label);

        VBox choose_cust_show_menu = new VBox();
        choose_cust_show_menu.setPadding(new Insets(0,0,0,0));
        choose_cust_show_menu.getChildren().addAll(showInvBack,choose_cust_show_title);
        choose_cust_show_menu.setStyle("-fx-background-color: #9a2533");

        VBox scroll_cust_show_menu = new VBox();
        scroll_cust_show_menu.setPadding(new Insets(0,0,0,0));
        scroll_cust_show_menu.setStyle("-fx-background-color: #9a2533");

        ScrollPane scroll_cust_show = new ScrollPane(scroll_cust_show_menu);
        scroll_cust_show.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll_cust_show.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll_cust_show.setPadding(new Insets(0,0,0,0));
        choose_cust_show_menu.getChildren().add(scroll_cust_show);

        show_invoice_center.setLeft(choose_cust_show_menu);

        for(Customer cust : Database.customers) {

            Button temp = new Button(cust.getName());
            temp.setStyle(Styles.menu_button);
            Styles.set_Hover_Style(temp);
            scroll_cust_show_menu.getChildren().addAll(temp);
            temp.setOnMouseClicked(event -> {

                showInvCustButAction(showInvBack2, show_invoice_center, cust);

            });
        }


        //---ROOT BORDER PANE---
        BorderPane root = new BorderPane();
//        root.setPadding(new Insets(15,15,15,15));
//        root.setTop(topTitle);
//        root.setAlignment(topTitle,Pos.CENTER);
        root.setLeft(left);
        root.setMargin(buttons, root.getInsets());
        root.setStyle("-fx-background-image: url('mainbg.jpg')");
//        root.setStyle("-fx-background-color: #0b05c7");

        //---ACTIONS---
        exit.setOnAction(event -> {
            System.exit(0);
        });
        addInv.setOnMouseClicked(event -> {
            root.setCenter(invoice_center);
        });
        addArt.setOnMouseClicked(event -> {
            root.setCenter(article_center);
        });
        addCus.setOnMouseClicked(event -> {
            root.setCenter(customer_center);
        });
        showInv.setOnMouseClicked(event -> {
            root.setCenter(show_invoice_center);
        });
        invBack.setOnMouseClicked(event -> {
            root.setCenter(null);
        });
        invArtBack.setOnMouseClicked(event -> {
            invoice_center.setLeft(choose_cust_menu);
            invoice_center.setCenter(null);
        });
        artBack.setOnMouseClicked(event -> {
            root.setCenter(null);
        });
        cusBack.setOnMouseClicked(event -> {
            root.setCenter(null);
        });
        showInvBack.setOnMouseClicked(event -> {
            root.setCenter(null);
            show_invoice_center.setCenter(null);
        });
        showInvBack2.setOnMouseClicked(event -> {
            show_invoice_center.setLeft(choose_cust_show_menu);
            show_invoice_center.setCenter(null);
        });
        add_customer.setOnMouseClicked(event -> {
            try {
                Customer cust = new Customer(nip_tf.getText(), name_tf.getText(), address_tf.getText(), phone_tf.getText());
                Database.customers.add(cust);

                Button temp = new Button(name_tf.getText());
                temp.setStyle(Styles.menu_button);
                Styles.set_Hover_Style(temp);
                temp.setOnMouseClicked(event1 -> {
                    addInvCustButAction(invArtBack, invoice_center, cust);
                });
                choose_cust_menu.getChildren().addAll(temp);


                Button temp2 = new Button(name_tf.getText());
                temp2.setStyle(Styles.menu_button);
                Styles.set_Hover_Style(temp2);
                temp2.setOnMouseClicked(event1 -> {
                    showInvCustButAction(showInvBack2, show_invoice_center, cust);
                });
                scroll_cust_show_menu.getChildren().addAll(temp2);

                nip_tf.setText("");
                name_tf.setText("");
                address_tf.setText("");
                phone_tf.setText("");
                error_tf.setText("Dodano klienta!");
            }
            catch (IllegalArgumentException ex){
                error_tf.setText(ex.getMessage());
            }
        });
        add_article.setOnMouseClicked(event -> {
            try {
                double price = Double.parseDouble(price_tf.getText());
                int artId = Integer.parseInt(id_tf.getText());
                Database.articles.add(new Article(artId, art_name_tf.getText(), price));

//                Button temp = new Button(art_name_tf.getText());
//                temp.setStyle(Styles.menu_button);
//                Styles.set_Hover_Style(temp);
//                buttonList.add(temp);

                id_tf.setText("");
                art_name_tf.setText("");
                price_tf.setText("");
                art_error_tf.setText("Dodano Artykuł");
            }
            catch (IllegalArgumentException ex){
                art_error_tf.setText(ex.getMessage());
            }
        });

        //---CREATE MAIN SCENE AND MANAGE STAGE---
        Scene mainScene = new Scene(root, 1280,720);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Faktury");
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

    private void showInvCustButAction(Button showInvBack2, BorderPane show_invoice_center, Customer cust) {
        Label choose_invoice_title = new Label("Wybierz fakturę");
        choose_invoice_title.setStyle(Styles.label);

        VBox choose_inv_menu = new VBox();
        choose_inv_menu.setPadding(new Insets(0, 0, 0, 0));
        choose_inv_menu.getChildren().addAll(showInvBack2, choose_invoice_title);
        choose_inv_menu.setStyle("-fx-background-color: #9a2533");
        show_invoice_center.setLeft(choose_inv_menu);

        VBox scroll_inv_menu = new VBox();
        scroll_inv_menu.setPadding(new Insets(0, 0, 0, 0));
        scroll_inv_menu.setStyle("-fx-background-color: #9a2533");

        ScrollPane scroll_invoices = new ScrollPane(scroll_inv_menu);
        scroll_invoices.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll_invoices.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll_invoices.setPadding(new Insets(0, 0, 0, 0));
        choose_inv_menu.getChildren().add(scroll_invoices);

//        System.out.println(Database.invoices.size());

        for (Invoice inv : cust.getInvoiceList()) {
            String name = cust.getName() + " - " + inv.getNumber().substring(11);
            Button temp1 = new Button(name);
            temp1.setOnMouseClicked(event1 -> {
                GridPane show_inv_grid_labels = new GridPane();
                show_inv_grid_labels.setStyle("-fx-background-color: #91201c");

                Label number_label = new Label("Faktura nr " + inv.getNumber());
                Label art_name_label = new Label("Nazwa");
                Label quantity_label = new Label("Ilość");
                Label price_label = new Label("Cena");
                Label value_label = new Label("Wartość");

                number_label.setStyle(Styles.invShowlabel);
                art_name_label.setStyle(Styles.invShowlabel2);
                quantity_label.setStyle(Styles.invShowlabel3);
                price_label.setStyle(Styles.invShowlabel2);
                value_label.setStyle(Styles.invShowlabel3);

                show_inv_grid_labels.add(number_label,0,0,4,1);
                show_inv_grid_labels.add(art_name_label,0,1);
                show_inv_grid_labels.add(quantity_label,1,1);
                show_inv_grid_labels.add(price_label,2,1);
                show_inv_grid_labels.add(value_label,3,1);

                GridPane show_inv_grid_entries = new GridPane();
                show_inv_grid_entries.setStyle("-fx-background-color: #91201c");

                int counter = 0;
                for(Entry ent : inv.getEntryList()){
                    Label art_name = new Label(ent.getArticle().getName());
                    Label quantity = new Label("" + ent.getQuantity());
                    Label price = new Label("" + ent.getArticle().getPrice());
                    Label value = new Label("" + ent.getValue());

                    art_name.setStyle(Styles.invShowlabel3);
                    quantity.setStyle(Styles.invShowlabel3);
                    price.setStyle(Styles.invShowlabel3);
                    value.setStyle(Styles.invShowlabel3);

                    show_inv_grid_entries.add(art_name,0,counter);
                    show_inv_grid_entries.add(quantity,1,counter);
                    show_inv_grid_entries.add(price,2,counter);
                    show_inv_grid_entries.add(value,3,counter);
                    counter++;
                }
                ScrollPane scroll_entries = new ScrollPane(show_inv_grid_entries);
                scroll_entries.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scroll_entries.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scroll_entries.setPadding(new Insets(0,0,0,0));
                scroll_entries.setStyle("-fx-background-color: transparent;-fx-background: transparent");
                VBox show_inv_merge = new VBox();
                show_inv_merge.setMinHeight(620);
                show_inv_merge.setStyle("-fx-background-color: #91201c");
                if(!show_inv_grid_entries.getChildren().isEmpty()) {
                    show_inv_merge.getChildren().addAll(show_inv_grid_labels, scroll_entries);
                }
                else {
                    show_inv_merge.getChildren().addAll(show_inv_grid_labels);
                }
                show_invoice_center.setCenter(show_inv_merge);
            });
            temp1.setStyle(Styles.menu_button);
            Styles.set_Hover_Style(temp1);
            scroll_inv_menu.getChildren().addAll(temp1);
        }
    }

    private void addInvCustButAction(Button invArtBack, BorderPane invoice_center, Customer cust) {
        ArrayList<Entry> entList = new ArrayList<>();

        Label enter_quantity_label = new Label("Wpisz ilość");
        enter_quantity_label.setStyle(Styles.label);

        TextField enter_quantity_tf = new TextField();
        enter_quantity_tf.setStyle(Styles.narrow_text_field);
        enter_quantity_tf.setOnMouseClicked(event1 -> {
            enter_quantity_tf.setText("");

        });

        Label choose_article_label = new Label("Wybierz artykuł");
        choose_article_label.setStyle(Styles.label);

        VBox choose_art_menu = new VBox();
        choose_art_menu.setPadding(new Insets(0,0,0,0));

        choose_art_menu.setStyle("-fx-background-color: #9a2533");
        invoice_center.setLeft(choose_art_menu);

        VBox art_scrollbox = new VBox();

        art_scrollbox.setPadding(new Insets(0,0,0,0));

        ScrollPane art_scrollpane = new ScrollPane(art_scrollbox);
        art_scrollpane.setStyle("-fx-background: transparent;-fx-background-color: transparent");
        art_scrollpane.setPadding(new Insets(0,0,0,0));
        art_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        art_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        choose_art_menu.setOnMouseClicked(event1 -> {
            if(art_scrollbox.getChildren().size() != Database.articles.size()){
                for(int i=art_scrollbox.getChildren().size();i<Database.articles.size();i++) {
                    Button temp3 =new Button(Database.articles.get(i).getName());
                    temp3.setStyle(Styles.menu_button);
                    Styles.set_Hover_Style(temp3);
                    art_scrollbox.getChildren().add(temp3);
                    final int index = i;
                    temp3.setOnMouseClicked(event2 -> {
                        addInvArtButAction(invoice_center, cust, entList, enter_quantity_tf, choose_art_menu, Database.articles.get(index));
                    });
                }
            }

        });

        choose_art_menu.getChildren().addAll(invArtBack,enter_quantity_label,enter_quantity_tf, choose_article_label,art_scrollpane);

        for (Article art : Database.articles){
            Button temp2 = new Button(art.getName());
            temp2.setStyle(Styles.menu_button);
            Styles.set_Hover_Style(temp2);
//            buttonList.add(temp);
            art_scrollbox.getChildren().addAll(temp2);
                temp2.setOnMouseClicked(event1 -> {
                    addInvArtButAction(invoice_center, cust, entList, enter_quantity_tf, choose_art_menu, art);
                });
            }
    }

    private void addInvArtButAction(BorderPane invoice_center, Customer cust, ArrayList<Entry> entList, TextField enter_quantity_tf, VBox choose_art_menu, Article art) {
        try {
            double quan = Double.parseDouble(enter_quantity_tf.getText());

            entList.add(new Entry(art,quan));

            GridPane show_inv_grid_labels = new GridPane();
            show_inv_grid_labels.setStyle("-fx-background-color: #91201c");

            Label title_label = new Label("Nowa Faktura");
            Label art_name_label = new Label("Nazwa");
            Label quantity_label = new Label("Ilość");
            Label price_label = new Label("Cena");
            Label value_label = new Label("Wartość");

            title_label.setStyle(Styles.invShowlabel);
            art_name_label.setStyle(Styles.invShowlabel2);
            quantity_label.setStyle(Styles.invShowlabel3);
            price_label.setStyle(Styles.invShowlabel2);
            value_label.setStyle(Styles.invShowlabel3);

            show_inv_grid_labels.add(title_label, 0, 0, 4, 1);
            show_inv_grid_labels.add(art_name_label, 0, 1);
            show_inv_grid_labels.add(quantity_label, 1, 1);
            show_inv_grid_labels.add(price_label, 2, 1);
            show_inv_grid_labels.add(value_label, 3, 1);

            GridPane show_inv_grid_entries = new GridPane();
            show_inv_grid_entries.setStyle("-fx-background-color: #91201c");

            int counter = 0;

            ScrollPane scroll_entries = new ScrollPane(show_inv_grid_entries);
            scroll_entries.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_entries.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll_entries.setPadding(new Insets(0, 0, 0, 0));
            scroll_entries.setStyle("-fx-background-color: transparent;-fx-background: transparent");
            VBox show_inv_merge = new VBox();
            show_inv_merge.setMinHeight(620);
            show_inv_merge.setStyle("-fx-background-color: #91201c");

            for (Entry ent : entList) {
                Label art_name = new Label(ent.getArticle().getName());
                Label quantity = new Label("" + ent.getQuantity());
                Label price = new Label("" + ent.getArticle().getPrice());
                Label value = new Label("" + ent.getValue());

                art_name.setStyle(Styles.invShowlabel3);
                quantity.setStyle(Styles.invShowlabel3);
                price.setStyle(Styles.invShowlabel3);
                value.setStyle(Styles.invShowlabel3);

                show_inv_grid_entries.add(art_name, 0, counter);
                show_inv_grid_entries.add(quantity, 1, counter);
                show_inv_grid_entries.add(price, 2, counter);
                show_inv_grid_entries.add(value, 3, counter);
                counter++;
            }

            VBox confirmbox = new VBox();
            confirmbox.setStyle("-fx-background-color: #9a2533");
            confirmbox.setAlignment(Pos.BOTTOM_CENTER);

            Button confirm = new Button("Zapisz Fakturę!");
            confirm.setStyle(Styles.menu_button_middle);
            Styles.set_Hover_Style3(confirm);

            confirmbox.getChildren().add(confirm);

            confirm.setOnMouseClicked(event2 -> {
                cust.createInvoice(entList);
                Invoice newInv = cust.getLatestInvoice();
                title_label.setText("ZAPISANO! - Faktura nr " + newInv.getNumber());
                choose_art_menu.getChildren().remove(1,choose_art_menu.getChildren().size());
                confirmbox.getChildren().remove(confirm);
            });


            show_inv_merge.getChildren().addAll(show_inv_grid_labels, scroll_entries, confirmbox);
            invoice_center.setCenter(show_inv_merge);
        }
        catch (Exception ex){
            enter_quantity_tf.setText("Błędna wartość!");
        }
    }


}