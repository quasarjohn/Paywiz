package com.berstek.paywiz.views.payment.payment_shipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.berstek.paywiz.R;
import com.berstek.paywiz.callbacks.ConfirmationDialogListener;
import com.berstek.paywiz.data_access.TestDA;
import com.berstek.paywiz.models.Contact;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.utils.UserUtils;
import com.berstek.paywiz.views.search.SearchContactsAdapter;
import com.berstek.paywiz.views.search.SearchResultsAdapter;
import com.berstek.paywiz.views.search.SearchUserDialogFragment;

import java.util.ArrayList;

public class PaymentShipmentActivity extends AppCompatActivity
        implements PSPage1.PSPage1Listener,
        PSPage3.CourierAndDueDateListener, ConfirmationDialogListener {

    /*
    PAYMENT FLOW
    1. Select recipient
    2. Title, details and amount (PSPage1)
    3. Courier and due date (PSPage2)
    4. Confirmation Dialog
     */

    private Transaction transaction;
    private String receiver_uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        receiver_uid = getIntent().getExtras().getString("receiver_uid");

        transaction = new Transaction();
        transaction.setSender_uid(UserUtils.getUID());
        transaction.setStatus(Transaction.Status.AWAITING_ACCEPTANCE);
        transaction.setCreation_date(System.currentTimeMillis());

        PSPage1 page1 = new PSPage1();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_payment, page1).commit();
    }

    @Override
    public void onPage1Ready(String title, String details, String amount,
                             ArrayList<String> imgURLs) {
        transaction.setTitle(title);
        transaction.setDetail(details);
        transaction.setAmount(Double.parseDouble(amount));
        transaction.setImg_urls(imgURLs);
        PSPage2 page2 = new PSPage2();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_payment, page2).
                addToBackStack(null).commit();
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
