package com.applovin.mediation;

import com.applovin.impl.mediation.MaxAdViewConfigurationImpl;

/* loaded from: classes2.dex */
public abstract class MaxAdViewConfiguration {

    public enum AdaptiveType {
        NONE("none"),
        ANCHORED("anchored"),
        INLINE("inline");


        /* renamed from: a, reason: collision with root package name */
        private final String f822a;

        AdaptiveType(String str) {
            this.f822a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f822a;
        }
    }

    public interface Builder {
        MaxAdViewConfiguration build();

        Builder setAdaptiveType(AdaptiveType adaptiveType);

        Builder setAdaptiveWidth(int i);

        Builder setInlineMaximumHeight(int i);
    }

    public static Builder builder() {
        return new MaxAdViewConfigurationImpl.BuilderImpl();
    }

    public abstract AdaptiveType getAdaptiveType();

    public abstract int getAdaptiveWidth();

    public abstract int getInlineMaximumHeight();
}
