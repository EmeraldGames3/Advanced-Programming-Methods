package Lander;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadWrite {
    public volatile static FileReadWrite fileReadWrite = null;

    private FileReadWrite() {}

    public List<Land> readFromFile(String fileName) throws IOException {
        return Files.lines(Path.of(fileName))
                .map(Land::parseCountry)
                .collect(Collectors.toList());
    }

    public void writeToFile(List<Land> countries, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        countries.forEach(c -> {
                    try {
                        bw.write(c.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        bw.close();
    }

    public static FileReadWrite getInstance(){
        if(fileReadWrite == null){
            synchronized (FileReadWrite.class) {
                if (fileReadWrite == null) {
                    fileReadWrite = new FileReadWrite();
                }
            }
        }
        return fileReadWrite;
    }
}
