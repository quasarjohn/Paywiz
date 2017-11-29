package com.berstek.paywiz.views.payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Contact;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.views.payment.payment_shipment.PaymentShipmentActivity;
import com.berstek.paywiz.views.search.SearchContactsAdapter;
import com.berstek.paywiz.views.search.SearchResultsAdapter;
import com.berstek.paywiz.views.search.SearchUserDialogFragment;

public class PaymentTypeActivity extends AppCompatActivity implements View.OnClickListener,
        SearchContactsAdapter.OnContactSelectedListener, SearchResultsAdapter.OnResultSelectedListener {

    private View payShipment;
    private SearchUserDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_type);

        payShipment = findViewById(R.id.pay_shipment);

        payShipment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dialogFragment = new SearchUserDialogFragment();
        dialogFragment.setResultSelectedListener(this);
        dialogFragment.setContactSelectedListener(this);
        dialogFragment.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onResultSelected(User user) {
        dialogFragment.dismiss();
        Intent intent = new Intent(this, PaymentShipmentActivity.class);
        intent.putExtra("receiver_uid", user.getKey());
        startActivity(intent);
    }

    @Override
    public void onContactSelected(Contact contact) {
        dialogFragment.dismiss();
        Intent intent = new Intent(this, PaymentShipmentActivity.class);
        intent.putExtra("receiver_uid", contact.getKey());
        startActivity(intent);
    }
}
