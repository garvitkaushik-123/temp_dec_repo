package com.fyber.inneractive.sdk.bidder;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.Topic;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.v0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.protobuf.y0;
import com.fyber.inneractive.sdk.protobuf.z0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q1;
import com.fyber.inneractive.sdk.util.x0;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b implements e, v0, com.fyber.inneractive.sdk.config.cellular.h {
    public static final b h = new b();

    /* renamed from: a, reason: collision with root package name */
    public final k f1030a;
    public final com.fyber.inneractive.sdk.serverapi.c b;
    public final d c;
    public f d;
    public final AtomicReference e = new AtomicReference(null);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final Object g = new Object();

    public b() {
        com.fyber.inneractive.sdk.config.cellular.a aVar;
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(com.fyber.inneractive.sdk.config.global.r.a());
        this.b = cVar;
        d dVar = new d(cVar);
        this.c = dVar;
        this.f1030a = TokenParametersOuterClass$TokenParameters.newBuilder();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        iAConfigManager.x.d = this;
        if (iAConfigManager.u.b.a(true, "bidding_token_wait_for_ua")) {
            q1 q1Var = iAConfigManager.y;
            q1Var.b();
            if (!q1Var.d.get()) {
                q1Var.c();
            }
            dVar.b = iAConfigManager.y.a();
        }
        if (!InneractiveAdManager.isCurrentUserAChild() && (aVar = iAConfigManager.N) != null) {
            try {
                aVar.c.add(this);
            } catch (Throwable th) {
                IAlog.a("failed to add network observer", th, new Object[0]);
            }
        }
        f fVar = new f(this);
        this.d = fVar;
        fVar.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x058f, code lost:
    
        if (r3.equals("2") == false) goto L111;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a() {
        JSONArray jSONArray;
        ?? r10;
        ?? r12;
        r0 r0Var;
        char c;
        char c2;
        l0 l0Var;
        String str;
        k kVar = this.f1030a;
        kVar.b = (z0) kVar.b.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
        k kVar2 = this.f1030a;
        this.c.getClass();
        TokenParametersOuterClass$TokenParameters.NullableString a2 = h.a("1.2");
        kVar2.c();
        ((TokenParametersOuterClass$TokenParameters) kVar2.b).setVersion(a2);
        if (this.e.get() != null) {
            this.c.a();
        }
        k kVar3 = this.f1030a;
        TokenParametersOuterClass$TokenParameters.NullableString a3 = h.a(this.c.b);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setUserAgent(a3);
        TokenParametersOuterClass$TokenParameters.NullableString a4 = h.a(this.c.c);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setSdkVersion(a4);
        TokenParametersOuterClass$TokenParameters.NullableString a5 = h.a(this.c.d);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setBundleID(a5);
        TokenParametersOuterClass$TokenParameters.NullableString a6 = h.a(this.c.e);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceModel(a6);
        TokenParametersOuterClass$TokenParameters.NullableString a7 = h.a(this.c.f);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setAppVersion(a7);
        TokenParametersOuterClass$TokenParameters.NullableString a8 = h.a(C3040d4.d);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceOS(a8);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 a9 = h.a(Build.VERSION.SDK_INT);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceApi(a9);
        TokenParametersOuterClass$TokenParameters.NullableString a10 = h.a(Build.VERSION.RELEASE);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOsVersion(a10);
        TokenParametersOuterClass$TokenParameters.NullableString a11 = h.a(this.c.g);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceLanguage(a11);
        TokenParametersOuterClass$TokenParameters.NullableString a12 = h.a(this.c.h);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setCountryCode(a12);
        TokenParametersOuterClass$TokenParameters.NullableString a13 = h.a(this.c.i);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setCarrierName(a13);
        TokenParametersOuterClass$TokenParameters.NullableString a14 = h.a(this.c.j);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMobileCountryCode(a14);
        TokenParametersOuterClass$TokenParameters.NullableString a15 = h.a(this.c.k);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMobileNetworkCode(a15);
        Long l = this.c.l;
        x newBuilder = TokenParametersOuterClass$TokenParameters.NullableSInt32.newBuilder();
        if (l != null) {
            int intValue = l.intValue();
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableSInt32) newBuilder.b).setData(intValue);
        }
        TokenParametersOuterClass$TokenParameters.NullableSInt32 nullableSInt32 = (TokenParametersOuterClass$TokenParameters.NullableSInt32) newBuilder.a();
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOffsetFromGMT(nullableSInt32);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        TokenParametersOuterClass$TokenParameters.NullableString a16 = h.a(iAConfigManager.D.g);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setUserID(a16);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 a17 = h.a(this.c.m);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceWidth(a17);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 a18 = h.a(this.c.n);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceHeight(a18);
        q qVar = this.c.o;
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setFrameworkName(qVar);
        TokenParametersOuterClass$TokenParameters.NullableString a19 = h.a(this.c.p);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setInputLanguages(a19);
        TokenParametersOuterClass$TokenParameters.NullableString a20 = h.a(this.c.H);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMediationType(a20);
        this.c.getClass();
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        TokenParametersOuterClass$TokenParameters.NullableString a21 = h.a(lVar != null ? lVar.getOdt() : "");
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOdt(a21);
        Integer a22 = com.fyber.inneractive.sdk.serverapi.b.a();
        z newBuilder2 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (a22 != null) {
            int intValue2 = a22.intValue();
            newBuilder2.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder2.b).setData(intValue2);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder2.a();
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setAdServicesVersion(nullableUInt32);
        com.fyber.inneractive.sdk.config.g gVar = iAConfigManager.D;
        if (gVar != null) {
            k kVar4 = this.f1030a;
            if (gVar.d == null) {
                gVar.e = gVar.h();
            }
            if (com.fyber.inneractive.sdk.util.o.f1770a == null) {
                str = null;
            } else {
                str = gVar.d;
                if (str == null) {
                    str = gVar.e;
                }
            }
            TokenParametersOuterClass$TokenParameters.NullableString a23 = h.a(str);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setGdprString(a23);
            TokenParametersOuterClass$TokenParameters.NullableBool a24 = h.a(gVar.d());
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setGdprConsent(a24);
            TokenParametersOuterClass$TokenParameters.NullableString a25 = h.a(com.fyber.inneractive.sdk.util.o.f1770a == null ? null : gVar.h);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setCcpaString(a25);
            TokenParametersOuterClass$TokenParameters.NullableBool a26 = h.a(com.fyber.inneractive.sdk.util.o.f1770a == null ? null : gVar.i);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setLgpdConsent(a26);
            Boolean bool = gVar.j;
            if (bool != null && bool.booleanValue()) {
                k kVar5 = this.f1030a;
                TokenParametersOuterClass$TokenParameters.NullableBool a27 = h.a(bool);
                kVar5.c();
                ((TokenParametersOuterClass$TokenParameters) kVar5.b).setCoppaApplies(a27);
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            k kVar6 = this.f1030a;
            com.fyber.inneractive.sdk.config.v vVar = com.fyber.inneractive.sdk.config.u.f1127a.b;
            boolean z = vVar != null ? vVar.b : false;
            kVar6.c();
            ((TokenParametersOuterClass$TokenParameters) kVar6.b).setDnt(z);
        }
        k kVar7 = this.f1030a;
        TokenParametersOuterClass$TokenParameters.NullableString a28 = h.a(this.c.q);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setNetwork(a28);
        d0 d0Var = this.c.r;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setSecureContent(d0Var);
        TokenParametersOuterClass$TokenParameters.NullableBool a29 = h.a(this.c.B);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBatteryCharging(a29);
        TokenParametersOuterClass$TokenParameters.NullableBool a30 = h.a(this.c.s);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setHeadsetPlugged(a30);
        TokenParametersOuterClass$TokenParameters.NullableBool a31 = h.a(this.c.t);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBluetoothPlugged(a31);
        TokenParametersOuterClass$TokenParameters.NullableBool a32 = h.a(this.c.u);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setLowPowerMode(a32);
        boolean z2 = this.c.v;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setDarkMode(z2);
        TokenParametersOuterClass$TokenParameters.NullableBool a33 = h.a(this.c.w);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setAirplaneMode(a33);
        TokenParametersOuterClass$TokenParameters.NullableBool a34 = h.a(this.c.x);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setDndMode(a34);
        TokenParametersOuterClass$TokenParameters.NullableBool a35 = h.a(this.c.y);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setIsRingMuted(a35);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 a36 = h.a(this.c.z);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setSessionDuration(a36);
        String str2 = this.c.C;
        z newBuilder3 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (!TextUtils.isEmpty(str2)) {
            int parseInt = Integer.parseInt(str2);
            newBuilder3.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder3.b).setData(parseInt);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt322 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder3.a();
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBatteryLevel(nullableUInt322);
        TokenParametersOuterClass$TokenParameters.NullableBool a37 = h.a(Boolean.valueOf(TextUtils.equals(iAConfigManager.x.a(UnitDisplayType.INTERSTITIAL, "LAST_VAST_SKIPED"), "1")));
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setPriorSkip(a37);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 a38 = h.a(this.c.D);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setUserAge(a38);
        InneractiveUserConfig.Gender gender = this.c.E;
        n0 n0Var = gender == InneractiveUserConfig.Gender.FEMALE ? n0.FEMALE : gender == InneractiveUserConfig.Gender.MALE ? n0.MALE : n0.UNKNOWN;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setUserGender(n0Var);
        TokenParametersOuterClass$TokenParameters.NullableString a39 = h.a(this.c.G);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setZipCode(a39);
        boolean z3 = this.c.F;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setMuteAudio(z3);
        TokenParametersOuterClass$TokenParameters.NullableBool a40 = h.a(this.c.L);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setMediaMuted(a40);
        com.fyber.inneractive.sdk.config.v vVar2 = com.fyber.inneractive.sdk.config.u.f1127a.b;
        if (vVar2 != null ? vVar2.c : false) {
            k kVar8 = this.f1030a;
            TokenParametersOuterClass$TokenParameters.NullableString a41 = h.a(this.c.A);
            kVar8.c();
            ((TokenParametersOuterClass$TokenParameters) kVar8.b).setAmazonId(a41);
        } else {
            k kVar9 = this.f1030a;
            TokenParametersOuterClass$TokenParameters.NullableString a42 = h.a(this.c.A);
            kVar9.c();
            ((TokenParametersOuterClass$TokenParameters) kVar9.b).setAaid(a42);
        }
        UnitDisplayType[] values = UnitDisplayType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            boolean z4 = true;
            if (i >= length) {
                com.fyber.inneractive.sdk.serverapi.c cVar = this.b;
                cVar.getClass();
                com.fyber.inneractive.sdk.config.global.r a43 = com.fyber.inneractive.sdk.config.global.r.a();
                cVar.f1731a = a43;
                a43.a(false, "");
                com.fyber.inneractive.sdk.config.global.r rVar = this.b.f1731a;
                if (rVar != null) {
                    jSONArray = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                    IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArray);
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            n newBuilder4 = TokenParametersOuterClass$TokenParameters.Experiment.newBuilder();
                            String optString = optJSONObject.optString("id");
                            newBuilder4.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) newBuilder4.b).setIdentifier(optString);
                            String optString2 = optJSONObject.optString("v");
                            newBuilder4.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) newBuilder4.b).setVariant(optString2);
                            k kVar10 = this.f1030a;
                            TokenParametersOuterClass$TokenParameters.Experiment experiment = (TokenParametersOuterClass$TokenParameters.Experiment) newBuilder4.a();
                            kVar10.c();
                            ((TokenParametersOuterClass$TokenParameters) kVar10.b).addAbExperiments(experiment);
                        }
                    }
                }
                k kVar11 = this.f1030a;
                int i3 = com.fyber.inneractive.sdk.config.k.f1102a;
                String property = System.getProperty("ia.testEnvironmentConfiguration.number");
                z newBuilder5 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
                if (!TextUtils.isEmpty(property)) {
                    int parseInt2 = Integer.parseInt(property);
                    newBuilder5.c();
                    ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder5.b).setData(parseInt2);
                }
                TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt323 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder5.a();
                kVar11.c();
                ((TokenParametersOuterClass$TokenParameters) kVar11.b).setPortal(nullableUInt323);
                k kVar12 = this.f1030a;
                TokenParametersOuterClass$TokenParameters.NullableString a44 = h.a(System.getProperty("ia.testEnvironmentConfiguration.response"));
                kVar12.c();
                ((TokenParametersOuterClass$TokenParameters) kVar12.b).setMockResponseId(a44);
                k kVar13 = this.f1030a;
                TokenParametersOuterClass$TokenParameters.NullableString a45 = h.a(this.c.I);
                kVar13.c();
                ((TokenParametersOuterClass$TokenParameters) kVar13.b).setIgniteVersion(a45);
                k kVar14 = this.f1030a;
                TokenParametersOuterClass$TokenParameters.NullableString a46 = h.a(this.c.J);
                kVar14.c();
                ((TokenParametersOuterClass$TokenParameters) kVar14.b).setIgnitePackageName(a46);
                if (this.c.K) {
                    k kVar15 = this.f1030a;
                    TokenParametersOuterClass$TokenParameters.NullableBool a47 = h.a(Boolean.TRUE);
                    kVar15.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar15.b).setChildMode(a47);
                }
                ArrayList arrayList = this.c.M;
                if (IAConfigManager.c() && arrayList != null && !arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        EncryptedTopic encryptedTopic = (EncryptedTopic) it.next();
                        l newBuilder6 = TokenParametersOuterClass$TokenParameters.EncryptedTopic.newBuilder();
                        byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
                        com.fyber.inneractive.sdk.protobuf.q qVar2 = com.fyber.inneractive.sdk.protobuf.s.b;
                        int length2 = encryptedTopic2.length;
                        com.fyber.inneractive.sdk.protobuf.s.a(0, length2, encryptedTopic2.length);
                        com.fyber.inneractive.sdk.protobuf.o oVar = com.fyber.inneractive.sdk.protobuf.s.c;
                        com.fyber.inneractive.sdk.protobuf.q qVar3 = new com.fyber.inneractive.sdk.protobuf.q(oVar.a(encryptedTopic2, 0, length2));
                        newBuilder6.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) newBuilder6.b).setEncryptedTopic(qVar3);
                        String keyIdentifier = encryptedTopic.getKeyIdentifier();
                        newBuilder6.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) newBuilder6.b).setKeyIdentifier(keyIdentifier);
                        byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
                        int length3 = encapsulatedKey.length;
                        com.fyber.inneractive.sdk.protobuf.s.a(0, length3, encapsulatedKey.length);
                        com.fyber.inneractive.sdk.protobuf.q qVar4 = new com.fyber.inneractive.sdk.protobuf.q(oVar.a(encapsulatedKey, 0, length3));
                        newBuilder6.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) newBuilder6.b).setEncapsulatedKey(qVar4);
                        TokenParametersOuterClass$TokenParameters.EncryptedTopic encryptedTopic3 = (TokenParametersOuterClass$TokenParameters.EncryptedTopic) newBuilder6.a();
                        k kVar16 = this.f1030a;
                        kVar16.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar16.b).addEncryptedTopics(encryptedTopic3);
                    }
                }
                ArrayList arrayList2 = this.c.N;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        Topic topic = (Topic) it2.next();
                        g0 newBuilder7 = TokenParametersOuterClass$TokenParameters.Topic.newBuilder();
                        int topicId = topic.getTopicId();
                        newBuilder7.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) newBuilder7.b).setTopicId(topicId);
                        long modelVersion = topic.getModelVersion();
                        newBuilder7.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) newBuilder7.b).setModelVersion(modelVersion);
                        long taxonomyVersion = topic.getTaxonomyVersion();
                        newBuilder7.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) newBuilder7.b).setTaxonomyVersion(taxonomyVersion);
                        TokenParametersOuterClass$TokenParameters.Topic topic2 = (TokenParametersOuterClass$TokenParameters.Topic) newBuilder7.a();
                        k kVar17 = this.f1030a;
                        kVar17.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar17.b).addTopics(topic2);
                    }
                }
                return ((TokenParametersOuterClass$TokenParameters) this.f1030a.a()).toByteArray();
            }
            UnitDisplayType unitDisplayType = values[i];
            if (!unitDisplayType.isDeprecated()) {
                int[] iArr = g.f1034a;
                int i4 = iArr[unitDisplayType.ordinal()];
                l0 l0Var2 = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? l0.UNITDISPLAYTYPEUNKNOWN : l0.MRECT : l0.REWARDED : l0.INTERSTITIAL : l0.BANNER;
                com.fyber.inneractive.sdk.serverapi.a aVar = com.fyber.inneractive.sdk.serverapi.b.f1730a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                String a48 = iAConfigManager2.x.a(unitDisplayType, "LAST_DOMAIN_SHOWED");
                if (!TextUtils.isEmpty(a48) && a48.contains(",")) {
                    a48 = a48.split(",")[0];
                }
                if (!TextUtils.isEmpty(a48)) {
                    k kVar18 = this.f1030a;
                    r newBuilder8 = TokenParametersOuterClass$TokenParameters.LastAdomain.newBuilder();
                    newBuilder8.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) newBuilder8.b).setAdomain(a48);
                    newBuilder8.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) newBuilder8.b).setType(l0Var2);
                    TokenParametersOuterClass$TokenParameters.LastAdomain lastAdomain = (TokenParametersOuterClass$TokenParameters.LastAdomain) newBuilder8.a();
                    kVar18.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar18.b).addLastAdomains(lastAdomain);
                }
                String a49 = iAConfigManager2.x.a(unitDisplayType, "LAST_APP_BUNDLE_ID");
                if (!TextUtils.isEmpty(a49)) {
                    k kVar19 = this.f1030a;
                    t newBuilder9 = TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.newBuilder();
                    newBuilder9.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) newBuilder9.b).setLastBundle(a49);
                    newBuilder9.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) newBuilder9.b).setType(l0Var2);
                    TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle lastAdvertisedBundle = (TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) newBuilder9.a();
                    kVar19.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar19.b).addLastAdvertisedBundles(lastAdvertisedBundle);
                }
                if (TextUtils.equals(iAConfigManager2.x.a(unitDisplayType, "LAST_CLICKED"), "1")) {
                    k kVar20 = this.f1030a;
                    int i5 = iArr[unitDisplayType.ordinal()];
                    if (i5 == 1) {
                        c = 3;
                        c2 = 4;
                        l0Var = l0.BANNER;
                    } else if (i5 != 2) {
                        c = 3;
                        c = 3;
                        c = 3;
                        if (i5 != 3) {
                            c2 = 4;
                            c2 = 4;
                            l0Var = i5 != 4 ? l0.UNITDISPLAYTYPEUNKNOWN : l0.MRECT;
                        } else {
                            c2 = 4;
                            l0Var = l0.REWARDED;
                        }
                    } else {
                        c = 3;
                        c2 = 4;
                        l0Var = l0.INTERSTITIAL;
                    }
                    kVar20.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar20.b).addPriorClicks(l0Var);
                    r10 = c;
                    r12 = c2;
                } else {
                    r10 = 3;
                    r12 = 4;
                }
                a("display", unitDisplayType, l0Var2);
                if (unitDisplayType.isFullscreenUnit()) {
                    a("video", unitDisplayType, l0Var2);
                    String a50 = iAConfigManager2.x.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                    if (!TextUtils.isEmpty(a50)) {
                        k kVar21 = this.f1030a;
                        a0 newBuilder10 = TokenParametersOuterClass$TokenParameters.PriorVideoClickType.newBuilder();
                        a50.getClass();
                        a50.hashCode();
                        switch (a50.hashCode()) {
                            case 49:
                                if (a50.equals("1")) {
                                    z4 = false;
                                    break;
                                }
                                z4 = -1;
                                break;
                            case 50:
                                break;
                            case 51:
                                if (a50.equals("3")) {
                                    z4 = 2;
                                    break;
                                }
                                z4 = -1;
                                break;
                            case 52:
                                if (a50.equals("4")) {
                                    z4 = r10;
                                    break;
                                }
                                z4 = -1;
                                break;
                            case 53:
                                if (a50.equals(CampaignEx.CLICKMODE_ON)) {
                                    z4 = r12;
                                    break;
                                }
                                z4 = -1;
                                break;
                            default:
                                z4 = -1;
                                break;
                        }
                        switch (z4) {
                            case false:
                                r0Var = r0.CTABUTTON;
                                break;
                            case true:
                                r0Var = r0.COMPANION;
                                break;
                            case true:
                                r0Var = r0.VIDEOVIEW;
                                break;
                            case true:
                                r0Var = r0.APPINFO;
                                break;
                            case true:
                                r0Var = r0.STOREPROMO;
                                break;
                            default:
                                r0Var = r0.NOCLICK;
                                break;
                        }
                        newBuilder10.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) newBuilder10.b).setClickType(r0Var);
                        newBuilder10.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) newBuilder10.b).setType(l0Var2);
                        TokenParametersOuterClass$TokenParameters.PriorVideoClickType priorVideoClickType = (TokenParametersOuterClass$TokenParameters.PriorVideoClickType) newBuilder10.a();
                        kVar21.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar21.b).addPriorClickTypes(priorVideoClickType);
                    }
                }
            }
            i++;
        }
    }

    public final void b() {
        if (this.f.compareAndSet(false, true)) {
            try {
                this.e.set(Base64.encodeToString(a(), 2));
            } catch (Throwable th) {
                IAlog.b("Failed to generate token with error: %s", th.getMessage());
            }
            this.f.set(false);
        }
    }

    public final void c() {
        int currentInterruptionFilter = ((NotificationManager) com.fyber.inneractive.sdk.util.o.f1770a.getSystemService("notification")).getCurrentInterruptionFilter();
        boolean z = currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4;
        Boolean bool = this.c.x;
        if (bool == null || bool.booleanValue() != z) {
            this.c.x = Boolean.valueOf(z);
            d();
        }
    }

    public final void d() {
        com.fyber.inneractive.sdk.util.r.f1777a.execute(new a(this));
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(x0 x0Var) {
        if (TextUtils.equals(this.c.q, x0Var.b())) {
            return;
        }
        this.c.q = x0Var.b();
        d();
    }

    public final void a(String str, UnitDisplayType unitDisplayType, l0 l0Var) {
        ArrayList arrayList;
        int i;
        j0 j0Var;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.cache.session.e eVar = iAConfigManager.x.f1132a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.cache.session.k kVar = (com.fyber.inneractive.sdk.cache.session.k) eVar.b.get(com.fyber.inneractive.sdk.cache.session.enums.c.a(unitDisplayType.value(), str));
            TokenParametersOuterClass$TokenParameters.UserSession userSession = null;
            if (kVar != null) {
                ArrayList arrayList2 = new ArrayList(kVar);
                Collections.sort(arrayList2, new com.fyber.inneractive.sdk.cache.session.j());
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = null;
            }
            try {
                i = Integer.parseInt(iAConfigManager.u.b.a("number_of_sessions", Integer.toString(5)));
            } catch (Throwable unused) {
                i = 5;
            }
            int i2 = i >= 0 ? i : 5;
            if (i2 > 0 && arrayList != null && arrayList.size() >= i2) {
                if (str.equals("video")) {
                    j0Var = j0.VIDEO;
                } else if (!str.equals("display")) {
                    j0Var = j0.UNITCONTENTTYPEUNKNOWN;
                } else {
                    j0Var = j0.DISPLAY;
                }
                o0 newBuilder = TokenParametersOuterClass$TokenParameters.UserSession.newBuilder();
                newBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) newBuilder.b).setSubType(j0Var);
                Iterator it = arrayList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    com.fyber.inneractive.sdk.cache.session.g gVar = (com.fyber.inneractive.sdk.cache.session.g) it.next();
                    e0 newBuilder2 = TokenParametersOuterClass$TokenParameters.SessionData.newBuilder();
                    int i4 = gVar.b;
                    newBuilder2.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) newBuilder2.b).setClicks(i4);
                    int i5 = gVar.f1053a;
                    newBuilder2.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) newBuilder2.b).setImpressions(i5);
                    if (str.equals("video") || l0Var.equals(l0.REWARDED)) {
                        int i6 = gVar.c;
                        newBuilder2.c();
                        ((TokenParametersOuterClass$TokenParameters.SessionData) newBuilder2.b).setCompletions(i6);
                    }
                    TokenParametersOuterClass$TokenParameters.SessionData sessionData = (TokenParametersOuterClass$TokenParameters.SessionData) newBuilder2.a();
                    newBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.UserSession) newBuilder.b).addSessionDataItems(sessionData);
                    i3++;
                    if (i3 >= i2) {
                        break;
                    }
                }
                newBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) newBuilder.b).setType(l0Var);
                userSession = (TokenParametersOuterClass$TokenParameters.UserSession) newBuilder.a();
            }
            if (userSession == null || userSession.getSessionDataItemsList().size() <= 0) {
                return;
            }
            k kVar2 = this.f1030a;
            kVar2.c();
            ((TokenParametersOuterClass$TokenParameters) kVar2.b).addUserSessions(userSession);
        }
    }
}
