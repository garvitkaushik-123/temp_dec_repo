package io.bidmachine.models;

import io.bidmachine.models.RequestParams;

/* loaded from: classes7.dex */
public abstract class RequestParams<SelfType extends RequestParams<SelfType>> {
    public abstract void merge(SelfType instance);

    public static <T extends RequestParams<T>> T resolveParams(T primary, T secondary) {
        if (primary == null) {
            return secondary;
        }
        if (secondary != null) {
            primary.merge(secondary);
        }
        return primary;
    }
}
