package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public class ProxyBillingActivity extends Activity {
    private static final String KEY_ACTIVITY_CODE = "activity_code";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final int RESULT_CODE_PLAY_CANCELED_WITH_ON_CREATE_RUNTIME_EXCEPTION = 5;
    static final int RESULT_CODE_PLAY_CANCELLED = 3;
    static final int RESULT_CODE_PLAY_CANCELLED_WITHOUT_COMPLETE_ACTION = 4;
    private static final String TAG = "ProxyBillingActivity";
    private int activityCode;
    private long billingClientTransactionId;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private boolean sendCancelledBroadcastIfFinished;
    private boolean wasServiceAutoReconnected;

    private zzie getReasonForNullData(int i) {
        return i != -1 ? i != 0 ? i != 3 ? i != 4 ? i != 5 ? zzie.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_ON_CREATE_RUNTIME_EXCEPTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE : zzie.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
    }

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchaseUpdatedIntentWithInternalErrorReason(zzie zzieVar, long j) {
        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
        makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(6);
        newBuilder.setDebugMessage("An internal error occurred.");
        BillingResult build = newBuilder.build();
        int i = zzcg.zza;
        makePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzcg.zzb(zzieVar, 2, build, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzM());
        makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j);
        makePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return makePurchasesUpdatedIntent;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent makePurchaseUpdatedIntentWithInternalErrorReason;
        super.onActivityResult(i, i2, intent);
        if (i == 100 || i == 110) {
            int responseCode = com.google.android.gms.internal.play_billing.zzc.zzh(intent, TAG).getResponseCode();
            int i3 = -1;
            if (i2 == -1) {
                if (responseCode != 0) {
                    i2 = -1;
                }
                if (intent != null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null data with resultCode " + i3 + "!");
                    makePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(getReasonForNullData(i3), this.billingClientTransactionId);
                } else if (intent.getExtras() != null) {
                    String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                    if (string != null) {
                        makePurchaseUpdatedIntentWithInternalErrorReason = makeAlternativeBillingIntent(string);
                        makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    } else {
                        makePurchaseUpdatedIntentWithInternalErrorReason = makePurchasesUpdatedIntent();
                        makePurchaseUpdatedIntentWithInternalErrorReason.putExtras(intent.getExtras());
                        makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    }
                    makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                    makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got null bundle!");
                    makePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(zzie.NULL_BUNDLE_IN_ACTIVITY_RESULT, this.billingClientTransactionId);
                }
                if (i == 110) {
                    makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(makePurchaseUpdatedIntentWithInternalErrorReason);
            }
            com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
            i3 = i2;
            if (intent != null) {
            }
            if (i == 110) {
            }
            sendBroadcast(makePurchaseUpdatedIntentWithInternalErrorReason);
        } else if (i == 101) {
            int zza = com.google.android.gms.internal.play_billing.zzc.zza(intent, TAG);
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(zza, intent == null ? null : intent.getExtras());
            }
        } else {
            com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.activityCode = bundle.getInt(KEY_ACTIVITY_CODE, 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow");
        this.activityCode = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                this.activityCode = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            this.activityCode = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Got exception while trying to start a purchase flow.", e);
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent makePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(zzie.INTENT_SENDER_EXCEPTION, this.billingClientTransactionId);
                if (this.isFlowFromFirstPartyClient) {
                    makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(makePurchaseUpdatedIntentWithInternalErrorReason);
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.isFlowFromFirstPartyClient) {
                makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt(KEY_ACTIVITY_CODE, this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}
