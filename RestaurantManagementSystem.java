import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RestaurantManagementSystem extends Frame {
    private TextArea outputArea;
    private Choice menuChoice;
    private TextField quantityField;

    private Connection connection;

    public RestaurantManagementSystem() {
        setTitle("Restaurant Management System");
        setSize(400, 300);

        initializeDatabaseConnection();

        // Create GUI components
        outputArea = new TextArea();
        outputArea.setEditable(false);

        menuChoice = new Choice();
        populateMenuChoices();

        quantityField = new TextField(5);

        Button addToOrderButton = new Button("Add to Order");
        addToOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToOrder();
            }
        });

        // Set layout manager to null for simplicity
        setLayout(null);

        // Set component positions
        outputArea.setBounds(20, 20, 360, 150);
        menuChoice.setBounds(20, 180, 150, 20);
        quantityField.setBounds(180, 180, 50, 20);
        addToOrderButton.setBounds(240, 180, 100, 20);

        // Add components to the frame
        add(outputArea);
        add(menuChoice);
        add(quantityField);
        add(addToOrderButton);

        // Close the frame when the close button is clicked
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                closeDatabaseConnection();
                System.exit(0);
            }
        });
    }

    private void initializeDatabaseConnection() {
        try {
            // Replace these with your database credentials
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void closeDatabaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateMenuChoices() {
        try {
            String query = "SELECT id, name FROM menu";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int menuId = resultSet.getInt("id");
                String menuName = resultSet.getString("name");
                menuChoice.add(menuId + ": " + menuName);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addToOrder() {
        int selectedMenuItemIndex = menuChoice.getSelectedIndex();
        if (selectedMenuItemIndex != -1) {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                int menuId = Integer.parseInt(menuChoice.getSelectedItem().split(":")[0].trim());

                String insertQuery = "INSERT INTO orders (menu_id, quantity) VALUES ('"+menuId+"', '"+quantity+"')";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setInt(1, menuId);
                insertStatement.setInt(2, quantity);
                insertStatement.executeUpdate();

                outputArea.append(quantity + " items added to order.\n");

                insertStatement.close();
            } catch (NumberFormatException | SQLException e) {
                outputArea.append("Invalid input.\n");
            }
        }
    }

    public static void main(String[] args) {
        RestaurantManagementSystem restaurantApp = new RestaurantManagementSystem();
        restaurantApp.setVisible(true);
    }
}