package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.bH, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1594bH implements Runnable {
    public static String[] A01 = {"wQeUkUFktfM2l", "7XaAWiHxEbalq5gcAes6NrqtmXxPT4Y3", "2fv7kArIDvQtbqE5fFFu3pq8qRlQU6Cv", "0xhN0xjEaMXvjGar1KVcE", "ki2D6rKULGHthGJNrJcFjvO3aJEOf9d", "JHuN8xfhz8lLzrwSWaENIG05O1ASDFA", "9Zp5ZsxK45djlTC7gbsQv9P1cFfLGY7l", "GKuX8TC50ZMrYys0rib1"};
    public final /* synthetic */ LK A00;

    public RunnableC1594bH(LK lk) {
        this.A00 = lk;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int A0I;
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A01 = this.A00.A0T.A04();
            LK lk = this.A00;
            A0I = LK.A0I(this.A00.A0T.A04());
            lk.A03 = A0I;
            this.A00.A0p();
        } catch (Throwable th) {
            if (A01[7].length() == 26) {
                throw new RuntimeException();
            }
            A01[2] = "KsmznMcBbJjrBrEeTGYdkeMkvFpYNuvy";
            WU.A00(th, this);
        }
    }
}
