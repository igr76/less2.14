package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Service implements StringList{
    String[] element = new String[10];

    @Override
    public String add(String item) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == null) {
                element[i] = item;
                return item;
            }
        } return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > element.length-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index1 =element.length;
        for (int i = element.length - 1; i >= index+1; i--) {
            element[i] = element[i-1];
        }
        element[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            System.out.println("значение не может быть нулевым");
            return item;
        }
        if (index > element.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element[index] = null;
        element[index] = item;
        return item;
    }

    @Override
    public String remove(String item) throws DataException {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == item) {if (i < element.length){
                for (int i1 = i; i1 < element.length-1; i1++) {
                    element[i] = element[i+1];
                }}
                return item;
            }
        }throw new DataException();
    }

    @Override
    public String remove(int index) {
        String element1 = element[index];
        if (index < element.length){
            for (int i = index; i < element.length-1; i++) {
                element[i] = element[i+1];
            }}
            return element1;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = element.length; i <=0; i--) {
            if (element[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > element.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return element[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return otherList.equals(element);
    }

    @Override
    public int size() {
        return element.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < element.length; i++) {
            if (element[i] != null) { return false;}
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(element, 0);
    }

    @Override
    public String[] toArray() {
        String[] element1;
        return element1 = element.clone();
    }
}
