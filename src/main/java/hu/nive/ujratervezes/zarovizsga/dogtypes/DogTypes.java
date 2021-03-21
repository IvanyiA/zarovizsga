package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT name FROM dog_types WHERE country = ? ORDER BY name")) {
            statement.setString(1, country.toUpperCase());

            return getDogsResult(statement);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read file or error by insert", sqle);
        }
    }

    private List<String> getDogsResult(PreparedStatement statement) throws SQLException {
        List<String> dogsByCountryLowerCasedOrdered = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                dogsByCountryLowerCasedOrdered.add(name.toLowerCase());
            }
        }
        return dogsByCountryLowerCasedOrdered;
    }

}
