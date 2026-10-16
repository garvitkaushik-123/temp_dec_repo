package com.inmobi.media;

import android.content.ContentValues;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.g0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2656g0 extends T1 {
    public C2605d0 b;

    public C2656g0() {
        super("ad_quality_db", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, image_location TEXT NOT NULL, sdk_model_result TEXT, beacon_url TEXT NOT NULL, extras TEXT)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("image_location");
        String asString2 = contentValues.getAsString("beacon_url");
        String asString3 = contentValues.getAsString("sdk_model_result");
        String asString4 = contentValues.getAsString("extras");
        if ((asString2 != null && asString2.length() != 0) || (asString != null && asString.length() != 0)) {
            Intrinsics.checkNotNull(asString);
            Intrinsics.checkNotNull(asString2);
            return new AdQualityResult(asString, asString3, asString2, asString4);
        }
        String asString5 = contentValues.getAsString("id");
        Intrinsics.checkNotNullExpressionValue(asString5, "getAsString(...)");
        a("id=?", new String[]{asString5});
        return null;
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        AdQualityResult item = (AdQualityResult) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        ContentValues contentValues = new ContentValues();
        contentValues.put("image_location", item.getImageLocation());
        String sdkModelResult = item.getSdkModelResult();
        if (sdkModelResult == null) {
            sdkModelResult = "";
        }
        contentValues.put("sdk_model_result", sdkModelResult);
        contentValues.put("beacon_url", item.getBeaconUrl());
        contentValues.put("extras", item.getExtras());
        return contentValues;
    }

    public final void a(AdQualityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Log.i("AdQualityDao", "queueing");
        a((Object) result);
        C2605d0 c2605d0 = this.b;
        if (c2605d0 != null) {
            Log.i("AdQualityDao", "sending callback - queued");
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("item update callback received", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityBeaconExecutor", "item update callback received");
            if (c2605d0.c.get()) {
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("resume executor", PglCryptUtils.KEY_MESSAGE);
                Log.i("AdQualityBeaconExecutor", "resume executor");
                c2605d0.c.set(false);
                C2571b0 execute = new C2571b0(c2605d0);
                Intrinsics.checkNotNullParameter(execute, "execute");
                ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
                C2638f0.a(new C2587c(execute));
            }
        }
    }
}
