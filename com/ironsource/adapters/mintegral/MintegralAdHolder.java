package com.ironsource.adapters.mintegral;

import androidx.exifinterface.media.ExifInterface;
import com.ironsource.C3040d4;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MintegralAdHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0015\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralAdHolder;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "mintegralAds", "", "Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "getAdapters", "", "removeAd", "", C3040d4.h.W, "retrieveAd", "(Lcom/ironsource/adapters/mintegral/MintegralAdapter;)Ljava/lang/Object;", "storeAd", "value", "(Lcom/ironsource/adapters/mintegral/MintegralAdapter;Ljava/lang/Object;)V", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MintegralAdHolder<V> {
    private final Map<MintegralAdapter, V> mintegralAds;

    public MintegralAdHolder() {
        Map<MintegralAdapter, V> synchronizedMap = Collections.synchronizedMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(WeakHashMap())");
        this.mintegralAds = synchronizedMap;
    }

    public final void storeAd(MintegralAdapter key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mintegralAds.put(key, value);
    }

    public final V retrieveAd(MintegralAdapter key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mintegralAds.get(key);
    }

    public final void removeAd(MintegralAdapter key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mintegralAds.remove(key);
    }

    public final Set<MintegralAdapter> getAdapters() {
        return this.mintegralAds.keySet();
    }
}
