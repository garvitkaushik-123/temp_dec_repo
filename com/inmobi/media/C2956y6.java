package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.y6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2956y6 extends N9 {
    public final AdQualityResult y;
    public final AdConfig.AdQualityConfig z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2956y6(AdQualityResult result, C2897ue uidMap, AdConfig.AdQualityConfig config) {
        super("POST", result.getBeaconUrl(), uidMap, false, (InterfaceC2971z5) null, com.ironsource.D5.L, 64);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(uidMap, "uidMap");
        Intrinsics.checkNotNullParameter(config, "config");
        this.y = result;
        this.z = config;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(13:3|4|5|(1:7)|8|(1:36)|11|12|13|(4:15|(1:19)|21|(2:23|(2:25|26)(1:28))(2:29|30))|31|21|(0)(0))|40|11|12|13|(0)|31|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter("error while adding extras", com.bytedance.sdk.component.pglcrypt.PglCryptUtils.KEY_MESSAGE);
        android.util.Log.e("JsonBeaconRequest", "error while adding extras", r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a0 A[Catch: JSONException -> 0x00b7, TryCatch #0 {JSONException -> 0x00b7, blocks: (B:13:0x0094, B:15:0x00a0, B:17:0x00a8, B:19:0x00ac), top: B:12:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    @Override // com.inmobi.media.N9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("preparing beacon request", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "preparing beacon request");
        this.t = false;
        this.u = false;
        this.x = false;
        this.v = false;
        super.f();
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getScreenshot", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "getScreenshot");
        if (this.y.getImageLocation().length() > 0) {
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("screen shot image found in DB", PglCryptUtils.KEY_MESSAGE);
            Log.i("JsonBeaconRequest", "screen shot image found in DB");
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.y.getImageLocation());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeFile != null) {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                if (byteArray.length != 0 && (jSONObject2 = this.l) != null) {
                    jSONObject2.put("screenshotImageByte", Base64.encodeToString(byteArray, 0));
                }
            } catch (FileNotFoundException e) {
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("image file not found...", PglCryptUtils.KEY_MESSAGE);
                Log.e("JsonBeaconRequest", "image file not found...", e);
            }
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("getExtras", PglCryptUtils.KEY_MESSAGE);
            Log.i("JsonBeaconRequest", "getExtras");
            if (B2.a(this.y.getExtras())) {
                String extras = this.y.getExtras();
                if (extras != null && (jSONObject = this.l) != null) {
                    jSONObject.put("templateInfo", new JSONObject(extras));
                }
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("getExtras", PglCryptUtils.KEY_MESSAGE);
                Log.i("JsonBeaconRequest", "getExtras");
                if (!B2.a(this.y.getSdkModelResult())) {
                    Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                    Intrinsics.checkNotNullParameter("result has no model info", PglCryptUtils.KEY_MESSAGE);
                    Log.i("JsonBeaconRequest", "result has no model info");
                    return;
                } else {
                    JSONObject jSONObject3 = this.l;
                    if (jSONObject3 != null) {
                        jSONObject3.put("sdkModelInfo", this.y.getSdkModelResult());
                        return;
                    }
                    return;
                }
            }
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("result has no extras", PglCryptUtils.KEY_MESSAGE);
            Log.i("JsonBeaconRequest", "result has no extras");
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("getExtras", PglCryptUtils.KEY_MESSAGE);
            Log.i("JsonBeaconRequest", "getExtras");
            if (!B2.a(this.y.getSdkModelResult())) {
            }
        }
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("result produced no screenshot", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "result produced no screenshot");
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getExtras", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "getExtras");
        if (B2.a(this.y.getExtras())) {
        }
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("result has no extras", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "result has no extras");
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getExtras", PglCryptUtils.KEY_MESSAGE);
        Log.i("JsonBeaconRequest", "getExtras");
        if (!B2.a(this.y.getSdkModelResult())) {
        }
    }
}
