package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.p;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: MBridgeLocalDNSService.java */
/* loaded from: classes6.dex */
public class j implements com.mbridge.msdk.thrid.okhttp.m {
    private final String b;
    private final String c;
    private final p d;

    public j(String str, String str2, p pVar) {
        this.b = str;
        this.c = str2;
        this.d = pVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.m
    public List<InetAddress> a(String str) throws UnknownHostException {
        try {
            List<InetAddress> a2 = com.mbridge.msdk.thrid.okhttp.m.f4879a.a(str);
            return (a2.isEmpty() && i.b().c(this.b, this.c, str)) ? a(str, new UnknownHostException("DNS result is empty")) : a2;
        } catch (UnknownHostException e) {
            if (i.b().c(this.b, this.c, str)) {
                return a(str, new UnknownHostException(e.getMessage()));
            }
            throw e;
        }
    }

    private List<InetAddress> a(String str, UnknownHostException unknownHostException) throws UnknownHostException {
        p pVar = this.d;
        if (pVar != null) {
            pVar.c("local");
        }
        return i.b().a(str, unknownHostException);
    }
}
