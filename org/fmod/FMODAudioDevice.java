package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public class FMODAudioDevice implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private volatile Thread f7207a = null;
    private volatile boolean b = false;
    private AudioTrack c = null;
    private boolean d = false;
    private ByteBuffer e = null;
    private byte[] f = null;
    private volatile a g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public synchronized void start() {
        if (this.f7207a != null) {
            stop();
        }
        this.f7207a = new Thread(this, "FMODAudioDevice");
        this.f7207a.setPriority(10);
        this.b = true;
        this.f7207a.start();
        if (this.g != null) {
            a aVar = this.g;
            if (aVar.e != null) {
                aVar.b();
            }
            aVar.f = true;
            aVar.e = new Thread(aVar);
            aVar.e.start();
        }
    }

    public synchronized void stop() {
        while (this.f7207a != null) {
            this.b = false;
            try {
                this.f7207a.join();
                this.f7207a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.g != null) {
            this.g.b();
        }
    }

    public synchronized void close() {
        stop();
    }

    public boolean isRunning() {
        return this.f7207a != null && this.f7207a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 3;
        while (this.b) {
            if (!this.d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(0);
                int i2 = fmodGetInfo(4) == 1 ? 4 : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(fmodGetInfo, i2, 2);
                int fmodGetInfo2 = fmodGetInfo(4) * 2;
                int round = Math.round(minBufferSize * 1.1f) & (~(fmodGetInfo2 - 1));
                int fmodGetInfo3 = fmodGetInfo(1);
                int fmodGetInfo4 = fmodGetInfo(2) * fmodGetInfo3 * fmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, i2, 2, fmodGetInfo4 > round ? fmodGetInfo4 : round, 1);
                this.c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo3 * fmodGetInfo2);
                    this.e = allocateDirect;
                    this.f = new byte[allocateDirect.capacity()];
                    this.c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.c.getState() + ")");
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.d) {
                if (fmodGetInfo(3) == 1) {
                    fmodProcess(this.e);
                    ByteBuffer byteBuffer = this.e;
                    byteBuffer.get(this.f, 0, byteBuffer.capacity());
                    this.c.write(this.f, 0, this.e.capacity());
                    this.e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.c.stop();
            }
            this.c.release();
            this.c = null;
        }
        this.e = null;
        this.f = null;
        this.d = false;
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.g == null) {
            this.g = new a(this, i, i2);
            a aVar = this.g;
            if (aVar.e != null) {
                aVar.b();
            }
            aVar.f = true;
            aVar.e = new Thread(aVar);
            aVar.e.start();
        }
        return this.g.b.capacity();
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
    }
}
