package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class J4 implements I4 {

    /* renamed from: a, reason: collision with root package name */
    public final Movie f2323a;
    public int b;
    public long c;
    public volatile boolean d;
    public K4 e;

    public J4(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int read = fileInputStream.read(bArr);
            T9.a((Closeable) fileInputStream);
            Movie decodeByteArray = Movie.decodeByteArray(bArr, 0, read);
            this.f2323a = decodeByteArray;
            if (decodeByteArray == null) {
                throw new IllegalStateException("Cannot decode gif byte array");
            }
        } catch (Throwable th) {
            T9.a((Closeable) fileInputStream);
            throw th;
        }
    }

    @Override // com.inmobi.media.I4
    public final void a(boolean z) {
        this.d = z;
        if (!this.d) {
            this.c = SystemClock.uptimeMillis() - this.b;
        }
        K4 k4 = this.e;
        if (k4 != null) {
            Intrinsics.checkNotNull(k4);
            k4.invalidate();
        }
    }

    @Override // com.inmobi.media.I4
    public final boolean b() {
        return !this.d;
    }

    @Override // com.inmobi.media.I4
    public final int c() {
        Movie movie = this.f2323a;
        if (movie != null) {
            return movie.width();
        }
        return 0;
    }

    @Override // com.inmobi.media.I4
    public final void d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.c == 0) {
            this.c = uptimeMillis;
        }
        Movie movie = this.f2323a;
        int duration = movie != null ? movie.duration() : 0;
        if (duration == 0) {
            duration = 1000;
        }
        int i = (int) ((uptimeMillis - this.c) % duration);
        this.b = i;
        Movie movie2 = this.f2323a;
        if (movie2 != null) {
            movie2.setTime(i);
        }
    }

    public final void e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.J4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                J4.a(J4.this);
            }
        });
    }

    @Override // com.inmobi.media.I4
    public final void start() {
    }

    @Override // com.inmobi.media.I4
    public final int a() {
        Movie movie = this.f2323a;
        if (movie != null) {
            return movie.height();
        }
        return 0;
    }

    @Override // com.inmobi.media.I4
    public final void a(Canvas canvas, float f, float f2) {
        Movie movie = this.f2323a;
        if (movie != null) {
            movie.draw(canvas, f, f2);
        }
        Movie movie2 = this.f2323a;
        if (this.b + 20 >= (movie2 != null ? movie2.duration() : 0)) {
            e();
        }
    }

    public static final void a(J4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b = 0;
        this$0.a(false);
    }

    @Override // com.inmobi.media.I4
    public final void a(K4 k4) {
        this.e = k4;
    }
}
