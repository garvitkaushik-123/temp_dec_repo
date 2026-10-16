package io.bidmachine.utils.version;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.Objects;

/* loaded from: classes8.dex */
public class VersionRange {
    private final Version from;
    private final boolean isInclusiveFrom;
    private final boolean isInclusiveTo;
    private final Version to;

    public VersionRange(Version from, Version to, boolean isInclusiveFrom, boolean isInclusiveTo) {
        this.from = from;
        this.to = to;
        this.isInclusiveFrom = isInclusiveFrom;
        this.isInclusiveTo = isInclusiveTo;
    }

    public boolean contains(Version version) {
        Version version2;
        Version version3 = this.from;
        if (version3 != null && this.to != null && isAfter(version3, version, this.isInclusiveFrom) && isBefore(this.to, version, this.isInclusiveTo)) {
            return true;
        }
        Version version4 = this.from;
        if (version4 != null && this.to == null && isAfter(version4, version, this.isInclusiveFrom)) {
            return true;
        }
        if (this.from == null && (version2 = this.to) != null && isBefore(version2, version, this.isInclusiveTo)) {
            return true;
        }
        return this.from == null && this.to == null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && getClass() == object.getClass()) {
            VersionRange versionRange = (VersionRange) object;
            if (this.isInclusiveFrom == versionRange.isInclusiveFrom && this.isInclusiveTo == versionRange.isInclusiveTo && Objects.equals(this.from, versionRange.from) && Objects.equals(this.to, versionRange.to)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:6:0x0008, B:11:0x0020, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x0054, B:25:0x0034, B:26:0x001c), top: B:5:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:6:0x0008, B:11:0x0020, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x0054, B:25:0x0034, B:26:0x001c), top: B:5:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VersionRange parseVersionRange(String versionRangeString) {
        boolean endsWith;
        String[] split;
        if (TextUtils.isEmpty(versionRangeString)) {
            return null;
        }
        try {
            boolean startsWith = versionRangeString.startsWith(C3040d4.i.d);
            boolean startsWith2 = versionRangeString.startsWith("(");
            if (!startsWith && !startsWith2) {
                startsWith = true;
                endsWith = versionRangeString.endsWith(C3040d4.i.e);
                boolean endsWith2 = versionRangeString.endsWith(")");
                if (!endsWith && !endsWith2) {
                    endsWith = true;
                    split = versionRangeString.split("-");
                    if (split.length >= 2) {
                        Version parseVersion = Version.parseVersion(versionRangeString);
                        if (parseVersion != null) {
                            return new VersionRange(parseVersion, parseVersion, startsWith, endsWith);
                        }
                        return null;
                    }
                    return new VersionRange(Version.parseVersion(split[0]), Version.parseVersion(split[1]), startsWith, endsWith);
                }
                versionRangeString = versionRangeString.substring(0, versionRangeString.length() - 1);
                split = versionRangeString.split("-");
                if (split.length >= 2) {
                }
            }
            versionRangeString = versionRangeString.substring(1);
            endsWith = versionRangeString.endsWith(C3040d4.i.e);
            boolean endsWith22 = versionRangeString.endsWith(")");
            if (!endsWith) {
                endsWith = true;
                split = versionRangeString.split("-");
                if (split.length >= 2) {
                }
            }
            versionRangeString = versionRangeString.substring(0, versionRangeString.length() - 1);
            split = versionRangeString.split("-");
            if (split.length >= 2) {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean isAfter(Version border, Version version, boolean isInclusive) {
        if (isInclusive && version.isAfterOrEquals(border)) {
            return true;
        }
        return !isInclusive && version.isAfter(border);
    }

    static boolean isBefore(Version border, Version version, boolean isInclusive) {
        if (isInclusive && version.isBeforeOrEquals(border)) {
            return true;
        }
        return !isInclusive && version.isBefore(border);
    }
}
