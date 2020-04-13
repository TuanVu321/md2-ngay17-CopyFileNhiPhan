import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyBinary {
    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void main(String[] args) {
        CopyBinary copyBinary = new CopyBinary();
        checkAndCopy(copyBinary);

    }

    private static void checkAndCopy(CopyBinary copyBinary) {
        File sourceFile = new File("test.txt");
        File destFile = new File("copy2.txt");
        if(!sourceFile.exists()){
            System.out.println("khong co file nay");
            System.exit(0);
        }else{
            if(destFile.exists()){
                System.out.println("file da ton tai");
                System.exit(0);
            }else{
                try {
                    destFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    copyBinary.copyFile(sourceFile,destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
