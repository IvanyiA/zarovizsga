package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class WorkHours {


    public String minWork(String path) {
        Worker laziest = new Worker(null, 24, null);
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int workHours = Integer.parseInt(parts[1]);
                LocalDate date = LocalDate.parse(parts[2]);
                Worker actual = new Worker(name, workHours, date);
                if (laziest.getWorkHours() > actual.getWorkHours()) {
                    laziest = actual;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return laziest.toString();
    }
}
