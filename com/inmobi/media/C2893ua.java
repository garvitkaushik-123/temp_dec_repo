package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ua, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2893ua extends AbstractC2864se {
    public final C2672h d;
    public final C2947y0 e;
    public InMobiAdRequestStatus f;
    public final InterfaceC2971z5 g;
    public final WeakReference h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2893ua(S0 adUnit, C2672h ad, C2947y0 adSet, InMobiAdRequestStatus status, InterfaceC2971z5 interfaceC2971z5) {
        super(adUnit, (byte) 1);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        Intrinsics.checkNotNullParameter(status, "status");
        this.d = ad;
        this.e = adSet;
        this.f = status;
        this.g = interfaceC2971z5;
        this.h = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        a(((Boolean) obj).booleanValue());
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        this.f = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY);
        a(false);
    }

    public final void a(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("ParseAdResponseWorker", "onComplete result - " + z);
        }
        S0 s0 = (S0) this.h.get();
        if (s0 != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("ParseAdResponseWorker", "updating vitals in logger");
            }
            s0.a(z, this.f);
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.g;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).b("ParseAdResponseWorker", "onComplete - adunit is null");
        }
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("ParseAdResponseWorker", "execute task");
        }
        S0 s0 = (S0) this.h.get();
        if (s0 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("ParseAdResponseWorker", "adUnit is null. fail.");
            }
            b(Boolean.FALSE);
            return;
        }
        if (this.e.n()) {
            InterfaceC2971z5 interfaceC2971z53 = this.g;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).c("ParseAdResponseWorker", "parsing for ad pods");
            }
            LinkedList<C2672h> f = this.e.f();
            C2672h first = f.getFirst();
            Intrinsics.checkNotNull(first);
            if (s0.a(first, 0, true)) {
                InterfaceC2971z5 interfaceC2971z54 = this.g;
                if (interfaceC2971z54 != null) {
                    ((A5) interfaceC2971z54).c("ParseAdResponseWorker", "parse success for ad index 0");
                }
                ListIterator<C2672h> listIterator = f.listIterator(1);
                Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
                while (listIterator.hasNext()) {
                    C2672h next = listIterator.next();
                    if (!s0.a(next, f.indexOf(next), false)) {
                        InterfaceC2971z5 interfaceC2971z55 = this.g;
                        if (interfaceC2971z55 != null) {
                            ((A5) interfaceC2971z55).b("ParseAdResponseWorker", "parseAdResponse fail for index - " + f.indexOf(next));
                        }
                        listIterator.remove();
                    } else {
                        InterfaceC2971z5 interfaceC2971z56 = this.g;
                        if (interfaceC2971z56 != null) {
                            ((A5) interfaceC2971z56).c("ParseAdResponseWorker", "parseAdResponse success for index - " + f.indexOf(next));
                        }
                    }
                }
                b(Boolean.TRUE);
                return;
            }
            InterfaceC2971z5 interfaceC2971z57 = this.g;
            if (interfaceC2971z57 != null) {
                ((A5) interfaceC2971z57).b("ParseAdResponseWorker", "didParseAdResponseAndExtractData failed");
            }
            b(Boolean.FALSE);
            return;
        }
        InterfaceC2971z5 interfaceC2971z58 = this.g;
        if (interfaceC2971z58 != null) {
            ((A5) interfaceC2971z58).c("ParseAdResponseWorker", "parsing for single ad");
        }
        b(Boolean.valueOf(s0.a(this.d, 0, true)));
    }
}
