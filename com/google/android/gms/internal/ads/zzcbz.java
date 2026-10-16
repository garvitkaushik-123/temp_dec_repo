package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.work.Data;
import io.bidmachine.media3.common.C;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcbz extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcbx {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcby zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcbz(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        zzcby zzcbyVar = new zzcby(context);
        this.zzb = zzcbyVar;
        zzcbyVar.zzb(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", str + ": glError " + glGetError);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = fArr2[0] * fArr3[0];
        float f2 = fArr2[1];
        float f3 = fArr3[3];
        float f4 = fArr2[2];
        float f5 = fArr3[6];
        fArr[0] = f + (f2 * f3) + (f4 * f5);
        float f6 = fArr2[0];
        float f7 = fArr3[1] * f6;
        float f8 = fArr3[4];
        float f9 = fArr3[7];
        fArr[1] = f7 + (f2 * f8) + (f4 * f9);
        float f10 = f6 * fArr3[2];
        float f11 = fArr2[1];
        float f12 = fArr3[5];
        float f13 = fArr3[8];
        fArr[2] = f10 + (f11 * f12) + (f4 * f13);
        float f14 = fArr2[3];
        float f15 = fArr3[0];
        float f16 = fArr2[4];
        float f17 = fArr2[5];
        fArr[3] = (f14 * f15) + (f3 * f16) + (f17 * f5);
        float f18 = fArr2[3];
        float f19 = fArr3[1];
        fArr[4] = (f18 * f19) + (f16 * f8) + (f17 * f9);
        float f20 = fArr3[2];
        fArr[5] = (f18 * f20) + (fArr2[4] * f12) + (f17 * f13);
        float f21 = fArr2[6] * f15;
        float f22 = fArr2[7];
        float f23 = fArr3[3] * f22;
        float f24 = fArr2[8];
        fArr[6] = f21 + f23 + (f5 * f24);
        float f25 = fArr2[6];
        fArr[7] = (f19 * f25) + (f22 * fArr3[4]) + (f9 * f24);
        fArr[8] = (f25 * f20) + (fArr2[7] * fArr3[5]) + (f24 * f13);
    }

    private static final void zzj(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static final void zzk(float[] fArr, float f) {
        double d = f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a3  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object[] objArr;
        int zzl;
        int glCreateProgram;
        if (this.zzp == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("SphericalVideoProcessor started with no output texture.");
            this.zzu.countDown();
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.zzw = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.zzx = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY && this.zzw.eglInitialize(this.zzx, new int[2])) {
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGLConfig eGLConfig = (this.zzw.eglChooseConfig(this.zzx, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) && iArr[0] > 0) ? eGLConfigArr[0] : null;
            if (eGLConfig != null) {
                EGLContext eglCreateContext = this.zzw.eglCreateContext(this.zzx, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                this.zzy = eglCreateContext;
                if (eglCreateContext != null && eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                    EGLSurface eglCreateWindowSurface = this.zzw.eglCreateWindowSurface(this.zzx, eGLConfig, this.zzp, null);
                    this.zzz = eglCreateWindowSurface;
                    if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                        EGL10 egl102 = this.zzw;
                        EGLDisplay eGLDisplay = this.zzx;
                        EGLSurface eGLSurface = this.zzz;
                        if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.zzy)) {
                            objArr = true;
                            zzbcv zzbcvVar = zzbde.zzbw;
                            zzl = zzl(35633, ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).equals(zzbcvVar.zzl()) ? (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
                            if (zzl != 0) {
                                zzbcv zzbcvVar2 = zzbde.zzbx;
                                int zzl2 = zzl(35632, !((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar2)).equals(zzbcvVar2.zzl()) ? (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
                                if (zzl2 != 0) {
                                    glCreateProgram = GLES20.glCreateProgram();
                                    zzh("createProgram");
                                    if (glCreateProgram != 0) {
                                        GLES20.glAttachShader(glCreateProgram, zzl);
                                        zzh("attachShader");
                                        GLES20.glAttachShader(glCreateProgram, zzl2);
                                        zzh("attachShader");
                                        GLES20.glLinkProgram(glCreateProgram);
                                        zzh("linkProgram");
                                        int[] iArr2 = new int[1];
                                        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                                        zzh("getProgramiv");
                                        if (iArr2[0] != 1) {
                                            Log.e("SphericalVideoRenderer", "Could not link program: ");
                                            Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                                            GLES20.glDeleteProgram(glCreateProgram);
                                            zzh("deleteProgram");
                                        } else {
                                            GLES20.glValidateProgram(glCreateProgram);
                                            zzh("validateProgram");
                                        }
                                    }
                                    this.zzq = glCreateProgram;
                                    GLES20.glUseProgram(glCreateProgram);
                                    zzh("useProgram");
                                    int glGetAttribLocation = GLES20.glGetAttribLocation(this.zzq, "aPosition");
                                    GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.zzt);
                                    zzh("vertexAttribPointer");
                                    GLES20.glEnableVertexAttribArray(glGetAttribLocation);
                                    zzh("enableVertexAttribArray");
                                    int[] iArr3 = new int[1];
                                    GLES20.glGenTextures(1, iArr3, 0);
                                    zzh("genTextures");
                                    int i2 = iArr3[0];
                                    GLES20.glBindTexture(36197, i2);
                                    zzh("bindTextures");
                                    GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, C.TEXTURE_MIN_FILTER_LINEAR);
                                    zzh("texParameteri");
                                    GLES20.glTexParameteri(36197, 10241, C.TEXTURE_MIN_FILTER_LINEAR);
                                    zzh("texParameteri");
                                    GLES20.glTexParameteri(36197, 10242, 33071);
                                    zzh("texParameteri");
                                    GLES20.glTexParameteri(36197, 10243, 33071);
                                    zzh("texParameteri");
                                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.zzq, "uVMat");
                                    this.zzr = glGetUniformLocation;
                                    GLES20.glUniformMatrix3fv(glGetUniformLocation, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
                                    int i3 = this.zzq;
                                    if (objArr == true || i3 == 0) {
                                        String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.zzw.eglGetError()));
                                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                                        String concat = "EGL initialization failed: ".concat(valueOf);
                                        com.google.android.gms.ads.internal.util.client.zzo.zzg(concat);
                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(new Throwable(concat), "SphericalVideoProcessor.run.1");
                                        zzg();
                                        this.zzu.countDown();
                                    }
                                    SurfaceTexture surfaceTexture = new SurfaceTexture(i2);
                                    this.zzo = surfaceTexture;
                                    surfaceTexture.setOnFrameAvailableListener(this);
                                    this.zzu.countDown();
                                    zzcby zzcbyVar = this.zzb;
                                    zzcbyVar.zzc();
                                    try {
                                        try {
                                            this.zzA = true;
                                            while (!this.zzB) {
                                                while (this.zzs > 0) {
                                                    this.zzo.updateTexImage();
                                                    this.zzs--;
                                                }
                                                float[] fArr = this.zzc;
                                                if (zzcbyVar.zze(fArr)) {
                                                    if (Float.isNaN(this.zzj)) {
                                                        float[] fArr2 = {0.0f, 1.0f, 0.0f};
                                                        float f = fArr[0];
                                                        float f2 = fArr2[0];
                                                        float f3 = fArr[1];
                                                        float f4 = fArr2[1];
                                                        float[] fArr3 = {(f * f2) + (f3 * f4) + (fArr[2] * 0.0f), (fArr[3] * f2) + (fArr[4] * f4) + (fArr[5] * 0.0f), (fArr[6] * f2) + (fArr[7] * f4) + (fArr[8] * 0.0f)};
                                                        this.zzj = -(((float) Math.atan2(fArr3[1], fArr3[0])) - 1.5707964f);
                                                    }
                                                    zzk(this.zzh, this.zzj + this.zzk);
                                                } else {
                                                    zzj(fArr, -1.5707964f);
                                                    zzk(this.zzh, this.zzk);
                                                }
                                                float[] fArr4 = this.zzd;
                                                zzj(fArr4, 1.5707964f);
                                                float[] fArr5 = this.zze;
                                                zzi(fArr5, this.zzh, fArr4);
                                                float[] fArr6 = this.zzf;
                                                zzi(fArr6, fArr, fArr5);
                                                float[] fArr7 = this.zzg;
                                                zzj(fArr7, this.zzl);
                                                float[] fArr8 = this.zzi;
                                                zzi(fArr8, fArr7, fArr6);
                                                GLES20.glUniformMatrix3fv(this.zzr, 1, false, fArr8, 0);
                                                GLES20.glDrawArrays(5, 0, 4);
                                                zzh("drawArrays");
                                                GLES20.glFinish();
                                                this.zzw.eglSwapBuffers(this.zzx, this.zzz);
                                                if (this.zzA) {
                                                    GLES20.glViewport(0, 0, this.zzn, this.zzm);
                                                    zzh("viewport");
                                                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzq, "uFOVx");
                                                    int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.zzq, "uFOVy");
                                                    int i5 = this.zzn;
                                                    int i6 = this.zzm;
                                                    if (i5 > i6) {
                                                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                                                        GLES20.glUniform1f(glGetUniformLocation3, (this.zzm * 0.87266463f) / this.zzn);
                                                    } else {
                                                        GLES20.glUniform1f(glGetUniformLocation2, (i5 * 0.87266463f) / i6);
                                                        GLES20.glUniform1f(glGetUniformLocation3, 0.87266463f);
                                                    }
                                                    this.zzA = false;
                                                }
                                                try {
                                                    Object obj = this.zzv;
                                                    synchronized (obj) {
                                                        if (!this.zzB && !this.zzA && this.zzs == 0) {
                                                            obj.wait();
                                                        }
                                                    }
                                                } catch (InterruptedException unused) {
                                                }
                                            }
                                        } finally {
                                            this.zzb.zzd();
                                            this.zzo.setOnFrameAvailableListener(null);
                                            this.zzo = null;
                                            zzg();
                                        }
                                    } catch (IllegalStateException unused2) {
                                        int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                                        com.google.android.gms.ads.internal.util.client.zzo.zzj("SphericalVideoProcessor halted unexpectedly.");
                                        return;
                                    } catch (Throwable th) {
                                        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                                        com.google.android.gms.ads.internal.util.client.zzo.zzh("SphericalVideoProcessor died.", th);
                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "SphericalVideoProcessor.run.2");
                                        return;
                                    }
                                    return;
                                }
                            }
                            glCreateProgram = 0;
                            this.zzq = glCreateProgram;
                            GLES20.glUseProgram(glCreateProgram);
                            zzh("useProgram");
                            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.zzq, "aPosition");
                            GLES20.glVertexAttribPointer(glGetAttribLocation2, 3, 5126, false, 12, (Buffer) this.zzt);
                            zzh("vertexAttribPointer");
                            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
                            zzh("enableVertexAttribArray");
                            int[] iArr32 = new int[1];
                            GLES20.glGenTextures(1, iArr32, 0);
                            zzh("genTextures");
                            int i22 = iArr32[0];
                            GLES20.glBindTexture(36197, i22);
                            zzh("bindTextures");
                            GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, C.TEXTURE_MIN_FILTER_LINEAR);
                            zzh("texParameteri");
                            GLES20.glTexParameteri(36197, 10241, C.TEXTURE_MIN_FILTER_LINEAR);
                            zzh("texParameteri");
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            zzh("texParameteri");
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            zzh("texParameteri");
                            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.zzq, "uVMat");
                            this.zzr = glGetUniformLocation4;
                            GLES20.glUniformMatrix3fv(glGetUniformLocation4, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
                            int i32 = this.zzq;
                            if (objArr == true) {
                            }
                            String valueOf2 = String.valueOf(GLUtils.getEGLErrorString(this.zzw.eglGetError()));
                            int i42 = com.google.android.gms.ads.internal.util.zze.zza;
                            String concat2 = "EGL initialization failed: ".concat(valueOf2);
                            com.google.android.gms.ads.internal.util.client.zzo.zzg(concat2);
                            com.google.android.gms.ads.internal.zzv.zzp().zzw(new Throwable(concat2), "SphericalVideoProcessor.run.1");
                            zzg();
                            this.zzu.countDown();
                        }
                    }
                }
            }
        }
        objArr = false;
        zzbcv zzbcvVar3 = zzbde.zzbw;
        zzl = zzl(35633, ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar3)).equals(zzbcvVar3.zzl()) ? (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar3) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (zzl != 0) {
        }
        glCreateProgram = 0;
        this.zzq = glCreateProgram;
        GLES20.glUseProgram(glCreateProgram);
        zzh("useProgram");
        int glGetAttribLocation22 = GLES20.glGetAttribLocation(this.zzq, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation22, 3, 5126, false, 12, (Buffer) this.zzt);
        zzh("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation22);
        zzh("enableVertexAttribArray");
        int[] iArr322 = new int[1];
        GLES20.glGenTextures(1, iArr322, 0);
        zzh("genTextures");
        int i222 = iArr322[0];
        GLES20.glBindTexture(36197, i222);
        zzh("bindTextures");
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, C.TEXTURE_MIN_FILTER_LINEAR);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10241, C.TEXTURE_MIN_FILTER_LINEAR);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzh("texParameteri");
        int glGetUniformLocation42 = GLES20.glGetUniformLocation(this.zzq, "uVMat");
        this.zzr = glGetUniformLocation42;
        GLES20.glUniformMatrix3fv(glGetUniformLocation42, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        int i322 = this.zzq;
        if (objArr == true) {
        }
        String valueOf22 = String.valueOf(GLUtils.getEGLErrorString(this.zzw.eglGetError()));
        int i422 = com.google.android.gms.ads.internal.util.zze.zza;
        String concat22 = "EGL initialization failed: ".concat(valueOf22);
        com.google.android.gms.ads.internal.util.client.zzo.zzg(concat22);
        com.google.android.gms.ads.internal.zzv.zzp().zzw(new Throwable(concat22), "SphericalVideoProcessor.run.1");
        zzg();
        this.zzu.countDown();
    }

    @Override // com.google.android.gms.internal.ads.zzcbx
    public final void zza() {
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i, int i2) {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzn = i;
            this.zzm = i2;
            this.zzA = true;
            obj.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzn = i;
        this.zzm = i2;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzB = true;
            this.zzp = null;
            obj.notifyAll();
        }
    }

    public final void zzf(float f, float f2) {
        int i = this.zzn;
        int i2 = this.zzm;
        if (i <= i2) {
            i = i2;
        }
        float f3 = i;
        this.zzk -= (f * 1.7453293f) / f3;
        float f4 = this.zzl - ((f2 * 1.7453293f) / f3);
        this.zzl = f4;
        if (f4 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f4 = -1.5707964f;
        }
        if (f4 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    final boolean zzg() {
        EGLSurface eGLSurface = this.zzz;
        boolean z = false;
        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
            z = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay) | z;
        this.zzx = null;
        return eglTerminate;
    }
}
