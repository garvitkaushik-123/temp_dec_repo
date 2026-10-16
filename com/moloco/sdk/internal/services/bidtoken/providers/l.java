package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.bidtoken.providers.l;
import com.moloco.sdk.publisher.privacy.InternalMolocoPrivacySettingsImpl;
import com.moloco.sdk.service_locator.a;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public interface l extends j<k> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5649a = a.f5650a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5650a = new a();

        public static final com.moloco.sdk.internal.ilrd.e b() {
            return a.b.f5750a.g().a();
        }

        public final l a() {
            w wVar = new w();
            com.moloco.sdk.service_locator.a aVar = com.moloco.sdk.service_locator.a.f5748a;
            v vVar = new v(new com.moloco.sdk.internal.services.bidtoken.t(new InternalMolocoPrivacySettingsImpl(aVar.a())));
            a.h hVar = a.h.f5756a;
            s sVar = new s(hVar.c());
            e eVar = new e(aVar.a());
            u uVar = new u(a.i.f5757a.b());
            a.e eVar2 = a.e.f5753a;
            return new m(CollectionsKt.listOf((Object[]) new j[]{wVar, vVar, sVar, eVar, uVar, new i(eVar2.j()), new c(hVar.d()), new o(eVar2.l(), eVar2.m()), new g(eVar2.i()), new b(eVar2.g()), new q(new Function0() { // from class: com.moloco.sdk.internal.services.bidtoken.providers.l$a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return l.a.b();
                }
            })}));
        }
    }
}
