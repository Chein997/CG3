package com.chein.task3_1.model;
import com.chein.task3_1.math.Vector2f;
import com.chein.task3_1.math.Vector3f;

import java.util.*;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<com.chein.task3_1.model.Polygon> polygons = new ArrayList<com.chein.task3_1.model.Polygon>();
}
