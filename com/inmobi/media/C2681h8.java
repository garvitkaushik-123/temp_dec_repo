package com.inmobi.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.h8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2681h8 extends C2613d8 implements Iterable, KMappedMarker {
    public final ArrayList A;
    public int B;
    public final boolean C;
    public final boolean D;
    public final int x;
    public long y;
    public final byte z;

    public /* synthetic */ C2681h8(String str, String str2, C2630e8 c2630e8, String str3, JSONObject jSONObject, byte b) {
        this(str, str2, c2630e8, new ArrayList(), str3, jSONObject, b);
    }

    public final void a(C2613d8 child) {
        Intrinsics.checkNotNullParameter(child, "child");
        int i = this.B;
        if (i < this.x) {
            this.B = i + 1;
            this.A.add(child);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C2665g8(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2681h8(String assetId, String assetName, C2630e8 assetStyle, List trackers, String interactionMode, JSONObject rawAssetJson, byte b) {
        super(assetId, assetName, "CONTAINER", assetStyle, trackers);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(rawAssetJson, "rawAssetJson");
        this.x = 16;
        this.z = b;
        this.A = new ArrayList();
        Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
        this.g = interactionMode;
        this.C = StringsKt.equals("root", assetName, true);
        this.D = StringsKt.equals("card_scrollable", assetName, true);
    }
}
