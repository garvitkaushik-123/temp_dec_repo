package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.t;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class g implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final int f1248a;
    public final int b;
    public final int c;

    public g(int i, int i2, int i3) {
        this.f1248a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        r rVar = (r) obj;
        r rVar2 = (r) obj2;
        int i = -1;
        if (!TextUtils.equals("VPAID", rVar2.f)) {
            if (!TextUtils.equals("VPAID", rVar.f)) {
                Integer num = rVar.e;
                int intValue = num == null ? 0 : num.intValue();
                Integer num2 = rVar2.e;
                int intValue2 = num2 == null ? 0 : num2.intValue();
                int i2 = this.f1248a;
                if (intValue2 <= i2 || intValue > i2) {
                    if (intValue <= i2 || intValue2 > i2) {
                        t a2 = t.a(rVar2.d);
                        t tVar = t.MEDIA_TYPE_MP4;
                        Integer num3 = a2 == tVar ? 3 : a2 == t.MEDIA_TYPE_3GPP ? 2 : a2 == t.MEDIA_TYPE_WEBM ? 1 : -1;
                        t a3 = t.a(rVar.d);
                        if (a3 == tVar) {
                            i = 3;
                        } else if (a3 == t.MEDIA_TYPE_3GPP) {
                            i = 2;
                        } else if (a3 == t.MEDIA_TYPE_WEBM) {
                            i = 1;
                        }
                        int compareTo = num3.compareTo(i);
                        if (compareTo != 0) {
                            return compareTo;
                        }
                        if (intValue >= intValue2) {
                            if (intValue <= intValue2) {
                                Integer num4 = rVar.b;
                                int intValue3 = num4 == null ? 0 : num4.intValue();
                                Integer num5 = rVar.c;
                                int intValue4 = num5 == null ? 0 : num5.intValue();
                                Integer num6 = rVar2.b;
                                int intValue5 = num6 == null ? 0 : num6.intValue();
                                Integer num7 = rVar2.c;
                                int i3 = intValue3 * intValue4;
                                int intValue6 = intValue5 * (num7 == null ? 0 : num7.intValue());
                                int i4 = this.b * this.c;
                                int abs = Math.abs(i3 - i4);
                                int abs2 = Math.abs(intValue6 - i4);
                                if (abs >= abs2) {
                                    if (abs <= abs2) {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
