package recursion;

import java.io.File;

public class FilesInDirectory {
    public static void main(String[] args) {
        String pathName = "D:/projects/kev-code-dojo";
        listFilesInDirectory(pathName);
    }

    private static void listFilesInDirectory(String path) {
        File file = new File(path);

        String[] fileNames = file.list();
        if (fileNames == null) return;

        for (String fName : fileNames) {
            if(new File(path +"/"+fName).isDirectory()){
				listFilesInDirectory(path +"/"+fName);
			} else {
				System.out.println(path +"/"+fName);
			}
        }
    }
}
