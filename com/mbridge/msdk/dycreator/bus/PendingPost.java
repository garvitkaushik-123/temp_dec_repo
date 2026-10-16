package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
final class PendingPost {
    private static final List<PendingPost> d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f4161a;
    Subscription b;
    PendingPost c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f4161a = obj;
        this.b = subscription;
    }

    static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new PendingPost(obj, subscription);
            }
            PendingPost remove = list.remove(size - 1);
            remove.f4161a = obj;
            remove.b = subscription;
            remove.c = null;
            return remove;
        }
    }

    static void a(PendingPost pendingPost) {
        pendingPost.f4161a = null;
        pendingPost.b = null;
        pendingPost.c = null;
        List<PendingPost> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
