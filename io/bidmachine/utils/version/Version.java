package io.bidmachine.utils.version;

import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes8.dex */
public class Version implements Comparable<Version> {
    private final int major;
    private final int minor;
    private final int patch;

    public Version(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && getClass() == object.getClass()) {
            Version version = (Version) object;
            if (this.major == version.major && this.minor == version.minor && this.patch == version.patch) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.patch));
    }

    public String toString() {
        return this.major + "." + this.minor + "." + this.patch;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        int compare = Integer.compare(this.major, version.major);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.minor, version.minor);
        return compare2 != 0 ? compare2 : Integer.compare(this.patch, version.patch);
    }

    public boolean isAfter(Version version) {
        return compareTo(version) > 0;
    }

    public boolean isAfterOrEquals(Version version) {
        return compareTo(version) >= 0;
    }

    public boolean isBefore(Version version) {
        return compareTo(version) < 0;
    }

    public boolean isBeforeOrEquals(Version version) {
        return compareTo(version) <= 0;
    }

    public static Version parseVersion(String versionString) {
        if (TextUtils.isEmpty(versionString)) {
            return null;
        }
        try {
            String[] split = versionString.split("\\.");
            if (split.length == 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < split.length; i4++) {
                if (i4 == 0) {
                    i = Integer.parseInt(split[0]);
                } else if (i4 == 1) {
                    i2 = Integer.parseInt(split[1]);
                } else if (i4 == 2) {
                    i3 = Integer.parseInt(split[2]);
                } else {
                    i3 = (i3 * 100) + Integer.parseInt(split[i4]);
                }
            }
            return new Version(i, i2, i3);
        } catch (Throwable unused) {
            return null;
        }
    }
}
