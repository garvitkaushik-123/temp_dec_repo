package com.mbridge.msdk.dycreator.bus;

/* loaded from: classes6.dex */
class AsyncPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f4153a = new PendingPostQueue();
    private final EventBus b;

    AsyncPoster(EventBus eventBus) {
        this.b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f4153a.a(PendingPost.a(subscription, obj));
        EventBus.n.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost a2 = this.f4153a.a();
        if (a2 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.a(a2);
    }
}
