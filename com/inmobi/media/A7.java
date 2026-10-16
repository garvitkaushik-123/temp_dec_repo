package com.inmobi.media;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes4.dex */
public final class A7 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2232a;
    public final int b;
    public final int c;
    public final long d;
    public final InterfaceC2971z5 e;
    public final String f = "A7";
    public N9 g;

    public A7(String str, int i, int i2, long j, InterfaceC2971z5 interfaceC2971z5) {
        this.f2232a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = interfaceC2971z5;
    }

    public final void a() {
        String str = this.f2232a;
        if (str == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.e;
            if (interfaceC2971z5 != null) {
                String TAG = this.f;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).b(TAG, "MRAID Js Url provided is invalid.");
                return;
            }
            return;
        }
        N9 n9 = new N9(str, this.e);
        n9.t = false;
        n9.u = false;
        n9.x = false;
        this.g = n9;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.A7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A7.a(A7.this);
            }
        });
    }

    public static final void a(A7 this$0) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        N9 mRequest = this$0.g;
        Context d = Uc.d();
        if (d != null) {
            if ((System.currentTimeMillis() / 1000) - new Sa(d, "mraid_js_store").b() <= this$0.d || mRequest == null) {
                return;
            }
            int i = 0;
            while (i <= this$0.b) {
                InterfaceC2971z5 interfaceC2971z5 = this$0.e;
                if (interfaceC2971z5 != null) {
                    String TAG = this$0.f;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "Attempting to get MRAID Js.");
                }
                Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                P9 b = mRequest.b();
                Context d2 = Uc.d();
                if (b.b()) {
                    InterfaceC2971z5 interfaceC2971z52 = this$0.e;
                    if (interfaceC2971z52 != null) {
                        String TAG2 = this$0.f;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z52).b(TAG2, "Getting MRAID Js from server failed.");
                    }
                    i++;
                    if (i > this$0.b) {
                        return;
                    }
                    try {
                        Thread.sleep(this$0.c * 1000);
                    } catch (InterruptedException e) {
                        InterfaceC2971z5 interfaceC2971z53 = this$0.e;
                        if (interfaceC2971z53 != null) {
                            String TAG3 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                            ((A5) interfaceC2971z53).a(TAG3, "MRAID Js client interrupted while sleeping.", e);
                        }
                    }
                } else if (d2 != null) {
                    Sa sa = new Sa(d2, "mraid_js_store");
                    Map map = b.f;
                    String str = null;
                    List list = map != null ? (List) map.get(HttpHeaders.CONTENT_ENCODING) : null;
                    if (Intrinsics.areEqual(list != null ? (String) list.get(0) : null, "gzip")) {
                        InterfaceC2971z5 interfaceC2971z54 = this$0.e;
                        if (interfaceC2971z54 != null) {
                            String TAG4 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                            ((A5) interfaceC2971z54).a(TAG4, "Response is GZIP-compressed, uncompressing it");
                        }
                        boolean z = T9.f2439a;
                        byte[] bArr2 = b.b;
                        if (bArr2 != null && bArr2.length != 0) {
                            Intrinsics.checkNotNull(bArr2);
                            bArr = new byte[bArr2.length];
                            byte[] bArr3 = b.b;
                            Intrinsics.checkNotNull(bArr3);
                            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
                        } else {
                            bArr = new byte[0];
                        }
                        byte[] a2 = T9.a(bArr);
                        if (a2 != null) {
                            try {
                                String str2 = new String(a2, Charsets.UTF_8);
                                InterfaceC2971z5 interfaceC2971z55 = this$0.e;
                                if (interfaceC2971z55 != null) {
                                    String TAG5 = this$0.f;
                                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                    ((A5) interfaceC2971z55).a(TAG5, "Getting MRAID Js from server succeeded.");
                                }
                                str = str2;
                            } catch (UnsupportedEncodingException e2) {
                                InterfaceC2971z5 interfaceC2971z56 = this$0.e;
                                if (interfaceC2971z56 != null) {
                                    String str3 = this$0.f;
                                    ((A5) interfaceC2971z56).b(str3, H6.a(str3, "TAG", "Failed to get MRAID JS \n").append(e2.getMessage()).toString());
                                }
                            }
                        }
                    } else {
                        InterfaceC2971z5 interfaceC2971z57 = this$0.e;
                        if (interfaceC2971z57 != null) {
                            String TAG6 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                            ((A5) interfaceC2971z57).a(TAG6, "Getting MRAID Js from server succeeded.");
                        }
                        str = b.a();
                    }
                    if (str != null) {
                        sa.b("mraid_js_string", str);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
