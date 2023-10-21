import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.util.List;


public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String savePath, GameProgress gameProgress) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
            objectOutputStream.close();
            System.out.println("Сохранение выполнено успешно");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String zipPath, List<String> filePaths) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipPath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            for (String filePath : filePaths) {
                File file = new File(filePath);
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fileInputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, length);
                    }

                    fileInputStream.close();
                }
            }

            zipOutputStream.closeEntry();
            zipOutputStream.close();

            System.out.println("Архивирование выполнено успешно");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSaveGameFiles() {
        File directory = new File("/Users/elizavetagilyarevskaya/Desktop/Games/savegames");

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equals("savegames.zip")) {
                    file.delete();
                }
            }
            System.out.println("Удаление файлов сохранений выполнено успешно");
        }
    }



}
