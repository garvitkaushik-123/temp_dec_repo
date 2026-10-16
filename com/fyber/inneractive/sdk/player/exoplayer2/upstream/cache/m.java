package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class m extends g {
    public static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public m(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ee, code lost:
    
        if (r17.renameTo(r3) == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static m a(File file, i iVar) {
        File file2;
        String group;
        File file3;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = h.matcher(name2);
            if (matcher.matches()) {
                group = matcher.group(1);
                int i2 = z.f1599a;
                int length = group.length();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    if (group.charAt(i5) == '%') {
                        i4++;
                    }
                }
                if (i4 != 0) {
                    int i6 = length - (i4 * 2);
                    StringBuilder sb = new StringBuilder(i6);
                    Matcher matcher2 = z.g.matcher(group);
                    while (i4 > 0 && matcher2.find()) {
                        sb.append((CharSequence) group, i3, matcher2.start()).append((char) Integer.parseInt(matcher2.group(1), 16));
                        i3 = matcher2.end();
                        i4--;
                    }
                    if (i3 < length) {
                        sb.append((CharSequence) group, i3, length);
                    }
                    group = sb.length() != i6 ? null : sb.toString();
                }
            } else {
                matcher = g.matcher(name2);
                if (matcher.matches()) {
                    group = matcher.group(1);
                    File parentFile = file.getParentFile();
                    h hVar = (h) iVar.f1560a.get(group);
                    if (hVar == null) {
                        hVar = iVar.a(group, -1L);
                    }
                    file3 = new File(parentFile, hVar.f1559a + "." + Long.parseLong(matcher.group(2)) + "." + Long.parseLong(matcher.group(3)) + ".v3.exo");
                }
                file3 = null;
            }
            if (file3 == null) {
                return null;
            }
            name = file3.getName();
            file2 = file3;
        }
        Matcher matcher3 = i.matcher(name);
        if (!matcher3.matches()) {
            return null;
        }
        long length2 = file2.length();
        String str = (String) iVar.b.get(Integer.parseInt(matcher3.group(1)));
        if (str == null) {
            return null;
        }
        return new m(str, Long.parseLong(matcher3.group(2)), length2, Long.parseLong(matcher3.group(3)), file2);
    }
}
