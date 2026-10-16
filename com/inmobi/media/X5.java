package com.inmobi.media;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class X5 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2479a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X5(Y5 y5, ArrayList arrayList) {
        super(1);
        this.f2479a = arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Object obj) {
        String str;
        Y6 dbData = (Y6) obj;
        Intrinsics.checkNotNullParameter(dbData, "dbData");
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
        String fileName = dbData.f2492a;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Z5 z5 = null;
        try {
            Iterator it = AbstractC2713j7.f2611a.iterator();
            while (it.hasNext()) {
                Ab ab = (Ab) ((WeakReference) it.next()).get();
                if (Intrinsics.areEqual(ab != null ? ab.j : null, fileName)) {
                    break;
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
        String filePath = dbData.f2492a;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try {
                str = FilesKt.readText$default(file, null, 1, null);
            } catch (Exception unused) {
            }
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("vitals");
                JSONArray jSONArray = jSONObject.getJSONArray("log");
                Intrinsics.checkNotNull(jSONObject2);
                Intrinsics.checkNotNull(jSONArray);
                z5 = new Z5(jSONObject2, jSONArray, dbData);
            }
            if (z5 != null) {
                this.f2479a.add(z5);
            }
            return Unit.INSTANCE;
        }
        str = null;
        if (str != null) {
        }
        if (z5 != null) {
        }
        return Unit.INSTANCE;
    }
}
