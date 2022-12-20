import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("E://Games"),
                new File("E://Games//temp"),
                new File("E://Games//src"),
                new File("E://Games//res"),
                new File("E://Games//savegames"),
                new File("E://Games//src//main"),
                new File("E://Games//src//test"),
                new File("E://Games//res//drawables"),
                new File("E://Games//res//vectors"),
                new File("E://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("E://Games//src//main//Main.java"),
                new File("E://Games//src//main//Utils.java"),
                new File("E://Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("E://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("E://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
