package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: StringSetEncoder.java */
/* loaded from: classes6.dex */
class y0 implements FastKV.b<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    static final y0 f4388a = new y0();

    private y0() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<String> a(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            a0 a0Var = new a0(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = a0Var.b;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(a0Var.e(a0Var.g()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public byte[] a(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int b = a0.b(str);
                strArr[i2] = str;
                iArr[i2] = b;
                i += a0.f(b) + b;
            }
            i2++;
        }
        a0 a0Var = new a0(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            a0Var.h(i4);
            if (i4 >= 0) {
                a0Var.c(strArr[i3]);
            }
        }
        return a0Var.f4349a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public String a() {
        return "StringSet";
    }
}
