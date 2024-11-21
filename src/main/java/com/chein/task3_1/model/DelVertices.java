package com.chein.task3_1.model;

import com.chein.exception.ArrayListException;

import java.util.ArrayList;

public class DelVertices extends Exception{


    public static void delVertices(ArrayList<Integer> vertexIndicesToDelete, Model model) {
        checkListToDel(vertexIndicesToDelete);
        for (int i : vertexIndicesToDelete) {//идем по листу с индексами вершин которые надо удалить
            model.vertices.remove(i);

            for (int j = model.polygons.size() - 1; j >= 0; j--) {
                Polygon polygon = model.polygons.get(j);
                ArrayList<Integer> ind = polygon.getVertexIndices();
                if (ind.contains(i)) {// если лист вершин полигона содержит вершину которая удаляется, то и удаляется полигон
                    model.polygons.remove(j);
                } else {
                    for (int m = 0; m < ind.size(); m++) { // сдвигаем индексы вершин после удаления
                        int currInd = ind.get(m);
                        if (currInd > i) {
                            ind.set(m, currInd - 1);
                        }
                    }
                }
            }
        }
    }

    public static void checkListToDel(ArrayList<Integer> vertexIndicesToDelete){
        if (vertexIndicesToDelete.isEmpty()){
            throw new ArrayListException("ArrayList is empty(");
        }
        for (int i : vertexIndicesToDelete){
            if (i > vertexIndicesToDelete.size()){
                throw new ArrayListException("Element of ArrayList > size of it");
            }
        }
    }
}
