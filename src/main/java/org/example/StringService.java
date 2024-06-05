package org.example;

import java.util.Arrays;

public class StringService implements StringList {
    private String[] stringArrayList;

    public StringService() {
        this.stringArrayList = new String[0];
    }

    @Override
    public String[] getStringArrayList() {
        return stringArrayList;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        String[] copyArray = new String[stringArrayList.length + 1];
        if (stringArrayList.length != 0) {
            for (int i = 0; i < stringArrayList.length; i++) {
                copyArray[i] = stringArrayList[i];
            }
            copyArray[stringArrayList.length] = item;
            stringArrayList = copyArray;
        } else {

            String[] copy = new String[1];
            copy[0] = item;
            stringArrayList = copy;
        }


        return stringArrayList[stringArrayList.length - 1];
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        String[] arrayResult = new String[stringArrayList.length + 1];
        if (index >= stringArrayList.length || index < 0) {
            throw new ExceptionArray("Индекс вне массива");
        }
        for (int i = 0; i < index; i++) {
            arrayResult[i] = stringArrayList[i];
        }
        for (int i = index; i < stringArrayList.length; i++) {
            arrayResult[i + 1] = stringArrayList[i];
        }
        arrayResult[index] = item;
        stringArrayList = arrayResult;

        return item;
    }


    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        if (index >= stringArrayList.length || index < 0) {
            throw new ExceptionArray("Индекс вне массива");
        }
        stringArrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        String[] arrayResult = new String[stringArrayList.length - 1];
        int idx = indexOf(item);
        if (idx == -1) {
            throw new ExceptionArray("Элемент отсутсвует в массиве");
        }

        for (int i = 0; i < idx; i++) {
            arrayResult[i] = stringArrayList[i];
        }
        for (int i = idx + 1; i < stringArrayList.length; i++) {
            arrayResult[i - 1] = stringArrayList[i];
        }
        stringArrayList = arrayResult;

        return item;

    }

    @Override
    public String remove(int index) {
        String[] arrayResult = new String[stringArrayList.length - 1];

        if (index >= stringArrayList.length || index < 0) {
            throw new ExceptionArray("Элемент отсутсвует в массиве");
        }
        String item = stringArrayList[index];

        for (int i = 0; i < index; i++) {
            arrayResult[i] = stringArrayList[i];
        }
        for (int i = index + 1; i < stringArrayList.length; i++) {
            arrayResult[i - 1] = stringArrayList[i];
        }
        stringArrayList = arrayResult;

        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        for (String string : stringArrayList) {
            if (string.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        for (int i = 0; i < stringArrayList.length; i++) {
            if (stringArrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new ExceptionArray("передан элемент со значением null");
        }
        for (int i = stringArrayList.length - 1; i >= 0; i++) {
            if (stringArrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= stringArrayList.length) {
            throw new ExceptionArray("Индекс вне массива");
        }
        return stringArrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new ExceptionArray("передан массив null");
        }

        if (stringArrayList.length != otherList.getStringArrayList().length) {
            return false;
        }
        for (int i = 0; i < stringArrayList.length; i++) {
            if (!stringArrayList[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return stringArrayList.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringArrayList = new String[0];

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArrayList, stringArrayList.length);
    }

    @Override
    public String toString() {

        return Arrays.toString(stringArrayList);
    }

}
