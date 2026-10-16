package com.inmobi.media;

import java.io.BufferedOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2753m {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2771n1 f2636a;

    public C2753m(InterfaceC2771n1 mResultListener) {
        Intrinsics.checkNotNullParameter(mResultListener, "mResultListener");
        this.f2636a = mResultListener;
    }

    public static void a(File file, HttpURLConnection httpURLConnection, BufferedOutputStream bufferedOutputStream) {
        try {
            if (file.exists()) {
                file.delete();
                Intrinsics.checkNotNullExpressionValue("m", "TAG");
            }
            httpURLConnection.disconnect();
            T9.a(bufferedOutputStream);
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
