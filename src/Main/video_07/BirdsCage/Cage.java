package Main.video_07.BirdsCage;
import java.util.Arrays;
import java.util.Scanner;
public class Cage {
    private Integer id;
    private String name;
    private String[] birds;

    public Cage(String inputBirdName1) {
    }

    public Cage(int id, String cageName, String[] birds) {
        this.id = id;
        this.name = cageName;
        this.birds = birds;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String[] getBirds() {
        return birds;
    }

    public void setBirds(String[] birds) {
        this.birds = birds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




