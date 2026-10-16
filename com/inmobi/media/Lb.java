package com.inmobi.media;

import android.util.SparseArray;
import com.inmobi.ads.rendering.InMobiAdActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Lb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Lb f2353a = new Lb();

    public Lb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JSONObject jsonObject = (JSONObject) obj;
        Intrinsics.checkNotNullParameter(jsonObject, "it");
        SparseArray sparseArray = InMobiAdActivity.k;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = InMobiAdActivity.l;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.a(jsonObject);
        }
        return Unit.INSTANCE;
    }
}
