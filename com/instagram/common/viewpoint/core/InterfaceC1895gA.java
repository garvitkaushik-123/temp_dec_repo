package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;

/* renamed from: com.facebook.ads.redexgen.X.gA, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC1895gA {
    boolean ADs(C1893g8 c1893g8);

    HttpURLConnection AGl(String str, Proxy proxy) throws IOException;

    InputStream AGm(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream AGn(HttpURLConnection httpURLConnection) throws IOException;

    void AH6(HttpURLConnection httpURLConnection, EnumC1891g6 enumC1891g6, String str) throws IOException;

    byte[] AHT(InputStream inputStream) throws IOException;

    void AL8(OutputStream outputStream, byte[] bArr) throws IOException;
}
