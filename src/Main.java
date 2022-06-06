import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final StringBuilder log = new StringBuilder();

    public static void main(String[] args) {


//        Создание объектов директорий в C:/Games:
        File src = new File("C:/Games/src");
        File res = new File("C:/Games/res");
        File saveGames = new File("C:/Games/saveGames");
        File temp = new File("C:/Games/temp");

//        Создание объектов директорий в C:/Games/src:
        File main = new File("C:/Games/src/main");
        File test = new File("C:/Games/src/test");

//        Создание объектов директорий в C:/Games/res:
        File drawables = new File("C:/Games/res/drawables");
        File vectors = new File("C:/Games/res/vectors");
        File icons = new File("C:/Games/res/icons");

//        Создание объектов файлов в C:/Games/main:
        File mainJava = new File("C:/Games/src/main", "Main.java");
        File utilsJava = new File("C:/Games/src/main", "Utils.java");

//        Создание объектов файлов в C:/Games/temp:
        File tempTxt = new File("C:/Games/temp", "temp.txt");

        log.append("Лог создания директорий и файлов: ").append(System.lineSeparator());

        createDirectory(src);
        createDirectory(res);
        createDirectory(saveGames);
        createDirectory(temp);

        createDirectory(main);
        createDirectory(test);

        createDirectory(drawables);
        createDirectory(vectors);
        createDirectory(icons);

        createFile(mainJava);
        createFile(utilsJava);

        createFile(tempTxt);

//        System.out.println(log);
        try {
           FileWriter writer = new FileWriter("C:/Games/temp/temp.txt", false);
           writer.write(log.toString());
           writer.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void createDirectory(File name) {
        if (name.mkdir()) {
            log.append(System.lineSeparator()).append("Директория ").append(name.getName()).append(" успешно создана.");
        } else {
            log.append(System.lineSeparator()).append("Произошла ошибка при попытке создания директории ").append(name.getName());
        }
    }

    public static void createFile(File name) {

        try {
            if (name.createNewFile()) {
                log.append(System.lineSeparator()).append("Файл ").append(name.getName()).append(" успешно создан.");
            } else {
                log.append(System.lineSeparator()).append("Произошла ошибка при попытке создания файла ").append(name.getName());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
