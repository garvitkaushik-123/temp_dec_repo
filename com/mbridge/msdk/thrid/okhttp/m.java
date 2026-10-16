package com.mbridge.msdk.thrid.okhttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes6.dex */
public interface m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f4879a = new a();

    /* compiled from: Dns.java */
    static class a implements m {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.m
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    }

    List<InetAddress> a(String str) throws UnknownHostException;
}
