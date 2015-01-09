package to.us.harha.jpath.tracer;

import java.util.ArrayList;

import to.us.harha.jpath.tracer.object.Material;
import to.us.harha.jpath.tracer.object.Mesh;
import to.us.harha.jpath.tracer.object.TracerObject;
import to.us.harha.jpath.util.math.Plane;
import to.us.harha.jpath.util.math.Primitive;
import to.us.harha.jpath.util.math.Sphere;
import to.us.harha.jpath.util.math.Transform;
import to.us.harha.jpath.util.math.Vec3f;

public class Scene
{

	private ArrayList<TracerObject> m_objects;
	private ArrayList<Camera>       m_cameras;

	public Scene()
	{
		m_objects = new ArrayList<TracerObject>();
		m_cameras = new ArrayList<Camera>();

		m_cameras.add(new Camera(new Vec3f(0.0f, 2.5f, 15.0f), new Vec3f(0.0f, 0.0f, -1.0f), new Vec3f(0.0f, 1.0f, 0.0f), new Vec3f(1.0f, 0.0f, 0.0f), 2.0f, 1.0f));
		m_cameras.add(new Camera(new Vec3f(2.0f, 1.0f, -4.0f), new Vec3f(0.0f, 0.0f, 1.0f), new Vec3f(0.0f, 1.0f, 0.0f), new Vec3f(1.0f, 0.0f, 0.0f), 4.0f, 1.0f));

		Mesh mesh_lamp = new Mesh("lamp.obj");
		Mesh mesh_cube = new Mesh("cube.obj");
		Mesh mesh_tetrahedron = new Mesh("tetrahedron.obj");
		Mesh mesh_torusknot = new Mesh("torusknot.obj");
		Mesh mesh_toroid = new Mesh("toroid.obj");

		Material mat_white_diffuse = new Material(new Vec3f(0.0f), new Vec3f(1.0f), 0.0f, 0.0f, 0.0f, 0.0f);
		Material mat_red_diffuse = new Material(new Vec3f(0.0f), new Vec3f(1.0f, 0.0f, 0.0f));
		Material mat_green_diffuse = new Material(new Vec3f(0.0f), new Vec3f(0.0f, 1.0f, 0.0f));
		Material mat_blue_diffuse = new Material(new Vec3f(0.0f), new Vec3f(0.0f, 0.0f, 1.0f));
		Material mat_yellow_diffuse = new Material(new Vec3f(0.0f), new Vec3f(1.0f, 1.0f, 0.0f));
		Material mat_purple_diffuse = new Material(new Vec3f(0.0f), new Vec3f(0.0f, 0.0f, 1.0f));
		Material mat_black_mirror = new Material(new Vec3f(0.0f), new Vec3f(), 1.0f, 0.0f, 0.0f, 0.0f);
		Material mat_black_glass = new Material(new Vec3f(0.0f), new Vec3f(), 0.25f, 1.0f, 1.52f, 0.0f);
		Material mat_white_light = new Material(Vec3f.scale(new Vec3f(0.9568f, 1.0f, 0.9803f), 1.0f), new Vec3f());

		TracerObject obj_white_diffuse = new TracerObject(mat_white_diffuse);
		TracerObject obj_red_diffuse = new TracerObject(mat_red_diffuse);
		TracerObject obj_green_diffuse = new TracerObject(mat_green_diffuse);
		TracerObject obj_yellow_diffuse = new TracerObject(mat_yellow_diffuse);
		TracerObject obj_purple_diffuse = new TracerObject(mat_purple_diffuse);
		TracerObject obj_blue_diffuse = new TracerObject(mat_green_diffuse);
		TracerObject obj_black_mirror = new TracerObject(mat_black_mirror);
		TracerObject obj_cube = new TracerObject(mesh_cube.getPrimitives(), mat_white_diffuse, new Transform(new Vec3f(-2.0f, 1.0f, 3.0f), new Vec3f(0.0f), new Vec3f(1.0f)));
		TracerObject obj_tetrahedron = new TracerObject(mesh_tetrahedron.getPrimitives(), mat_black_mirror, new Transform(new Vec3f(0.0f, 0.0f, 0.0f), new Vec3f(0.0f), new Vec3f(1.0f)));
		TracerObject obj_torusknot = new TracerObject(mesh_torusknot.getPrimitives(), mat_black_glass, new Transform(new Vec3f(-2.5f, 2.0f, 5.0f), new Vec3f(0.0f), new Vec3f(1.0f)));
		TracerObject obj_toroid = new TracerObject(mesh_toroid.getPrimitives(), mat_black_mirror, new Transform(new Vec3f(-1.0f, 1.0f, 8.0f), new Vec3f(0.0f), new Vec3f(1.0f)));
		TracerObject obj_black_glass = new TracerObject(mat_black_glass);
		TracerObject obj_white_light = new TracerObject(mesh_lamp.getPrimitives(), mat_white_light, new Transform(new Vec3f(0.0f, 5.0f, 2.5f), new Vec3f(0.0f), new Vec3f(1.0f)));

		Primitive sphere_0 = new Sphere(new Vec3f(2.0f, 1.0f, 5.0f), 1.0f);
		Primitive sphere_1 = new Sphere(new Vec3f(1.0f, 2.0f, -1.0f), 2.0f);
		Primitive sphere_2 = new Sphere(new Vec3f(-2.0f, 4.0f, 3.0f), 1.5f);

		Primitive floor_0 = new Plane(new Vec3f(0.0f, 0.0f, 0.0f), new Vec3f(0.0f, 1.0f, 0.0f));
		Primitive ceiling_0 = new Plane(new Vec3f(0.0f, 5.0f, 0.0f), new Vec3f(0.0f, -1.0f, 0.0f));
		Primitive wall_0 = new Plane(new Vec3f(0.0f, 0.0f, -4.0f), new Vec3f(0.0f, 0.0f, 1.0f));
		Primitive wall_1 = new Plane(new Vec3f(0.0f, 0.0f, 16.0f), new Vec3f(0.0f, 0.0f, -1.0f));
		Primitive wall_2 = new Plane(new Vec3f(-4.0f, 0.0f, 0.0f), new Vec3f(1.0f, 0.0f, 0.0f));
		Primitive wall_3 = new Plane(new Vec3f(4.0f, 0.0f, 0.0f), new Vec3f(-1.0f, 0.0f, 0.0f));

		obj_white_diffuse.addPrimitive(floor_0);
		obj_white_diffuse.addPrimitive(ceiling_0);
		obj_white_diffuse.addPrimitive(wall_1);
		obj_white_diffuse.addPrimitive(wall_0);
		obj_red_diffuse.addPrimitive(wall_2);
		obj_black_mirror.addPrimitive(sphere_1);
		obj_black_glass.addPrimitive(sphere_0);
		obj_blue_diffuse.addPrimitive(wall_3);
		m_objects.add(obj_white_diffuse);
		m_objects.add(obj_red_diffuse);
		m_objects.add(obj_blue_diffuse);
		m_objects.add(obj_black_mirror);
		m_objects.add(obj_black_glass);
		m_objects.add(obj_white_light);
		m_objects.add(obj_cube);
		// m_objects.add(obj_toroid);
	}

	public ArrayList<TracerObject> getObjects()
	{
		return m_objects;
	}

	public ArrayList<Camera> getCameras()
	{
		return m_cameras;
	}

	public void setObjects(ArrayList<TracerObject> m_objects)
	{
		this.m_objects = m_objects;
	}

	public void setCameras(ArrayList<Camera> m_cameras)
	{
		this.m_cameras = m_cameras;
	}

}
