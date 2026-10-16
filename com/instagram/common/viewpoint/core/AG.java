package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public final class AG implements InterfaceC2425pF {
    public static String[] A04 = {"DnWOFrWNtrruVDlZPcn7mSzqB1u3fyA1", "4khCAmOyD7V9Z9fo", "Y1he90jrlOSSnjRb2RN33xbae", "sN3uyyiAo7qwm0FA39xGDer", "C", "MIilbOvYRfmfRo2RH", "W4KUp4d37G5W3qTHHFYFOJnsXzg3Y9", "7BjcD7lz4UoePoP5n6bqbpOg1qjeNk3c"};
    public long A00;
    public Uri A01 = Uri.EMPTY;
    public Map<String, List<String>> A02 = Collections.emptyMap();
    public final InterfaceC2425pF A03;

    public AG(InterfaceC2425pF interfaceC2425pF) {
        this.A03 = (InterfaceC2425pF) AbstractC07133y.A01(interfaceC2425pF);
    }

    public final long A00() {
        return this.A00;
    }

    public final Uri A01() {
        return this.A01;
    }

    public final Map<String, List<String>> A02() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void A43(InterfaceC07605t interfaceC07605t) {
        AbstractC07133y.A01(interfaceC07605t);
        this.A03.A43(interfaceC07605t);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Map<String, List<String>> A8t() {
        return this.A03.A8t();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Uri A9P() {
        return this.A03.A9P();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final long AGi(C07495i c07495i) throws IOException {
        this.A01 = c07495i.A06;
        this.A02 = Collections.emptyMap();
        long AGi = this.A03.AGi(c07495i);
        this.A01 = (Uri) AbstractC07133y.A01(A9P());
        this.A02 = A8t();
        return AGi;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void close() throws IOException {
        this.A03.close();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.A03.read(bArr, i, i2);
        if (read != -1) {
            long j = this.A00;
            long j2 = read;
            String[] strArr = A04;
            String str = strArr[2];
            String str2 = strArr[1];
            int length = str.length();
            int bytesRead = str2.length();
            if (length == bytesRead) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "l8Xa62wp4MYShhMptlDz52jvD";
            strArr2[1] = "PdriuKYg1yn0hjm9";
            this.A00 = j + j2;
        }
        return read;
    }
}
