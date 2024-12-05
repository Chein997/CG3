package com.chein.test;

import com.chein.task3_1.math.Vector3f;
import com.chein.task3_1.model.Model;
import com.chein.task3_1.model.Polygon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static com.chein.task3_1.model.DelVertices.delVertices;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tests {

    private static final Model model = new Model();

    @BeforeAll
    public static void init() {
        model.vertices.add(new Vector3f(0, 0, 0));//left lower back
        model.vertices.add(new Vector3f(1, 0, 0));//right lower back
        model.vertices.add(new Vector3f(0, 1, 0));//left upper back
        model.vertices.add(new Vector3f(1, 1, 0));//right upper front
        model.vertices.add(new Vector3f(0, 0, 1));//left lower front
        model.vertices.add(new Vector3f(1, 0, 1));//right lower front
        model.vertices.add(new Vector3f(0, 1, 1));//left upper front
        model.vertices.add(new Vector3f(1, 1, 1));//right upper front

        ArrayList<Integer> vertexInd1 = new ArrayList<>(List.of(0, 1, 3, 2));
        Polygon polygon1 = new Polygon();
        polygon1.setVertexIndices(vertexInd1);
        model.polygons.add(polygon1);

        ArrayList<Integer> vertexInd2 = new ArrayList<>(List.of(4, 5, 7, 6));
        Polygon polygon2 = new Polygon();
        polygon2.setVertexIndices(vertexInd2);
        model.polygons.add(polygon2);

        ArrayList<Integer> vertexInd3 = new ArrayList<>(List.of(0, 1, 5, 4));
        Polygon polygon3 = new Polygon();
        polygon3.setVertexIndices(vertexInd3);
        model.polygons.add(polygon3);

        ArrayList<Integer> vertexInd4 = new ArrayList<>(List.of(2, 3, 7, 6));
        Polygon polygon4 = new Polygon();
        polygon4.setVertexIndices(vertexInd4);
        model.polygons.add(polygon4);

        ArrayList<Integer> vertexInd5 = new ArrayList<>(List.of(0, 2, 6, 4));
        Polygon polygon5 = new Polygon();
        polygon5.setVertexIndices(vertexInd5);
        model.polygons.add(polygon5);

        ArrayList<Integer> vertexInd6 = new ArrayList<>(List.of(1, 3, 7, 5));
        Polygon polygon6 = new Polygon();
        polygon6.setVertexIndices(vertexInd6);
        model.polygons.add(polygon6);
    }

    @Test
    @DisplayName("Cube model")
    public void kubTest() throws IOException {

        ArrayList<Integer> vertIndForDel = new ArrayList<>();
        vertIndForDel.add(0);
        vertIndForDel.add(6);

        delVertices(vertIndForDel, model.vertices, model.polygons);

        assertEquals(6, model.vertices.size());
        assertEquals(0, model.polygons.size());

    }

    @Test
    @DisplayName("Is empty test")
    public void isEmptyTest() throws IOException {

        ArrayList<Integer> vertIndForDel = new ArrayList<>();

        delVertices(vertIndForDel, model.vertices, model.polygons);
    }

    @Test
    @DisplayName("Elem is bigger than ArrayList size")
    public void ElemIsBiggerTest() throws IOException {

        ArrayList<Integer> vertIndForDel = new ArrayList<>();
        vertIndForDel.add(5004);

        delVertices(vertIndForDel, model.vertices, model.polygons);
    }

}
