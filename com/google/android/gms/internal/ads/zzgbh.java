package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgbh implements FilenameFilter {
    private final Pattern zza;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }

    public zzgbh(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }
}
