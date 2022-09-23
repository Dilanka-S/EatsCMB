package lk.sliiti.eatscmb.uvindu.adapter.model;

public class Restaurants {

    String name;
    String time;
    Integer imageLink;

    public Restaurants(String name, String time, Integer imageLink) {
        this.name = name;
        this.time = time;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getImageLink() {
        return imageLink;
    }

    public void setImageLink(Integer imageLink) {
        this.imageLink = imageLink;
    }
}
