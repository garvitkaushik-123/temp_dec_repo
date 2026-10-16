package com.inmobi.media;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2755m1 extends T1 {
    public C2755m1() {
        super("asset", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, disk_uri TEXT, ts TEXT NOT NULL, created_ts TEXT NOT NULL, ttl TEXT NOT NULL, soft_ttl TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Integer asInteger = contentValues.getAsInteger("id");
        Integer asInteger2 = contentValues.getAsInteger("pending_attempts");
        String asString = contentValues.getAsString("url");
        String asString2 = contentValues.getAsString("disk_uri");
        Long asLong = contentValues.getAsLong("ts");
        Long asLong2 = contentValues.getAsLong("created_ts");
        Long asLong3 = contentValues.getAsLong("ttl");
        Long asLong4 = contentValues.getAsLong("soft_ttl");
        Intrinsics.checkNotNull(asInteger);
        int intValue = asInteger.intValue();
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asInteger2);
        int intValue2 = asInteger2.intValue();
        Intrinsics.checkNotNull(asLong);
        long longValue = asLong.longValue();
        Intrinsics.checkNotNull(asLong2);
        long longValue2 = asLong2.longValue();
        Intrinsics.checkNotNull(asLong3);
        long longValue3 = asLong3.longValue();
        Intrinsics.checkNotNull(asLong4);
        return new C2705j(intValue, asString, asString2, intValue2, longValue, longValue2, longValue3, asLong4.longValue());
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        C2705j adAsset = (C2705j) obj;
        Intrinsics.checkNotNullParameter(adAsset, "adAsset");
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(adAsset.f2604a));
        contentValues.put("url", adAsset.b);
        contentValues.put("disk_uri", adAsset.c);
        contentValues.put("pending_attempts", Integer.valueOf(adAsset.d));
        contentValues.put("ts", String.valueOf(adAsset.e));
        contentValues.put("created_ts", String.valueOf(adAsset.f));
        contentValues.put("ttl", String.valueOf(adAsset.g));
        contentValues.put("soft_ttl", String.valueOf(adAsset.h));
        return contentValues;
    }

    public final ArrayList a() {
        ArrayList a2 = T1.a(this, null, null, null, null, "created_ts DESC ", null, 47);
        ArrayList arrayList = new ArrayList();
        for (Object obj : a2) {
            C2705j c2705j = (C2705j) obj;
            if (c2705j != null && c2705j.a()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2705j c2705j2 = (C2705j) it.next();
            if (c2705j2 != null) {
                arrayList2.add(c2705j2);
            }
        }
        return arrayList2;
    }

    public final ArrayList b() {
        ArrayList a2 = T1.a(this, null, null, null, null, "ts ASC ", null, 47);
        ArrayList arrayList = new ArrayList();
        for (Object obj : a2) {
            C2705j c2705j = (C2705j) obj;
            if (c2705j != null && !c2705j.a()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2705j c2705j2 = (C2705j) it.next();
            if (c2705j2 != null) {
                arrayList2.add(c2705j2);
            }
        }
        return arrayList2;
    }

    public final C2705j a(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        ArrayList a2 = T1.a(this, "url=? ", new String[]{remoteUrl}, null, null, "created_ts DESC ", 1, 12);
        if (a2.isEmpty()) {
            return null;
        }
        return (C2705j) a2.get(0);
    }

    public final void a(C2705j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        b(asset, "url = ?", new String[]{asset.b.toString()});
    }

    public final C2705j b(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        ArrayList a2 = T1.a(this, "url=? ", new String[]{remoteUrl}, null, null, "created_ts DESC ", 1, 12);
        if (a2.isEmpty()) {
            return null;
        }
        return (C2705j) a2.get(0);
    }
}
