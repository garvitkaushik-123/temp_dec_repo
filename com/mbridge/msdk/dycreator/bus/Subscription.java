package com.mbridge.msdk.dycreator.bus;

/* loaded from: classes6.dex */
final class Subscription {

    /* renamed from: a, reason: collision with root package name */
    final Object f4165a;
    final SubscriberMethod b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f4165a = obj;
        this.b = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            Subscription subscription = (Subscription) obj;
            if (this.f4165a == subscription.f4165a && this.b.equals(subscription.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f4165a.hashCode() + this.b.d.hashCode();
    }
}
