package de.u5b.pikdroid.system.render;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Foxel on 13.08.2014.
 */
public class RenderSystem implements GLSurfaceView.Renderer {
    private final String vertexShaderCode =
            "uniform mat4 uMVPMatrix;                        \n" +
                    "attribute vec4 vPosition;               \n" +
                    "void main(){                            \n" +
                    "  gl_Position = uMVPMatrix * vPosition; \n" +
                    "}                                       \n";

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(1.0f, 0.0f, 0.25f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
