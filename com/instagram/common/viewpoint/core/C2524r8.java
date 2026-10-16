package com.instagram.common.viewpoint.core;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Arrays;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/instagram/common/viewpoint/core/ViewpointViewNode$Companion;", "", "<init>", "()V", "viewToNodeMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/instagram/common/viewpoint/core/ViewpointViewNode;", "forView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "fbandroid.java.com.instagram.common.viewpoint.core.core_an"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.r8, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2524r8 {
    public static byte[] A00;

    static {
        A01();
    }

    public /* synthetic */ C2524r8(AbstractC2504qZ abstractC2504qZ) {
        this();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-3, -16, -20, -2};
    }

    public C2524r8() {
    }

    @JvmStatic
    public final ViewpointViewNode A02(View view) {
        WeakHashMap weakHashMap;
        C2503qY.A09(view, A00(0, 4, 75));
        weakHashMap = ViewpointViewNode.A04;
        WeakHashMap weakHashMap2 = weakHashMap;
        Object obj = weakHashMap2.get(view);
        if (obj == null) {
            obj = new ViewpointViewNode(view, null);
            weakHashMap2.put(view, obj);
        }
        return (ViewpointViewNode) obj;
    }
}
