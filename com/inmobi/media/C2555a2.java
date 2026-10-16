package com.inmobi.media;

import android.util.Base64;
import java.util.BitSet;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.a2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2555a2 {

    /* renamed from: a, reason: collision with root package name */
    public BitSet f2513a;

    public final void a(String b64String) {
        byte[] value;
        BitSet bitSet;
        Intrinsics.checkNotNullParameter(b64String, "b64String");
        try {
            value = Base64.decode(b64String, 0);
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            value = null;
        }
        if (value != null) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (L3.f2348a.F()) {
                bitSet = BitSet.valueOf(value);
            } else {
                Intrinsics.checkNotNullParameter(value, "<this>");
                BitSet bitSet2 = new BitSet(value.length * 8);
                int i = 0;
                for (byte b : value) {
                    int i2 = 0;
                    while (i2 < 8) {
                        boolean z = true;
                        int i3 = i + 1;
                        if (((b >> ((byte) i2)) & 1) != 1) {
                            z = false;
                        }
                        bitSet2.set(i, z);
                        i2++;
                        i = i3;
                    }
                }
                bitSet = bitSet2;
            }
            this.f2513a = bitSet;
        }
    }
}
