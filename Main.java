import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        GameProgress game1 = new GameProgress(100, 3, 5, 125.4);
        GameProgress game2 = new GameProgress(80, 2, 3, 78.9);
        GameProgress game3 = new GameProgress(120, 4, 7, 185.7);

        String savePath1 = "/Users/admin/Games/GunRunner/savegames/game1.dat";
        String savePath2 = "/Users/admin/Games/GunRunner/savegames/game2.dat";
        String savePath3 = "/Users/admin/Games/GunRunner/savegames/game3.dat";

        game1.saveGame(savePath1, new GameProgress(100, 3, 5, 125.4));
        game2.saveGame(savePath2, new GameProgress(80, 2, 3, 78.9));
        game3.saveGame(savePath3, new GameProgress(120, 4, 7, 185.7));

        List<String> saveFiles = new ArrayList<>();
        saveFiles.add(savePath1);
        saveFiles.add(savePath2);
        saveFiles.add(savePath3);

        List<String> savePaths = new ArrayList<>();
        savePaths.add("/Users/admin/Games/GunRunner/savegames/game1.dat");
        savePaths.add("/Users/admin/Games/GunRunner/savegames/game2.dat");
        savePaths.add("/Users/admin/Games/GunRunner/savegames/game3.dat");

        GameProgress.zipFiles("/Users/admin/Games/GunRunner/savegames/zip.zip", savePaths);

        game1.deleteSaveGameFiles();
        game2.deleteSaveGameFiles();
        game3.deleteSaveGameFiles();
    }
}
