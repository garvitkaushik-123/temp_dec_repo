package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class G1 implements Runnable {
    public final WeakReference b;

    /* renamed from: a, reason: collision with root package name */
    public final String f2289a = "G1";
    public final Handler c = new Handler(Looper.getMainLooper());

    public G1(Object obj) {
        this.b = new WeakReference(obj);
    }

    public static final void a(G1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = this$0.b.get();
        if (obj != null) {
            A a2 = A.f2225a;
            int hashCode = obj.hashCode();
            try {
                SparseArray sparseArray = A.b;
                Queue queue = (Queue) sparseArray.get(hashCode);
                if (queue != null) {
                    queue.poll();
                    G1 g1 = (G1) queue.peek();
                    if (queue.size() > 0 && g1 != null) {
                        try {
                            A.c.execute(g1);
                        } catch (OutOfMemoryError unused) {
                            g1.c();
                        }
                    }
                    if (queue.size() == 0) {
                        sparseArray.remove(hashCode);
                    }
                }
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
    }

    public abstract void a();

    public final void b() {
        this.c.post(new Runnable() { // from class: com.inmobi.media.G1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                G1.a(G1.this);
            }
        });
    }

    public void c() {
        String TAG = this.f2289a;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        AbstractC2680h7.a((byte) 1, TAG, "Could not execute runnable due to OutOfMemory.");
        Object obj = this.b.get();
        if (obj != null) {
            A a2 = A.f2225a;
            int hashCode = obj.hashCode();
            SparseArray sparseArray = A.b;
            sparseArray.remove(hashCode);
            Intrinsics.checkNotNullExpressionValue(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "TAG");
            sparseArray.size();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
        b();
    }
}
