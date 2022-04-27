
import java.sql.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafx.print.Paper.C;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import java.util.*;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;


public class Store extends Application {
    
    Book book = new Book();
        Admin admin = new Admin();
        User user = new User();
        
        ArrayList<Book> books = new ArrayList<>();
        
        
        
    
    public void start(Stage primaryStage) throws Exception {
        //Creating a GridPane container
       
        books.add(new Book("c how to program","computer science","Dietal",900));
        books.add(new Book("Calculus","math","thomson",500));
        books.add(new Book("java how to program","computer science","Dietal",700));
        
        user.purchasedBooks.add(new Book("practice book","english","Paul",200));
        
        HBox hbox2 = new HBox();
        Text header = new Text("WELCOME TO BOOK STORE");
        header.setFont(Font.font("Ariel",FontWeight.BOLD, 20));

        header.setY(120);
        header.setX(0);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.add(header, 0, 0, 2, 1);

        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter your name.");
        hbox2.getChildren().add(name);
        grid.setAlignment(Pos.CENTER);
        //Defining the Submit button
        Button submit = new Button("Submit");
        
        submit.setOnAction(e-> {
            if (name.getText().equals(admin.getName())) {
                Stage stg = new Stage();
                Text adminpanel = new Text("ADMIN PANEL");
                adminpanel.setFont(Font.font("Ariel",FontWeight.BOLD, 20));
                adminpanel.setY(120);
                adminpanel.setX(0);
                GridPane adminGrid = new GridPane();
                VBox vb = new VBox();
                adminGrid.add(adminpanel,0,0);
                adminGrid.setAlignment(Pos.CENTER);
                adminGrid.setPadding(new Insets(10, 10, 10, 10));
                adminGrid.setVgap(5);
                adminGrid.setHgap(5);
                for (int i=0;i<books.size();i++) {
                    vb.getChildren().add(new Text(i+1 + "  Book Name: " + books.get(i).getTitle()));
                    vb.getChildren().add(new Text("  Book Subject: " + books.get(i).getSubject()));
                    vb.getChildren().add(new Text("  Book Author: " + books.get(i).getAuthor()));
                    vb.getChildren().add(new Text("  Book Price: " + books.get(i).getBookPrice()));
                    
//                    adminGrid.add(new Text(""), 0, 10+i);
                    
                }
                adminGrid.add(vb, 0, 5);
                
                Button addBook = new Button("Add Book");
                addBook.setOnAction(eh-> {
                    
                    GridPane add = new GridPane();
                    add.setPadding(new Insets(10, 10, 10, 10));
                    add.setVgap(5);
                    add.setHgap(5);
                    add.setAlignment(Pos.CENTER);
                    HBox hb = new HBox();
                    HBox hb1 = new HBox();
                    HBox hb2 = new HBox();
                    HBox hb3 = new HBox();
                    
                    Text t1 = new Text("Enter Book Name: ");
                    final TextField bookname = new TextField();
                    bookname.setPromptText("Book Name");
                    hb.getChildren().addAll(t1,bookname);
                    Text t2 = new Text("Enter Book Author: ");
                    final TextField auth = new TextField();
                    auth.setPromptText("Book Author");
                    hb1.getChildren().addAll(t2,auth);
                    Text t3 = new Text("Enter Book Subject: ");
                    final TextField booksubject = new TextField();
                    booksubject.setPromptText("Book Subject");
                    hb2.getChildren().addAll(t3,booksubject);
                    Text t4 = new Text("Enter Book Price: ");
                    final TextField bookprice = new TextField();
                    bookprice.setPromptText("Book Price");
                    hb3.getChildren().addAll(t4,bookprice);
                    Button sub = new Button("Submit");
                   
                   
                    sub.setOnAction(event -> {
                   try {
                   int txt = Integer.parseInt(bookprice.getText());
                       System.out.println(txt);
                        books.add(new Book(bookname.getText(),booksubject.getText(),auth.getText(),txt));
                        showMessageDialog(null, "Book Added Successfully");
                        
                    
                   } catch(NumberFormatException exp) {
                       System.out.println(exp.getMessage());
                   }
                   
                    });
                    sub.setAlignment(Pos.CENTER);
                    add.setAlignment(Pos.CENTER);
                    add.add(hb, 0, 0);
                    add.add(hb1, 0, 1);
                    add.add(hb2, 0, 2);
                    add.add(hb3, 0, 3);
                    add.add(sub, 0, 5);
                    
                    Stage s1 = new Stage();
                    Scene sc1 = new Scene(add,400,600);
                    s1.setScene(sc1);
                    s1.show();
                });
                Button updateBook = new Button("Update Book");
                updateBook.setOnAction(ev->{
                    Stage ns = new Stage();
                    GridPane update = new GridPane();
                    update.setAlignment(Pos.CENTER);
                    HBox h1 = new HBox();
                    HBox h2 = new HBox();
                    HBox h3 = new HBox();
                    HBox h4 = new HBox();
                    HBox h5 = new HBox();
                    
                    Button submitId = new Button("Submit ID");
                    
                    Text tid = new Text("Enter Book ID: ");
                    final TextField bookid = new TextField();
                    bookid.setPromptText("Book ID");
                    h1.getChildren().addAll(tid,bookid);
                    Text t1 = new Text("Enter Book Name: ");
                    final TextField bookname = new TextField();
                    bookname.setPromptText("Book Name");
                    h2.getChildren().addAll(t1,bookname);
                    Text t2 = new Text("Enter Book Author: ");
                    final TextField auth = new TextField();
                    auth.setPromptText("Book Author");
                    h3.getChildren().addAll(t2,auth);
                    Text t3 = new Text("Enter Book Subject: ");
                    final TextField booksubject = new TextField();
                    booksubject.setPromptText("Book Subject");
                    h4.getChildren().addAll(t3,booksubject);
                    Text t4 = new Text("Enter Book Price: ");
                    final TextField bookprice = new TextField();
                    bookprice.setPromptText("Book Price");
                    h5.getChildren().addAll(t4,bookprice);
                    Button subupd = new Button("Update");
                    submitId.setOnAction(eh-> {
                        try {
                            int txt = Integer.parseInt(bookid.getText())-1;
                            bookname.setText(books.get(txt).getTitle());
                            auth.setText(books.get(txt).getAuthor());
                            booksubject.setText(books.get(txt).getSubject());
                            bookprice.setText(String.valueOf(books.get(txt).getBookPrice()));
                        
                            
                        } catch (NumberFormatException exp) {
                            exp.printStackTrace();
                        }
                    });
                    
                    update.add(h1, 0, 0);
                    update.add(submitId,1,0);
                    update.add(h2, 0, 2);
                    update.add(h3, 0, 3);
                    update.add(h4, 0, 4);
                    update.add(h5, 0, 5);
                    update.add(subupd, 0, 7);
                    Scene updscn = new Scene(update,800,400);
                    
                    subupd.setOnAction(eh-> {
                        try {
                            int txt = Integer.parseInt(bookid.getText())-1;
                            int txt1 = Integer.parseInt(bookprice.getText());
                            books.set(txt, new Book(bookname.getText(),booksubject.getText(),auth.getText(),txt1));
                            showMessageDialog(null, "Book Updated Successfully");
                            stg.getScene();
                stg.show();
                            
                        } catch (NumberFormatException exp) {
                            exp.printStackTrace();
                        }
                    });
                    ns.setScene(updscn);
                    ns.show();
                    
                });
                Button deleteBook = new Button("Delete Book");
                deleteBook.setOnAction(eh->{
                    Stage newstg = new Stage();
                    GridPane gd = new GridPane();
                    Scene newscn = new Scene(gd, 600, 400);
                    newstg.setScene(newscn);
                    HBox h1 = new HBox();
                    gd.setAlignment(Pos.CENTER);
                    gd.setPadding(new Insets(10, 10, 10, 10));
                    gd.setVgap(5);
                    gd.setHgap(5);
                    
                    Text tid = new Text("Enter Book ID: ");
                    final TextField bookid = new TextField();
                    bookid.setPromptText("Book ID");
                    Button btn = new Button("Submit");
                    btn.setOnAction(ae-> {
                        try {
                            int n = Integer.parseInt(bookid.getText())-1;
                        Text confirm = new Text("Are you sure you want to delete\n" + books.get(n).getTitle());
                        Button yes = new Button("Yes");
                        yes.setOnAction(evt-> {
                            books.remove(n);
                            showMessageDialog(null, "Book Deleted Successfully");
                            newstg.close();
                            
                        });
                        Button no = new Button("No");
                        no.setOnAction(ne-> {
                            showMessageDialog(null, "Operation Aborted");
                            newstg.close();
                        });
                        HBox hb1 = new HBox();
                        hb1.setSpacing(10);
                        hb1.getChildren().addAll(yes,no);
                        gd.add(confirm, 0, 3);
                        gd.add(hb1, 0, 5);
                        } catch(NumberFormatException exp) {
                            exp.printStackTrace();
                        }
                    });
                    h1.getChildren().addAll(tid,bookid);
                    gd.add(h1, 0, 0);
                    gd.add(btn, 0, 1);
                    
                    
                    newstg.show();
                });
                HBox buttons = new HBox();
                buttons.setAlignment(Pos.CENTER);
                buttons.setSpacing(10);
                buttons.getChildren().addAll(addBook, updateBook, deleteBook);
                adminGrid.add(buttons, 0, 8);
                Scene scn = new Scene(adminGrid, 600, 800);
                stg.setScene(scn);
                stg.show();
                
                
            } else if (name.getText().equals(user.getName())) {
                Stage stg = new Stage();
                Text userpanel = new Text("USER PANEL");
                userpanel.setFont(Font.font("Ariel",FontWeight.BOLD, 20));
                userpanel.setY(120);
                userpanel.setX(0);
                GridPane userGrid = new GridPane();
                VBox vb = new VBox();
                userGrid.add(userpanel,0,0);
                userGrid.setAlignment(Pos.CENTER);
                userGrid.setPadding(new Insets(10, 10, 10, 10));
                userGrid.setVgap(5);
                userGrid.setHgap(5);
                for (int i=0;i<books.size();i++) {
                    vb.getChildren().add(new Text(i+1 + "  Book Name: " + books.get(i).getTitle()));
                    vb.getChildren().add(new Text("  Book Subject: " + books.get(i).getSubject()));
                    vb.getChildren().add(new Text("  Book Author: " + books.get(i).getAuthor()));
                    vb.getChildren().add(new Text("  Book Price: " + books.get(i).getBookPrice()));
                    
//                    adminGrid.add(new Text(""), 0, 10+i);
                    
                }
                userGrid.add(vb, 0, 5);
                HBox hb = new HBox();
                hb.setSpacing(10);
                Button purchase = new Button("Purchase Book");
                
                purchase.setOnAction(eh->{
                    Stage new1 = new Stage();
                    GridPane gd = new GridPane();
                    HBox h1 = new HBox();
                    Text tid = new Text("Enter Book ID: ");
                    final TextField bookid = new TextField();
                    bookid.setPromptText("Book ID");
                    Button btn = new Button("Submit");
                    h1.getChildren().addAll(bookid,btn);
                    gd.setAlignment(Pos.CENTER);
                    gd.setPadding(new Insets(10, 10, 10, 10));
                    gd.setVgap(5);
                    gd.setHgap(5);
                    gd.add(tid, 0, 0);
                    gd.add(h1,0,1);
                    
                    btn.setOnAction(evt->{
                        try {
                            int next = Integer.parseInt(bookid.getText())-1;
                            Text prompt = new Text("Are you sure you want to buy \n" + books.get(next).getTitle() + "for $" + 
                                    books.get(next).getBookPrice());
                            HBox h2 = new HBox();
                            Button yes = new Button("Yes");
                        yes.setOnAction(ev-> {
                            user.purchasedBooks.add(books.get(next));
                            showMessageDialog(null, "Book Purchased Successfully");
                            new1.close();
                            
                        });
                            Button no = new Button("No");
                        no.setOnAction(ev-> {
                            showMessageDialog(null, "Operation Aborted");
                            new1.close();
                            
                        });
                            h2.getChildren().addAll(yes,no);
                            gd.add(prompt, 0, 3);
                            gd.add(h2, 0, 5);
                            
                        } catch(NumberFormatException exp) {
                            exp.printStackTrace();
                        }
                    });
                    
                    Scene newscn = new Scene(gd, 600, 400);
                    new1.setScene(newscn);
                    new1.show();
                    
                });
                Button view = new Button("View Purchased Books");
                view.setOnAction(eh->{
                    Stage viewstge = new Stage();
                    GridPane viewbooks = new GridPane();
                    VBox vb1 = new VBox();
                    viewbooks.setAlignment(Pos.CENTER);
                    viewbooks.setPadding(new Insets(10, 10, 10, 10));
                    viewbooks.setVgap(5);
                    viewbooks.setHgap(5);
                    
                    for (int i=0;i<user.purchasedBooks.size();i++) {
                        vb1.getChildren().add(new Text(i+1 + "  Book Name: " + user.purchasedBooks.get(i).getTitle()));
                        vb1.getChildren().add(new Text("  Book Subject: " + user.purchasedBooks.get(i).getSubject()));
                        vb1.getChildren().add(new Text("  Book Author: " + user.purchasedBooks.get(i).getAuthor()));
                        vb1.getChildren().add(new Text("  Book Price: " + user.purchasedBooks.get(i).getBookPrice()));
                    
                }
                    Button done = new Button("Done");
                    done.setOnAction(eb-> {viewstge.close();});
                    viewbooks.add(done, 0, 3);
                    viewbooks.add(vb1, 0, 0);
                
                Scene newscne = new Scene(viewbooks,600, 600);
                viewstge.setScene(newscne);
                viewstge.setTitle("View Books");
                viewstge.show();
                
                });
//                Button exit = new Button("Exit");
                hb.getChildren().addAll(purchase,view);
                userGrid.add(hb, 0, 8);
//                userGrid.add(exit, 0, 9);
                Scene scn = new Scene(userGrid, 600, 800);
                stg.setScene(scn);
                stg.show();
               
                
            }
        });
        hbox2.getChildren().add(submit);
        Text n = new Text("Please enter your name: ");
        grid.add(n, 0, 9);
        grid.add(hbox2, 0, 10);
        Scene scene = new Scene(grid,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Store");
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        
        launch(args);
//        
        
//        String ad;
//        // TODO code application logic here
//        System.out.println("Welcome to book store!");
//        System.out.println("Please enter your name");
//        ad = scan.nextLine();
//        
//        if (ad.equals(admin.getName()))
//        {
//            String adminchoice = "y";
//            do {
//                System.out.println("________________Admin Portal________________\n");
//            
//            for (int i=0;i<books.size(); i++) {
//                System.out.println(i+1 + ". Book Name: " + books.get(i).getTitle());
//                System.out.println(" Book Subject: " + books.get(i).getSubject());
//                System.out.println(" Book Author: " + books.get(i).getAuthor());
//                System.out.println(" Book Price: " + books.get(i).getBookPrice());
//                
//            }
//            
//            System.out.println("____________________________________________\n\n");
//            System.out.println("Press 1 to Add Book\n");
//            System.out.println("Press 2 to Update Book\n");
//            System.out.println("Press 3 to Delete Book\n");
//            
//            System.out.println("Enter your choice: ");
//            int choice = scan.nextInt();
//            scan.nextLine();
//            
//            switch(choice) {
//                case 1:
//                    
//                    System.out.println("Enter Book Name: ");
//                    String t = scan.nextLine();
//                    
//                    System.out.println("Enter Book subject: ");
//                    String subj = scan.nextLine();
//                    
//                    System.out.println("Enter Book Author: ");
//                    String author = scan.nextLine();
//                    
//                    System.out.println("Enter Book Price: ");
//                    int price = scan.nextInt();
//                    
//                    books.add(new Book(t,subj,author,price));
//                    
//                    System.out.println("Book Added Successfully!");
//                    break;
//                    
//                case 2:
//                    
//                    System.out.println("Enter book id to update book");
//                    int id = scan.nextInt()-1;
//                    scan.nextLine();
//                    
//                    
//                    String auth = books.get(id).getAuthor();
//                    String sub = books.get(id).getSubject();
//                    String title = books.get(id).getTitle();
//                    int pr = books.get(id).getBookPrice();
//                    
//                    System.out.println("\nUpdate Author? (y/n)");
//                    String input = scan.nextLine();
//        
//                    if(input.equals("y"))
//                    {
//                        System.out.println("\nEnter new Author: ");
//                        auth = scan.nextLine();
//                    }
//
//                    System.out.println("\nUpdate Subject? (y/n)");
//                    input = scan.next();
//
//                    if(input.equals("y"))
//                    {
//                        System.out.println("\nEnter new Subject: ");
//                        sub = scan.nextLine();
//                    }
//
//                    System.out.println("\nUpdate Title? (y/n)");
//                    input = scan.next();
//
//                    if(input.equals("y"))
//                    {
//                        System.out.println("\nEnter new Title: ");
//                        title = scan.nextLine();
//                    }
//
//                    System.out.println("\nUpdate Price? (y/n)");
//                    input = scan.next();
//
//                    if(input.equals("y"))
//                    {
//                        System.out.println("\nEnter new Price: ");
//                        pr = scan.nextInt();
//                    }
//                    
//                    books.set(id,new Book(title,sub,auth,pr));
//                    
//                    System.out.println("Book Updated successfully");
//                    break;
//                
//                case 3:
//                    String c;
//                    System.out.println("Enter Book ID");
//                    int n = scan.nextInt()-1;
//                    
//                    System.out.println("Are you sure you want to delete " + books.get(n).getTitle() + "\n y/n");
//                    c = scan.next();
//                    if (c.equals("y"))
//                    {
//                        books.remove(n);
//                        
//                        System.out.println("Book Deleted Successfully!");
//                    } else {
//                        System.out.println("Operation aborted");
//                    }
//                    break;
//                    
//                default:
//                    System.out.println("Enter correct choice!");
//
//                    
//                    
//            }
//                
//            System.out.println("press y to return to menu or press any key to exit");
//            adminchoice = scan.next();
//                    
//            } while (adminchoice.equals("y"));
//            
//            
//            
//        }
//        else if ( ad.equals(user.getName())){
//            String cc;
//            String userchoice = "y";
//            do {
//                
//                System.out.println("________________User Portal________________\n");
//                
//                System.out.println("___________LIST OF BOOKS AVAILABLE___________");
//            
//            for (int i=0;i<books.size(); i++) {
//                System.out.println(i+1 + ". Book Name: " + books.get(i).getTitle());
//                System.out.println(" Book Subject: " + books.get(i).getSubject());
//                System.out.println(" Book Author: " + books.get(i).getAuthor());
//                System.out.println(" Book Price: " + books.get(i).getBookPrice());
//                
//            }
//            
//            System.out.println("____________________________________________\n\n");
//            System.out.println("Press 1 to Purchase Book\n");
//            System.out.println("Press 2 to View Purchased Books\n");
//            
//            System.out.println("Enter your choice: ");
//            int choice = scan.nextInt();
//            scan.nextLine();
//            
//            switch(choice) {
//                case 1:
//                    System.out.println("Enter Book ID");
//                    int id = scan.nextInt()-1;
//                    scan.nextLine();
//                    
//                    System.out.println("Are you sure you want to purchase " + books.get(id).getTitle() + "by" + books.get(id).getAuthor() + "\nFor $" + books.get(id).getBookPrice());
//                     cc = scan.next();
//                    if (cc.equals("y"))
//                    {
//                        user.purchasedBooks.add(books.get(id));
//                        System.out.println("Book Added to inventory!");
//                    } else {
//                        System.out.println("Operation aborted");
//                    }
//                    break;
//                    
//                case 2:
//                    
//                    for (int i=0;i<user.purchasedBooks.size();i++) {
//                        System.out.println(i+1 + ". Book Name: " + user.purchasedBooks.get(i).getTitle());
//                        System.out.println(" Book Subject: " + user.purchasedBooks.get(i).getSubject());
//                        System.out.println(" Book Author: " + user.purchasedBooks.get(i).getAuthor());
//                        System.out.println(" Book Price: " + user.purchasedBooks.get(i).getBookPrice() + "\n");
//                
//                    }
//                    
//                    System.out.println("press y to return to menu or press any key to exit");
//                    userchoice = scan.next();
//            }
//                
//            } while(userchoice.equals("y"));
//            
//            
//        }
    }
    
}
