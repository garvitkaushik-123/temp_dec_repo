package io.bidmachine.util.version;

import androidx.compose.material.OutlinedTextFieldKt;
import com.google.firebase.messaging.Constants;
import com.ironsource.C3040d4;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: VersionRange.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003J\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/version/VersionRange;", "", Constants.MessagePayloadKeys.FROM, "Lio/bidmachine/util/version/Version;", "to", "isInclusiveFrom", "", "isInclusiveTo", "(Lio/bidmachine/util/version/Version;Lio/bidmachine/util/version/Version;ZZ)V", "contains", "version", "equals", "other", "Companion", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class VersionRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Version from;
    private final boolean isInclusiveFrom;
    private final boolean isInclusiveTo;
    private final Version to;

    @JvmStatic
    public static final boolean isAfter(Version version, Version version2, boolean z) {
        return INSTANCE.isAfter(version, version2, z);
    }

    @JvmStatic
    public static final boolean isBefore(Version version, Version version2, boolean z) {
        return INSTANCE.isBefore(version, version2, z);
    }

    @JvmStatic
    public static final VersionRange parseVersionRange(String str) {
        return INSTANCE.parseVersionRange(str);
    }

    public VersionRange(Version version, Version version2, boolean z, boolean z2) {
        this.from = version;
        this.to = version2;
        this.isInclusiveFrom = z;
        this.isInclusiveTo = z2;
    }

    public final boolean contains(Version version) {
        Version version2;
        Intrinsics.checkNotNullParameter(version, "version");
        Version version3 = this.from;
        if (version3 != null && this.to != null) {
            Companion companion = INSTANCE;
            if (companion.isAfter(version3, version, this.isInclusiveFrom) && companion.isBefore(this.to, version, this.isInclusiveTo)) {
                return true;
            }
        }
        Version version4 = this.from;
        if (version4 != null && this.to == null && INSTANCE.isAfter(version4, version, this.isInclusiveFrom)) {
            return true;
        }
        if (this.from == null && (version2 = this.to) != null && INSTANCE.isBefore(version2, version, this.isInclusiveTo)) {
            return true;
        }
        return this.from == null && this.to == null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(getClass(), other.getClass())) {
            VersionRange versionRange = (VersionRange) other;
            if (this.isInclusiveFrom == versionRange.isInclusiveFrom && this.isInclusiveTo == versionRange.isInclusiveTo && Intrinsics.areEqual(this.from, versionRange.from) && Intrinsics.areEqual(this.to, versionRange.to)) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: VersionRange.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/version/VersionRange$Companion;", "", "()V", "isAfter", "", OutlinedTextFieldKt.BorderId, "Lio/bidmachine/util/version/Version;", "version", "isInclusive", "isBefore", "parseVersionRange", "Lio/bidmachine/util/version/VersionRange;", "versionRangeString", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:6:0x000e, B:11:0x002d, B:16:0x004e, B:18:0x0062, B:19:0x006a, B:21:0x0070, B:25:0x007f, B:26:0x008f, B:28:0x009c, B:30:0x00a4, B:34:0x00ab, B:37:0x008b, B:38:0x0040, B:39:0x0024), top: B:5:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009c A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:6:0x000e, B:11:0x002d, B:16:0x004e, B:18:0x0062, B:19:0x006a, B:21:0x0070, B:25:0x007f, B:26:0x008f, B:28:0x009c, B:30:0x00a4, B:34:0x00ab, B:37:0x008b, B:38:0x0040, B:39:0x0024), top: B:5:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ab A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:6:0x000e, B:11:0x002d, B:16:0x004e, B:18:0x0062, B:19:0x006a, B:21:0x0070, B:25:0x007f, B:26:0x008f, B:28:0x009c, B:30:0x00a4, B:34:0x00ab, B:37:0x008b, B:38:0x0040, B:39:0x0024), top: B:5:0x000e }] */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final VersionRange parseVersionRange(String versionRangeString) {
            boolean endsWith$default;
            List<String> split;
            List emptyList;
            String[] strArr;
            String str = versionRangeString;
            if (str != null && str.length() != 0) {
                try {
                    boolean startsWith$default = StringsKt.startsWith$default(versionRangeString, C3040d4.i.d, false, 2, (Object) null);
                    boolean startsWith$default2 = StringsKt.startsWith$default(versionRangeString, "(", false, 2, (Object) null);
                    if (!startsWith$default && !startsWith$default2) {
                        startsWith$default = true;
                        endsWith$default = StringsKt.endsWith$default(versionRangeString, C3040d4.i.e, false, 2, (Object) null);
                        boolean endsWith$default2 = StringsKt.endsWith$default(versionRangeString, ")", false, 2, (Object) null);
                        if (!endsWith$default && !endsWith$default2) {
                            endsWith$default = true;
                            split = new Regex("-").split(versionRangeString, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (listIterator.hasPrevious()) {
                                    if (listIterator.previous().length() != 0) {
                                        emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            emptyList = CollectionsKt.emptyList();
                            strArr = (String[]) emptyList.toArray(new String[0]);
                            if (strArr.length >= 2) {
                                Version parseVersion = Version.INSTANCE.parseVersion(versionRangeString);
                                if (parseVersion != null) {
                                    return new VersionRange(parseVersion, parseVersion, startsWith$default, endsWith$default);
                                }
                                return null;
                            }
                            return new VersionRange(Version.INSTANCE.parseVersion(strArr[0]), Version.INSTANCE.parseVersion(strArr[1]), startsWith$default, endsWith$default);
                        }
                        versionRangeString = versionRangeString.substring(0, versionRangeString.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(versionRangeString, "this as java.lang.String…ing(startIndex, endIndex)");
                        split = new Regex("-").split(versionRangeString, 0);
                        if (!split.isEmpty()) {
                        }
                        emptyList = CollectionsKt.emptyList();
                        strArr = (String[]) emptyList.toArray(new String[0]);
                        if (strArr.length >= 2) {
                        }
                    }
                    versionRangeString = versionRangeString.substring(1);
                    Intrinsics.checkNotNullExpressionValue(versionRangeString, "this as java.lang.String).substring(startIndex)");
                    endsWith$default = StringsKt.endsWith$default(versionRangeString, C3040d4.i.e, false, 2, (Object) null);
                    boolean endsWith$default22 = StringsKt.endsWith$default(versionRangeString, ")", false, 2, (Object) null);
                    if (!endsWith$default) {
                        endsWith$default = true;
                        split = new Regex("-").split(versionRangeString, 0);
                        if (!split.isEmpty()) {
                        }
                        emptyList = CollectionsKt.emptyList();
                        strArr = (String[]) emptyList.toArray(new String[0]);
                        if (strArr.length >= 2) {
                        }
                    }
                    versionRangeString = versionRangeString.substring(0, versionRangeString.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(versionRangeString, "this as java.lang.String…ing(startIndex, endIndex)");
                    split = new Regex("-").split(versionRangeString, 0);
                    if (!split.isEmpty()) {
                    }
                    emptyList = CollectionsKt.emptyList();
                    strArr = (String[]) emptyList.toArray(new String[0]);
                    if (strArr.length >= 2) {
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @JvmStatic
        public final boolean isAfter(Version border, Version version, boolean isInclusive) {
            Intrinsics.checkNotNullParameter(border, "border");
            Intrinsics.checkNotNullParameter(version, "version");
            if (isInclusive && version.isAfterOrEquals(border)) {
                return true;
            }
            return !isInclusive && version.isAfter(border);
        }

        @JvmStatic
        public final boolean isBefore(Version border, Version version, boolean isInclusive) {
            Intrinsics.checkNotNullParameter(border, "border");
            Intrinsics.checkNotNullParameter(version, "version");
            if (isInclusive && version.isBeforeOrEquals(border)) {
                return true;
            }
            return !isInclusive && version.isBefore(border);
        }
    }
}
