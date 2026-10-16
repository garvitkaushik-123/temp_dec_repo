package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.MediaItem;
import com.facebook.ads.androidx.media3.common.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2u, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C06852u {
    public static String[] A0B = {"HPaW60WB4gFqlzK247iq3uDphWK03Iif", "KBvaSaTKxPBSHh58MHpb5CG0KegQKkr9", "b1r5E5Hd4zdNoyuaEQVQsO4l4ctoImRB", "nKy6zg3qdMWmj624cOZmm65wxaqanW8E", "pbs", "7xj4kZWUPnGFCehZwFfpDVbkpfFBWPXP", "TYkILCf2Xs5AkCVGSR3QMYIpsRVtVxUs", "J3EyGmSR6mO6g6CSn2CxG4G4HI4UvZHg"};
    public Uri A00;
    public C2473q2 A04;
    public Object A05;
    public String A06;
    public String A07;
    public String A08;
    public C06862v A01 = new C06862v();
    public C06882x A02 = new C06882x();
    public List<StreamKey> A09 = Collections.emptyList();
    public List<MediaItem.SubtitleConfiguration> A0A = Collections.emptyList();
    public AnonymousClass30 A03 = new AnonymousClass30();

    public final C06852u A00(Uri uri) {
        this.A00 = uri;
        return this;
    }

    public final C06852u A01(Object obj) {
        this.A05 = obj;
        return this;
    }

    public final C06852u A02(String str) {
        this.A06 = str;
        return this;
    }

    public final C06852u A03(String str) {
        this.A07 = (String) AbstractC07133y.A01(str);
        return this;
    }

    public final C06852u A04(List<StreamKey> list) {
        List<StreamKey> emptyList;
        if (list != null) {
            boolean isEmpty = list.isEmpty();
            String[] strArr = A0B;
            if (strArr[1].charAt(26) == strArr[2].charAt(26)) {
                throw new RuntimeException();
            }
            A0B[3] = "MqTMGNvSZ5CI9kiBQqDgyIk0OkVIIG8t";
            if (!isEmpty) {
                emptyList = Collections.unmodifiableList(new ArrayList(list));
                this.A09 = emptyList;
                return this;
            }
        }
        emptyList = Collections.emptyList();
        this.A09 = emptyList;
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.facebook.ads.redexgen.X.q9.<init>(android.net.Uri, java.lang.String, com.facebook.ads.redexgen.X.2y, com.facebook.ads.redexgen.X.2t, java.util.List, java.lang.String, java.util.List, java.lang.Object, com.facebook.ads.redexgen.X.2r):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.instagram.common.viewpoint.core.C2478q7 A05() {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.2x r0 = r11.A02
            android.net.Uri r0 = com.instagram.common.viewpoint.core.C06882x.A00(r0)
            if (r0 == 0) goto L26
            com.facebook.ads.redexgen.X.2x r3 = r11.A02
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C06852u.A0B
            r0 = 3
            r1 = r1[r0]
            r0 = 22
            char r1 = r1.charAt(r0)
            r0 = 49
            if (r1 == r0) goto L78
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C06852u.A0B
            java.lang.String r1 = "LsaTJZF6o4X1Tfg01qMfqEHPxyZhwdJj"
            r0 = 5
            r2[r0] = r1
            java.util.UUID r0 = com.instagram.common.viewpoint.core.C06882x.A03(r3)
            if (r0 == 0) goto L76
        L26:
            r0 = 1
        L27:
            com.instagram.common.viewpoint.core.AbstractC07133y.A08(r0)
            r1 = 0
            android.net.Uri r2 = r11.A00
            if (r2 == 0) goto L4e
            com.facebook.ads.redexgen.X.q9 r1 = new com.facebook.ads.redexgen.X.q9
            java.lang.String r3 = r11.A08
            com.facebook.ads.redexgen.X.2x r0 = r11.A02
            java.util.UUID r0 = com.instagram.common.viewpoint.core.C06882x.A03(r0)
            if (r0 == 0) goto L74
            com.facebook.ads.redexgen.X.2x r0 = r11.A02
            com.facebook.ads.redexgen.X.2y r4 = r0.A08()
        L41:
            r5 = 0
            java.util.List<com.facebook.ads.androidx.media3.common.StreamKey> r6 = r11.A09
            java.lang.String r7 = r11.A06
            java.util.List<com.facebook.ads.androidx.media3.common.MediaItem$SubtitleConfiguration> r8 = r11.A0A
            java.lang.Object r9 = r11.A05
            r10 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
        L4e:
            com.facebook.ads.redexgen.X.q7 r2 = new com.facebook.ads.redexgen.X.q7
            java.lang.String r0 = r11.A07
            if (r0 == 0) goto L71
            java.lang.String r3 = r11.A07
        L56:
            com.facebook.ads.redexgen.X.2v r0 = r11.A01
            com.facebook.ads.redexgen.X.AW r4 = r0.A0B()
            com.facebook.ads.redexgen.X.30 r0 = r11.A03
            com.facebook.ads.redexgen.X.qA r6 = r0.A05()
            com.facebook.ads.redexgen.X.q2 r0 = r11.A04
            if (r0 == 0) goto L6e
            com.facebook.ads.redexgen.X.q2 r7 = r11.A04
        L68:
            r8 = 0
            r5 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        L6e:
            com.facebook.ads.redexgen.X.q2 r7 = com.instagram.common.viewpoint.core.C2473q2.A0Z
            goto L68
        L71:
            java.lang.String r3 = ""
            goto L56
        L74:
            r4 = 0
            goto L41
        L76:
            r0 = 0
            goto L27
        L78:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C06852u.A05():com.facebook.ads.redexgen.X.q7");
    }
}
