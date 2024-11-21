package com.chein.test;

import com.chein.task3_1.model.Model;
import com.chein.task3_1.objreader.ObjReader;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.chein.task3_1.model.DelVertices.delVertices;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Tests {

    Path kub = Path.of("/Users/chein/Documents/Univer/caracal_cube.obj");
    @Test
    @DisplayName("Cube model")
    public void kubTest() throws IOException {

        String fileContent = Files.readString(kub);
        Model model = ObjReader.read(fileContent);

        ArrayList<Integer> vertIndForDel = new ArrayList<>();
        vertIndForDel.add(0);
        vertIndForDel.add(1);

        delVertices(vertIndForDel, model);

        assertEquals(6, model.vertices.size());
        assertEquals(2, model.polygons.size());


    }
    @Test
    @DisplayName("Is empty test")
    public void isEmptyTest() throws IOException{
        String fileContent = Files.readString(kub);
        Model model = ObjReader.read(fileContent);

        ArrayList<Integer> vertIndForDel = new ArrayList<>();

        delVertices(vertIndForDel, model);
    }
    @Test
    @DisplayName("Elem is bigger than ArrayList size")
    public void ElemIsBiggerTest() throws IOException{
        String fileContent = Files.readString(kub);
        Model model = ObjReader.read(fileContent);

        ArrayList<Integer> vertIndForDel = new ArrayList<>();
        vertIndForDel.add(5004);

        delVertices(vertIndForDel, model);
    }

}
