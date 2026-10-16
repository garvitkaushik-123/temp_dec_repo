package com.inmobi.media;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.q9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2828q9 implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final C2613d8 f2683a;
    public final WeakReference b;
    public final WeakReference c;

    public C2828q9(Context context, ImageView imageView, C2613d8 imageAsset) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageAsset, "imageAsset");
        this.f2683a = imageAsset;
        this.b = new WeakReference(context);
        this.c = new WeakReference(imageView);
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String str;
        HashMap hashMap = D9.c;
        Intrinsics.checkNotNullExpressionValue("D9", "access$getTAG$cp(...)");
        Objects.toString(method);
        if (StringsKt.equals("onError", method != null ? method.getName() : null, true)) {
            HashMap hashMap2 = D9.c;
            Context context = (Context) this.b.get();
            ImageView imageView = (ImageView) this.c.get();
            C2613d8 c2613d8 = this.f2683a;
            if (context != null && imageView != null) {
                String str2 = c2613d8.p;
                if (StringsKt.equals("cross_button", c2613d8.b, true)) {
                    if (str2 != null) {
                        int length = str2.length() - 1;
                        int i = 0;
                        boolean z = false;
                        while (i <= length) {
                            boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length--;
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        str = I7.a(length, 1, str2, i);
                    } else {
                        str = null;
                    }
                    if (str == null || str.length() == 0) {
                        C2779n9.a(context, imageView);
                    }
                }
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("[ERRORCODE]", "603");
            c2613d8.a("error", hashMap3, (L7) null, (InterfaceC2971z5) null);
        }
        return null;
    }
}
