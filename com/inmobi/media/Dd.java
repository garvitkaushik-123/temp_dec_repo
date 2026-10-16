package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Dd implements InterfaceC2803p0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2266a;
    public final String b;

    public Dd(String location, byte[] imageBytes) {
        Intrinsics.checkNotNullParameter(imageBytes, "imageBytes");
        Intrinsics.checkNotNullParameter(location, "location");
        this.f2266a = imageBytes;
        this.b = location;
    }

    @Override // com.inmobi.media.InterfaceC2803p0
    public final Object a() {
        byte[] bArr = this.f2266a;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Intrinsics.checkNotNull(decodeByteArray);
        StringBuilder sb = new StringBuilder();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String sb2 = sb.append(uuid).append(".jpg").toString();
        File file = new File(this.b);
        if (!file.exists()) {
            file.mkdirs();
        }
        decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(this.b + '/' + sb2)));
        Intrinsics.checkNotNullParameter("StoreProcess", "tag");
        Intrinsics.checkNotNullParameter("screenshot file saved", PglCryptUtils.KEY_MESSAGE);
        Log.i("StoreProcess", "screenshot file saved");
        return this.b + '/' + sb2;
    }
}
