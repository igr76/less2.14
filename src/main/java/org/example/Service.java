package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Service implements StringList{
    private  Integer capasity = 0;
    private String[] element = new String[10];

    @Override
    public String add(String item) {
       element[capasity] = item;
       capasity ++;
       return item;
    }

    @Override
    public String add(int index, String item) {
      checkIten(item);
      checkIndex(index);
        if (capasity >= element.length) {
            throw  new IllegalArgumentException("Нет места");
        }
        for (int i = element.length - 1; i >= index+1; i--) {
            element[i] = element[i-1];
        }
        return element[index] = item;
    }

    @Override
    public String set(int index, String item) {
       checkIten(item);

        if (index > capasity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element[index] = null;
        return element[index] = item;
    }

    @Override
    public String remove(String item) throws DataException {
        for (int i = 0; i < capasity; i++) {
            if (element[i] == item) {
                for (int i1 = i; i1 < capasity-1; i1++) {
                    element[i] = element[i+1];
                }
                capasity --;
                return item;
            }
        }throw new DataException();
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String element1 = element[index];
        if (index+1 < capasity){
            for (int i = index; i <capasity-1; i++) {
                element[i] = element[i+1];
            }}
        element[capasity] = null;
        capasity --;
            return element1;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
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
        for (int i = capasity -1; i <=0; i--) {
            if (element[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
       checkIndex(index);
        return element[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (Integer i = 0; i < capasity; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capasity;
    }

    @Override
    public boolean isEmpty() {
         return size() ==0;
    }

    @Override
    public void clear() {
        Arrays.fill(element, 0);
        capasity =0;
    }

    @Override
    public String[] toArray() {
        String[] element1;
        return element1 = element.clone();
    }

    private void checkIten(String iten) {
        if (iten == null) {
            throw new IllegalArgumentException("Список не может содеожать пустоту");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > capasity) {
            throw new IllegalArgumentException("Индекс должен быть в пределах массива");
        }
    }
}
