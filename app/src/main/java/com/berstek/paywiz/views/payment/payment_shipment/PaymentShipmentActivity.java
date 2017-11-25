package com.berstek.paywiz.views.payment.payment_shipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.berstek.paywiz.R;
import com.berstek.paywiz.callbacks.ConfirmationDialogListener;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.utils.UserUtils;

import java.util.ArrayList;

public class PaymentShipmentActivity extends AppCompatActivity
        implements PSPage1.TitleAndAmountInputListener,
        PSPage2.DetailsAndImageURLListener,
        PSPage3.CourierAndDueDateListener, ConfirmationDialogListener {

    /*
    PAYMENT FLOW
    1. Select recipient
    2. Title and amount (PSPage1)
    3. Details and pictures & ad url(recommended) (PSPage2)
    4. Courier and due date (PSPage3)
    5. Confirmation Dialog
     */

    private Transaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        transaction = new Transaction();
        transaction.setSender_uid(UserUtils.getUID());
        transaction.setStatus(Transaction.Status.AWAITING_ACCEPTANCE);
        transaction.setCreation_date(System.currentTimeMillis());
    }

    @Override
    public void onTitleAndAmountReady(String title, String amount) {

    }

    @Override
    public void onDetailsAndImagesReady(String details, ArrayList<String> imgURLs) {

    }


    @Override
    public void onCourierAndDueDateReady(Transaction.Courier courier, long due_date) {

    }

    @Override
    public void onAgree() {

    }

    @Override
    public void onCancel() {

    }
}
