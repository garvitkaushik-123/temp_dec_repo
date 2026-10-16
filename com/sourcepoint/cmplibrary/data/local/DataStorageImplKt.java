package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataStorageImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a!\u0010\u0011\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f¨\u0006\u0019"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage$Companion;", "context", "Landroid/content/Context;", "dsGdpr", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "dsCcpa", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "dsUsNat", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "getBoolean", "", "Landroid/content/SharedPreferences;", C3040d4.h.W, "", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Boolean;", "putBoolean", "", "value", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Boolean;)V", "putFloat", "", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Float;)V", "putString", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataStorageImplKt {
    public static final DataStorage create(DataStorage.Companion companion, Context context, DataStorageGdpr dsGdpr, DataStorageCcpa dsCcpa, DataStorageUSNat dsUsNat) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dsGdpr, "dsGdpr");
        Intrinsics.checkNotNullParameter(dsCcpa, "dsCcpa");
        Intrinsics.checkNotNullParameter(dsUsNat, "dsUsNat");
        return new DataStorageImpl(context, dsGdpr, dsCcpa, dsUsNat);
    }

    public static final Boolean getBoolean(SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (sharedPreferences.contains(key)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(key, false));
        }
        return null;
    }

    public static final void putFloat(SharedPreferences sharedPreferences, String key, Float f) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (f != null) {
            sharedPreferences.edit().putFloat(key, f.floatValue()).apply();
        } else {
            sharedPreferences.edit().remove(key).apply();
        }
    }

    public static final void putBoolean(SharedPreferences sharedPreferences, String key, Boolean bool) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (bool != null) {
            sharedPreferences.edit().putBoolean(key, bool.booleanValue()).apply();
        } else {
            sharedPreferences.edit().remove(key).apply();
        }
    }

    public static final void putString(SharedPreferences sharedPreferences, String key, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        sharedPreferences.edit().putString(key, str).apply();
    }
}
