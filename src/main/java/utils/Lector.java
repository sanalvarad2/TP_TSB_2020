package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lector<T> {

    private String _path = "";
    private Scanner sc;
    private List<T> list;

    public Lector() {

        this.Lector(this._path);
    }

    public Lector(String path) {
        this._path = path;
        this.Lector(path);

    }

    private void Lector(String path){
        try {
            File text = new File(path);
            sc = new Scanner(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<T> ReadFile(){
        if(list == null) {

            list = new ArrayList<T>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                list.add((T)line);
            }
        }
        return list;
    }

}
