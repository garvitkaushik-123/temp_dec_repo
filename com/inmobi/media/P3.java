package com.inmobi.media;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes4.dex */
public final class P3 {

    /* renamed from: a, reason: collision with root package name */
    public final Q3 f2393a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ S3 d;

    public P3(S3 s3, Q3 q3) {
        this.d = s3;
        this.f2393a = q3;
        this.b = q3.c ? null : new boolean[s3.h];
    }

    public final OutputStream a(int i) {
        FileOutputStream fileOutputStream;
        O3 o3;
        synchronized (this.d) {
            Q3 q3 = this.f2393a;
            if (q3.d != this) {
                throw new IllegalStateException();
            }
            if (!q3.c) {
                this.b[i] = true;
            }
            File b = q3.b(i);
            try {
                fileOutputStream = new FileOutputStream(b);
            } catch (FileNotFoundException unused) {
                this.d.f2423a.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException unused2) {
                    return S3.q;
                }
            }
            o3 = new O3(this, fileOutputStream);
        }
        return o3;
    }

    public final void a(String str, int i) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(a(i), Ge.b);
            try {
                outputStreamWriter2.write(str);
                Ge.a(outputStreamWriter2);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                Ge.a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
