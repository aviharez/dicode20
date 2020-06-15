package com.example.menupesanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private RadioButton rbSeblak, rbBakso;
    private RadioGroup rg;
    private Button btMinus, btPlus, btOrder, btReset;
    private TextView tvCount, tvName, tvPesanan, tvQty, tvTotal;

    private String pesanan;
    private int price, qty, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);

        rbSeblak = findViewById(R.id.rbSeblak);
        rbBakso = findViewById(R.id.rbBakso);

        btMinus = findViewById(R.id.btMinus);
        btPlus = findViewById(R.id.btPlus);
        btOrder = findViewById(R.id.btOrder);
        btReset = findViewById(R.id.btReset);

        tvCount = findViewById(R.id.tvCount);
        tvName = findViewById(R.id.tvName);
        tvPesanan = findViewById(R.id.tvPesanan);
        tvQty = findViewById(R.id.tvQty);
        tvTotal = findViewById(R.id.tvSum);

        rg = findViewById(R.id.rg);

        qty = Integer.parseInt(tvCount.getText().toString());

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qty > 0) {
                    qty--;
                    tvCount.setText(String.valueOf(qty));
                }
            }
        });

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty++;
                tvCount.setText(String.valueOf(qty));
            }
        });

        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbSeblak.isChecked()) {
                    pesanan = "Seblak bapak kantin";
                    price = 5000;
                } else if (rbBakso.isChecked()) {
                    pesanan = "Bakso Mekarwangi";
                    price = 12000;
                }

                total = qty * price;

                tvName.setText(etName.getText().toString());
                tvPesanan.setText(pesanan);
                tvQty.setText(String.valueOf(qty));
                tvTotal.setText(String.valueOf(total));

                clearAll();

                Toast.makeText(getApplicationContext(), "Terima kasih sudah memesan", Toast.LENGTH_SHORT).show();

            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });

    }

    private void clearAll() {
        etName.setText("");
        tvCount.setText("0");
        rg.clearCheck();
        qty = 0;
    }

}