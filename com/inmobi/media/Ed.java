package com.inmobi.media;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class Ed extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fd f2276a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ed(Fd fd, int i) {
        super(i);
        this.f2276a = fd;
    }

    @Override // java.io.ByteArrayOutputStream
    public final synchronized String toString() {
        int i;
        i = ((ByteArrayOutputStream) this).count;
        if (i > 0) {
            int i2 = i - 1;
            if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                i = i2;
            }
        }
        try {
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
        return new String(((ByteArrayOutputStream) this).buf, 0, i, this.f2276a.b.name());
    }
}
