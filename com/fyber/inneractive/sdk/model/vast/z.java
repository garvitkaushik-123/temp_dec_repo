package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class z implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Integer[] f1297a;
    public final String b;

    public z(String str) {
        this.f1297a = new Integer[0];
        if (TextUtils.isEmpty(str) || !str.matches("^[0-9.]+$")) {
            throw new y();
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("\\.")) {
            arrayList.add(Integer.valueOf(com.fyber.inneractive.sdk.util.t.a(str2, 0)));
        }
        this.f1297a = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
        this.b = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(z zVar) {
        if (zVar == null) {
            return 1;
        }
        int max = Math.max(this.f1297a.length, zVar.f1297a.length);
        int i = 0;
        while (i < max) {
            Integer[] numArr = this.f1297a;
            int intValue = numArr.length > i ? numArr[i].intValue() : 0;
            Integer[] numArr2 = zVar.f1297a;
            int intValue2 = numArr2.length > i ? numArr2[i].intValue() : 0;
            if (intValue > intValue2) {
                return 1;
            }
            if (intValue2 > intValue) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public final String toString() {
        return this.b;
    }
}
