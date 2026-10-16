package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class Ue implements FS<PointF> {
    public static final Ue eli = new Ue();

    private Ue() {
    }

    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public PointF DbA(JsonReader jsonReader, float f) throws IOException {
        return QX.DbA(jsonReader, f);
    }
}
