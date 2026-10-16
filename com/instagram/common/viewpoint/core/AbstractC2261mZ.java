package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import java.nio.ByteBuffer;

/* renamed from: com.facebook.ads.redexgen.X.mZ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2261mZ implements InterfaceC1055Hw {
    public static String[] A00 = {"S2ZlE7yw63A48uwr9dQcAEYhUnBJ4Yn0", "jzjCSZ", "gN1GhDNq1ONaTY", "QUbV6eP7CXYOE5n4wRXfJJIvrecH4qk8", "luywBeNRakBazgpsmb", "EdZTTUAmlRsHtXkkAmykmZcXBm9Gnzxa", "aBS20hcvH8Cg0VDZoQaxMtYiCLoGsxgc", "2I8VYTEH9eD6qwDjwvQqiLyn0yln2Tpt"};

    public abstract Metadata A0R(C08439e c08439e, ByteBuffer byteBuffer);

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1055Hw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Metadata A5o(C08439e c08439e) {
        boolean z;
        ByteBuffer byteBuffer = (ByteBuffer) AbstractC07133y.A01(c08439e.A02);
        if (byteBuffer.position() == 0 && byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            String[] strArr = A00;
            if (strArr[7].charAt(18) == strArr[3].charAt(18)) {
                throw new RuntimeException();
            }
            A00[1] = "EqsX6PhC";
            if (arrayOffset == 0) {
                z = true;
                AbstractC07133y.A07(z);
                if (c08439e.A04()) {
                    return A0R(c08439e, byteBuffer);
                }
                return null;
            }
        }
        z = false;
        AbstractC07133y.A07(z);
        if (c08439e.A04()) {
        }
    }
}
