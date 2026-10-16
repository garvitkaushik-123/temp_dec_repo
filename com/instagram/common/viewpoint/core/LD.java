package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* loaded from: assets/audience_network/classes2.dex */
public final class LD {
    public final int A00;
    public final String A01;
    public final List<LC> A02;
    public final byte[] A03;

    public LD(int i, String str, List<LC> list, byte[] bArr) {
        List<LC> unmodifiableList;
        this.A00 = i;
        this.A01 = str;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.A02 = unmodifiableList;
        this.A03 = bArr;
    }
}
