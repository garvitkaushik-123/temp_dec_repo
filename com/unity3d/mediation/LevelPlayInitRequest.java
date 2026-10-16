package com.unity3d.mediation;

import com.unity3d.mediation.LevelPlay;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class LevelPlayInitRequest {

    /* renamed from: a, reason: collision with root package name */
    private final String f6446a;
    private final String b;
    private final List<LevelPlay.AdFormat> c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final String f6447a;
        private String b;
        private List<? extends LevelPlay.AdFormat> c;

        public Builder(String appKey) {
            Intrinsics.checkNotNullParameter(appKey, "appKey");
            this.f6447a = appKey;
        }

        public final LevelPlayInitRequest build() {
            String str = this.f6447a;
            String str2 = this.b;
            List<? extends LevelPlay.AdFormat> list = this.c;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            return new LevelPlayInitRequest(str, str2, list, null);
        }

        public final String getAppKey() {
            return this.f6447a;
        }

        @Deprecated(message = "This method is deprecated and will be removed in version 9.0.0.")
        public final Builder withLegacyAdFormats(List<? extends LevelPlay.AdFormat> legacyAdFormats) {
            Intrinsics.checkNotNullParameter(legacyAdFormats, "legacyAdFormats");
            this.c = legacyAdFormats;
            return this;
        }

        public final Builder withUserId(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.b = userId;
            return this;
        }
    }

    public /* synthetic */ LevelPlayInitRequest(String str, String str2, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list);
    }

    public final String getAppKey() {
        return this.f6446a;
    }

    public final List<LevelPlay.AdFormat> getLegacyAdFormats() {
        return this.c;
    }

    public final String getUserId() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LevelPlayInitRequest(String str, String str2, List<? extends LevelPlay.AdFormat> list) {
        this.f6446a = str;
        this.b = str2;
        this.c = list;
    }
}
