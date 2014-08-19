package de.u5b.pikdroid.system.render.mesh;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * A Mesh is a 3D Polygon collection on the GPU.
 * It is used to draw Objects on OpenGL.
 * Created by Foxel on 17.08.2014.
 */
public class Mesh {

    private FloatBuffer vbo;    // The VertexBufferObject

    /**
     * Create a new Mesh with the @vertices
     * @param vertices 3D Vertices
     */
    public Mesh(float[] vertices) {
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());

        vbo = bb.asFloatBuffer();
        vbo.put(vertices);
        vbo.position(0);
    }

    /**
     * Draw the Mesh in OpenGL to a Screen or Framebuffer
     * @param shaderProgram
     */
    public void draw(int shaderProgram) {
        // TODO Optimize
        int vPosition = GLES20.glGetAttribLocation(shaderProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(vPosition);
        GLES20.glVertexAttribPointer(vPosition, 3, GLES20.GL_FLOAT, false, 0, vbo);

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
        GLES20.glDisableVertexAttribArray(vPosition);
    }

}
