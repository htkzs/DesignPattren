package com.itheima.objectclone;

import java.io.*;

public class Text implements Serializable {

    private static final long serialVersionUID = 8723901148964L;

    private int age;

    private Name name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Object myClone(){
        Text text=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);
            text=(Text)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}

class Name implements Serializable {

    private static final long serialVersionUID = 872390113109L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

