package com.instagram.common.viewpoint.core;

import java.io.ByteArrayInputStream;

/* renamed from: com.facebook.ads.redexgen.X.kq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2167kq implements InterfaceC1147Ll {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C2167kq(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final void AGj(int i) throws C2164kn {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip(i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final void close() throws C2164kn {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final int length() throws C2164kn {
        return this.A01.length;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final int read(byte[] bArr) throws C2164kn {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
