package com.bykv.vk.openvk.preload.geckox.statistic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.d.b.b.f;
import com.bykv.vk.openvk.preload.geckox.d.e;
import com.bykv.vk.openvk.preload.geckox.d.g;
import com.bykv.vk.openvk.preload.geckox.d.h;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import java.util.Map;

/* compiled from: UpdateListeners.java */
/* loaded from: classes3.dex */
public final class b {
    private static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.1
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.c(bVar2, dVar);
                try {
                    c.a(com.bykv.vk.openvk.preload.geckox.b.this, a.a(dVar.b()));
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                    if ((dVar instanceof e) && (dVar.f() instanceof Map)) {
                        com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName(), ((Map) dVar.f()).get("f36c832c8dbb162c49b46a7a6dd47fbd"));
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                    c.a(com.bykv.vk.openvk.preload.geckox.b.this, a.a(dVar.b()));
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                    c.a(com.bykv.vk.openvk.preload.geckox.b.this, a.a(dVar.b()));
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(final Context context) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.4
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                Pair pair = (Pair) bVar.b(g.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) pair.second).getChannel());
                a2.t = ((Uri) pair.first).toString();
                a2.n = com.bykv.vk.openvk.preload.geckox.utils.e.a(context);
                a2.v = SystemClock.uptimeMillis();
                a2.p = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getAccessKey())) {
                    a2.f974a = ((UpdatePackage) pair.second).getAccessKey();
                }
                if (TextUtils.isEmpty(((UpdatePackage) pair.second).getGroupName())) {
                    return;
                }
                a2.b = ((UpdatePackage) pair.second).getGroupName();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.z = true;
                a2.w = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(g.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.z = false;
                a2.w = SystemClock.uptimeMillis();
                a2.u.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a b(final Context context) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.5
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                Pair pair = (Pair) bVar.b(h.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) pair.second).getChannel());
                a2.d = ((Uri) pair.first).toString();
                a2.n = com.bykv.vk.openvk.preload.geckox.utils.e.a(context);
                a2.f = SystemClock.uptimeMillis();
                a2.o = Long.valueOf(((UpdatePackage) pair.second).getPatch().getId());
                a2.p = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.h = true;
                a2.g = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(h.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.h = false;
                a2.g = SystemClock.uptimeMillis();
                a2.e.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }

    public static void a(com.bykv.vk.openvk.preload.geckox.a aVar, com.bykv.vk.openvk.preload.geckox.b bVar) {
        aVar.a(e.class, a(bVar));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.d.class, a(bVar));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.c.class, b(bVar.a()));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.6
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel()).i = true;
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.i = false;
                SystemClock.uptimeMillis();
                a2.q = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.7
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel()).j = true;
                SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = false;
                SystemClock.uptimeMillis();
                a2.r = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.8
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = true;
                a2.l = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = false;
                a2.l = SystemClock.uptimeMillis();
                a2.r = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.11
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.k = true;
                a2.m = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.k = false;
                a2.s = th.getMessage();
                a2.m = SystemClock.uptimeMillis();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class, a(bVar.a()));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.9
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.A = true;
                a2.x = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.A = false;
                a2.x = SystemClock.uptimeMillis();
                a2.C = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.10
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.B = true;
                a2.y = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.D = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class, b(bVar.a()));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.6
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel()).i = true;
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.i = false;
                SystemClock.uptimeMillis();
                a2.q = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.7
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel()).j = true;
                SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = false;
                SystemClock.uptimeMillis();
                a2.r = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.8
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = true;
                a2.l = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.j = false;
                a2.l = SystemClock.uptimeMillis();
                a2.r = th.getMessage();
            }
        });
        aVar.a(f.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.3
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.k = false;
                a2.m = SystemClock.uptimeMillis();
                a2.s = th.getMessage();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.k = false;
                a2.m = SystemClock.uptimeMillis();
                a2.D = th.getMessage();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.c(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(h.class)).second).getChannel());
                a2.k = true;
                a2.m = SystemClock.uptimeMillis();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class, a(bVar.a()));
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.9
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.A = true;
                a2.x = SystemClock.uptimeMillis();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.A = false;
                a2.x = SystemClock.uptimeMillis();
                a2.C = th.getMessage();
            }
        });
        aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class, new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.b.2
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.D = th.getMessage();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.D = th.getMessage();
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar2, d dVar) {
                super.c(bVar2, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.b()).a(((UpdatePackage) ((Pair) bVar2.b(g.class)).second).getChannel());
                a2.B = true;
                a2.y = SystemClock.uptimeMillis();
            }
        });
    }
}
