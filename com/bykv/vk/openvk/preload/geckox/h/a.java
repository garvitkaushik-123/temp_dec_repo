package com.bykv.vk.openvk.preload.geckox.h;

import android.util.Pair;
import com.bykv.vk.openvk.preload.a.j;
import com.bykv.vk.openvk.preload.a.k;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.b.h;
import com.bykv.vk.openvk.preload.b.l;
import com.bykv.vk.openvk.preload.geckox.d.c;
import com.bykv.vk.openvk.preload.geckox.d.e;
import com.bykv.vk.openvk.preload.geckox.d.f;
import com.bykv.vk.openvk.preload.geckox.d.g;
import com.bykv.vk.openvk.preload.geckox.d.i;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GeckoPipeline.java */
/* loaded from: classes3.dex */
public class a {
    public static b<Object> a(final com.bykv.vk.openvk.preload.geckox.e.a aVar, File file, final com.bykv.vk.openvk.preload.geckox.b bVar, com.bykv.vk.openvk.preload.falconx.a.a aVar2, Map<String, Map<String, Object>> map, Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(e.class).a(file, bVar.d()).a(aVar2.a(e.class)).b());
        arrayList.add(h.a.a().a(c.class).a(bVar, map, map2, aVar, str).a(new com.bykv.vk.openvk.preload.b.b.b(new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.6
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                List<UpdatePackage> list = (List) bVar2.b(c.class);
                bVar2.a(c.class);
                HashMap hashMap = new HashMap();
                for (UpdatePackage updatePackage : list) {
                    String accessKey = updatePackage.getAccessKey();
                    List list2 = (List) hashMap.get(accessKey);
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(updatePackage);
                    hashMap.put(accessKey, list2);
                }
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                bVar2.a(c.class);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        }, aVar2.a(c.class))).b());
        arrayList.add(h.a.a().a(f.class).a(com.bykv.vk.openvk.preload.geckox.b.g()).a(new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.1
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    ((UpdatePackage) bVar2.b(f.class)).getChannel();
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(b<T> bVar2, d dVar) {
                super.c(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onPipelineEnd", "");
                } catch (Throwable unused) {
                }
            }
        }).b());
        l.b bVar2 = new l.b();
        l.a a2 = bVar2.a("branch_zip");
        l.b bVar3 = new l.b();
        l.a a3 = bVar3.a("patch");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.h.class).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class).a(bVar).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.f.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.b.f.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.e.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar))).b());
        a3.a(arrayList2);
        l.a a4 = bVar3.a("full");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(h.a.a().a(g.class).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.c.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar))).b());
        a4.a(arrayList3);
        a2.a(bVar3.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        l.a a5 = bVar2.a("branch_single_file");
        l.b bVar4 = new l.b();
        l.a a6 = bVar4.a("patch");
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.h.class).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.c.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.b.c.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class).a(bVar).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class))).b());
        a6.a(arrayList4);
        l.a a7 = bVar4.a("full");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(h.a.a().a(g.class).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class))).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar, bVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class))).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(aVar), aVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class))).b());
        a7.a(arrayList5);
        a5.a(bVar4.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        l.a a8 = bVar2.a("branch_myarchive_file");
        l.b bVar5 = new l.b();
        bVar5.a("patch").a(Collections.emptyList());
        bVar5.a("full").a(Collections.emptyList());
        a8.a(bVar5.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        arrayList.add(bVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.class));
        arrayList.add(h.a.a().a(i.class).a(new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.2
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(b<T> bVar6, d dVar) {
                super.c(bVar6, dVar);
                Pair pair = (Pair) bVar6.a(i.class);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    Object obj = pair.first;
                    ((Long) pair.second).longValue();
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar6, d dVar, Throwable th) {
                super.a(bVar6, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar6, d dVar, Throwable th) {
                super.b(bVar6, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar6, d dVar) {
                super.a(bVar6, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar6, d dVar) {
                super.b(bVar6, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }
        }).b());
        return com.bykv.vk.openvk.preload.b.c.a(arrayList, null);
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(com.bykv.vk.openvk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.3
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                bVar.b(com.bykv.vk.openvk.preload.geckox.d.b.class);
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                bVar.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.e.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.4
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a b(final com.bykv.vk.openvk.preload.geckox.e.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.5
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    bVar2.b(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (com.bykv.vk.openvk.preload.geckox.e.a.this != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.h.a.7
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    com.bykv.vk.openvk.preload.geckox.b.this.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }
        };
    }

    public static com.bykv.vk.openvk.preload.a.i a(com.bykv.vk.openvk.preload.a.d.a aVar) throws m {
        boolean z;
        try {
            try {
                aVar.f();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return com.bykv.vk.openvk.preload.a.b.a.m.A.a(aVar);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return k.f917a;
                }
                throw new p(e);
            }
        } catch (com.bykv.vk.openvk.preload.a.d.d e3) {
            throw new p(e3);
        } catch (IOException e4) {
            throw new j(e4);
        } catch (NumberFormatException e5) {
            throw new p(e5);
        }
    }

    public static void a(com.bykv.vk.openvk.preload.a.i iVar, com.bykv.vk.openvk.preload.a.d.c cVar) throws IOException {
        com.bykv.vk.openvk.preload.a.b.a.m.A.a(cVar, iVar);
    }
}
