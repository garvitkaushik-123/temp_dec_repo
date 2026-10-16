package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class p implements com.fyber.inneractive.sdk.player.controller.p {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.measurement.f f1636a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;

    public p(com.fyber.inneractive.sdk.measurement.f fVar) {
        this.f1636a = fVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("MeasurementHelper onPlayerStateChanged=%s mBuffering=%s mPrepared=%s", bVar, String.valueOf(this.b), String.valueOf(this.d));
        if (this.f1636a != null) {
            int i = o.f1635a[bVar.ordinal()];
            if (i == 1) {
                this.d = true;
                return;
            }
            if (i == 2) {
                if (this.d) {
                    com.fyber.inneractive.sdk.measurement.f fVar = this.f1636a;
                    if (fVar.c != null) {
                        IAlog.a("%s bufferStart", "OMVideo");
                        try {
                            fVar.c.bufferStart();
                        } catch (Throwable th) {
                            fVar.a(th);
                        }
                    }
                    this.b = true;
                    return;
                }
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    com.fyber.inneractive.sdk.measurement.f fVar2 = this.f1636a;
                    if (fVar2.c != null) {
                        IAlog.a("%s pause", "OMVideo");
                        try {
                            fVar2.c.pause();
                        } catch (Throwable th2) {
                            fVar2.a(th2);
                        }
                    }
                    this.c = true;
                    return;
                }
                if (i != 5) {
                    return;
                }
                com.fyber.inneractive.sdk.measurement.f fVar3 = this.f1636a;
                if (fVar3.c != null) {
                    IAlog.a("%s complete", "OMVideo");
                    try {
                        fVar3.c.complete();
                        return;
                    } catch (Throwable th3) {
                        fVar3.a(th3);
                        return;
                    }
                }
                return;
            }
            if (this.b) {
                this.b = false;
                com.fyber.inneractive.sdk.measurement.f fVar4 = this.f1636a;
                if (fVar4.c != null) {
                    IAlog.a("%s bufferEnd", "OMVideo");
                    try {
                        fVar4.c.bufferFinish();
                        return;
                    } catch (Throwable th4) {
                        fVar4.a(th4);
                        return;
                    }
                }
                return;
            }
            if (this.c) {
                com.fyber.inneractive.sdk.measurement.f fVar5 = this.f1636a;
                if (fVar5.c != null) {
                    IAlog.a("%s resume", "OMVideo");
                    try {
                        fVar5.c.resume();
                    } catch (Throwable th5) {
                        fVar5.a(th5);
                    }
                }
                this.c = false;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
    }
}
