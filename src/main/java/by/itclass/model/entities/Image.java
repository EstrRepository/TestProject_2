package by.itclass.model.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private byte[] content;

    public Image() {
    }

    public Image(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public Image(int id, String name, byte[] content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
