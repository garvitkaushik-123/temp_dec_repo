package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Wb implements InterfaceC2884u1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2472a;

    public Wb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2472a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch, byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (assetBatch.c == null || assetBatch.g.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", ((C2705j) assetBatch.g.get(0)).b);
            jSONObject.put("reason", (int) ((C2705j) assetBatch.g.get(0)).l);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        String str = "sendSaveContentResult(\"saveContent_" + assetBatch.f + "\", 'failed', \"" + StringsKt.replace$default(jSONObject2, "\"", "\\\"", false, 4, (Object) null) + "\");";
        InterfaceC2971z5 interfaceC2971z5 = this.f2472a.i;
        if (interfaceC2971z5 != null) {
            String str2 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).b(str2, I6.a(str2, "access$getTAG$cp(...)", "Failure injection ", str));
        }
        this.f2472a.a(assetBatch.c, str);
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (assetBatch.c == null || assetBatch.g.size() <= 0) {
            return;
        }
        String str = "sendSaveContentResult(\"saveContent_" + assetBatch.f + "\", 'success', \"" + ((C2705j) assetBatch.g.get(0)).j + "\");";
        InterfaceC2971z5 interfaceC2971z5 = this.f2472a.i;
        if (interfaceC2971z5 != null) {
            String str2 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$cp(...)", "Success injection ", str));
        }
        this.f2472a.a(assetBatch.c, str);
    }
}
