package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o {
    public static final i.a.AbstractC0479a a(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return e instanceof UnknownHostException ? i.a.AbstractC0479a.q.c : e instanceof SocketException ? i.a.AbstractC0479a.C0481i.c : e instanceof SSLHandshakeException ? i.a.AbstractC0479a.j.c : e instanceof IOException ? i.a.AbstractC0479a.f.c : e instanceof SecurityException ? i.a.AbstractC0479a.g.c : e instanceof p ? i.a.AbstractC0479a.m.c : e instanceof NumberFormatException ? i.a.AbstractC0479a.l.c : i.a.AbstractC0479a.r.c;
    }
}
