package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {
    public StringService out = new StringService();
    public StringService out1 = new StringService();
    public StringService outClear=new StringService();
    static String ARG1 = "Мой";
    static int IDX = 0;


    @BeforeEach
    void setUp() {
        out.add("Сколько");
        out.add("волка");
        out.add("не");
        out.add("корми,");
        out.add("все равно...");

        out1.add("Сколько");
        out1.add("волка");
        out1.add("не");
        out1.add("корми,");
        out1.add("все равно...");

    }

    @AfterEach
    void tearDown() {
    }


    public static Stream<Arguments> createValueForArrayList() {
        return Stream.of(
                Arguments.of("Мой"),
                Arguments.of("дядя"),
                Arguments.of("честных"),
                Arguments.of("самых"),
                Arguments.of("правил")//,
                //Arguments.of(2,"самых")
        );
    }

    public static Stream<Arguments> createValueWithIdxForArrayList() {
        return Stream.of(
                Arguments.of(0, "Их"),
                Arguments.of(1, "тетя"),
                Arguments.of(2, "просто"),
                Arguments.of(2, "лучше"),
                Arguments.of(4, "всех")//,
                //Arguments.of(2,"самых")
        );
    }


    public static Stream<Arguments> createValueWithIdxForRemoveArrayList() {
        return Stream.of(
                Arguments.of(0,"Сколько"),
                Arguments.of(2,"не"),
                Arguments.of(4,"все равно...")
        );
    }

    public static Stream<Arguments> createValueForRemoveArrayList() {
        return Stream.of(
                Arguments.of("Сколько"),
                Arguments.of("волка"),
                Arguments.of("не"),
                Arguments.of("корми,"),
                Arguments.of("все равно...")
        );
    }

    public static Stream<Arguments> createValueForContein() {
        return Stream.of(
                Arguments.of("Много",false),
                Arguments.of("волка",true),
                Arguments.of("нельзя",false),
                Arguments.of("кормить,",false),
                Arguments.of("все равно...",true)
        );
    }

    public static Stream<Arguments> createValueForIndexOf() {
        return Stream.of(
                Arguments.of("Много",-1),
                Arguments.of("волка",1),
                Arguments.of("нельзя",-1),
                Arguments.of("кормить,",-1),
                Arguments.of("все равно...",4)
        );
    }

    @Test
    void getStringArrayList() {

    }


    @MethodSource("createValueForArrayList")
    @ParameterizedTest
    void add(String arg) {
        Assertions.assertEquals(arg, out.add(arg));
    }

    @Test
    void addNull() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(null));

    }


    @Test
    void testAdd() {
        out.add("1");
        out.add("2");
        Assertions.assertEquals(ARG1, out.add(IDX, ARG1));
    }

    @Test
    void addIdxIsOut() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(25, "Hello!"));
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(-8, "Hello!"));
    }

    @Test
    void addIdxWithArgumentNull() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(25, null));

    }


    @MethodSource("createValueWithIdxForArrayList")
    @ParameterizedTest
    void set(int IDX, String ARG1) {
        Assertions.assertEquals(ARG1, out.set(IDX, ARG1));
    }

    @Test
    void setNull() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(1, null));
    }

    @Test
    void setOutIdx() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(200, "Жуть"));
        Assertions.assertThrows(ExceptionArray.class, () -> out.add(-5, "Жуть"));

    }

    @MethodSource("createValueForRemoveArrayList")
    @ParameterizedTest
    void remove(String arg) {
        Assertions.assertEquals(arg, out.remove(arg));
    }

    @Test
    void removeMissing() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove("корми"));
    }


    @MethodSource("createValueWithIdxForRemoveArrayList")
    @ParameterizedTest
    void testRemove(int idx,String arg) {
        Assertions.assertEquals(arg, out.remove(idx));
    }
@Test
    void testRemoveNull() {
    Assertions.assertThrows(ExceptionArray.class, () -> out.remove(null));
    }

    @Test
    void removeIdxOut() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(80));
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(-10));
    }
    @MethodSource("createValueForContein")
    @ParameterizedTest
    void contains(String arg, Boolean result) {
        Assertions.assertEquals(result, out.contains(arg));
    }

    @MethodSource("createValueForIndexOf")
    @ParameterizedTest
    void indexOf(String arg, int result) {
        Assertions.assertEquals(result, out.indexOf(arg));
    }

    @MethodSource("createValueForIndexOf")
    @ParameterizedTest
    void lastIndexOf(String arg, int result) {
        Assertions.assertEquals(result, out.indexOf(arg));
    }

    @MethodSource("createValueWithIdxForRemoveArrayList")
    @ParameterizedTest
    void get( int idx, String arg) {
        Assertions.assertEquals(arg, out.get(idx));
    }
    @Test
    void getIdxOut() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(80));
        Assertions.assertThrows(ExceptionArray.class, () -> out.remove(-10));
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(true, out.equals(out1));
        out1.remove(1);
        Assertions.assertEquals(false, out.equals(out1));

    }

    @Test
    void testEqualsNull() {
        Assertions.assertThrows(ExceptionArray.class, () -> out.equals(null));

    }

    @Test
    void size() {
        Assertions.assertEquals(5, out.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertEquals(false,out1.isEmpty());
        Assertions.assertEquals(true,outClear.isEmpty());
    }


    @Test
    void toArray() {
        String [] inArray={"Сколько","волка","не","корми,","все равно..."};
        Assertions.assertArrayEquals(inArray,out.toArray());

    }
}
//\ No newline at end of file