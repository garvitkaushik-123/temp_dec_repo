package com.inmobi.media;

import android.content.Context;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ya, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2960ya {
    public static volatile Picasso b;

    /* renamed from: a, reason: collision with root package name */
    public static final C2960ya f2764a = new C2960ya();
    public static final Object c = new Object();
    public static final ArrayList d = new ArrayList();
    public static final C2941xa e = new C2941xa();

    public static final /* synthetic */ String d() {
        return "ya";
    }

    public static final WeakReference a(C2960ya c2960ya, Context context) {
        c2960ya.getClass();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = d;
            Context context2 = (Context) ((WeakReference) arrayList.get(i)).get();
            if (context2 != null && Intrinsics.areEqual(context2, context)) {
                return (WeakReference) arrayList.get(i);
            }
        }
        return null;
    }

    public final Picasso a(Context context) {
        WeakReference weakReference;
        Picasso picasso;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (c) {
            int size = d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    weakReference = null;
                    break;
                }
                ArrayList arrayList = d;
                Context context2 = (Context) ((WeakReference) arrayList.get(i)).get();
                if (context2 != null && Intrinsics.areEqual(context2, context)) {
                    weakReference = (WeakReference) arrayList.get(i);
                    break;
                }
                i++;
            }
            if (weakReference == null) {
                d.add(new WeakReference(context));
            }
            picasso = b;
            if (picasso == null) {
                picasso = new Picasso.Builder(context).build();
                b = picasso;
                Uc.a(context, e);
            }
        }
        Intrinsics.checkNotNullExpressionValue(picasso, "synchronized(...)");
        return picasso;
    }

    public final Object a(InvocationHandler connectionCallbackHandler) {
        Intrinsics.checkNotNullParameter(connectionCallbackHandler, "connectionCallbackHandler");
        try {
            return Proxy.newProxyInstance(Callback.class.getClassLoader(), new Class[]{Callback.class}, connectionCallbackHandler);
        } catch (Exception unused) {
            return null;
        }
    }
}
