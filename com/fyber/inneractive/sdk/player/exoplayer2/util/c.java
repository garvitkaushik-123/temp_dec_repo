package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f1582a;
    public final File b;

    public c(File file) {
        this.f1582a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public final FileInputStream a() {
        if (this.b.exists()) {
            this.f1582a.delete();
            this.b.renameTo(this.f1582a);
        }
        return new FileInputStream(this.f1582a);
    }

    public final b b() {
        if (this.f1582a.exists()) {
            if (this.b.exists()) {
                this.f1582a.delete();
            } else if (!this.f1582a.renameTo(this.b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f1582a + " to backup file " + this.b);
            }
        }
        try {
            return new b(this.f1582a);
        } catch (FileNotFoundException unused) {
            if (!this.f1582a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f1582a);
            }
            try {
                return new b(this.f1582a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f1582a);
            }
        }
    }
}
