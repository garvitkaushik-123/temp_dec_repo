package com.pgl.ssdk;

import android.content.Context;

/* loaded from: classes6.dex */
public class o0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f6405a;
    private int b;
    private Object[] c;

    public o0(Context context, int i, Object[] objArr) {
        this.f6405a = context;
        this.b = i;
        this.c = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b == 222) {
                k0.a(this.f6405a).a();
            }
            byte[] bArr = (byte[]) com.pgl.ssdk.ces.a.meta(this.b, this.f6405a, this.c);
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            new p0(this.f6405a, this.b).a(1, 2, bArr);
        } catch (Throwable unused) {
        }
    }
}
