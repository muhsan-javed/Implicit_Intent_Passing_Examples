package com.muhsantech.implicitintentpassing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.muhsantech.implicitintentpassing.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Button btnDial, btnMsg, btnEmail, btnShare;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnDial.setOnClickListener(view -> {
            Intent iDial = new Intent(Intent.ACTION_DIAL);
            iDial.setData(Uri.parse("tel: +923153885157"));
            startActivity(iDial);
        });

        binding.btnmsg.setOnClickListener(view -> {
            Intent iMessage = new Intent(Intent.ACTION_SENDTO);
            iMessage.setData(Uri.parse("smsto:" + Uri.encode("03153885157")));
            iMessage.putExtra("sms_body", "Please solve this issue asap.");
            startActivity(iMessage);
        });

        binding.btnEmail.setOnClickListener(view -> {
            Intent iEmail = new Intent(Intent.ACTION_SEND);
            iEmail.setType("message/rfc822");
            iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"muhsanjaved048@gmail.com"});
            iEmail.putExtra(Intent.EXTRA_SUBJECT, "Questions");
            iEmail.putExtra(Intent.EXTRA_TEXT, "Please Resolve this issue asap");
            startActivity(Intent.createChooser(iEmail, "Email via"));
        });

        binding.btnShare.setOnClickListener(view -> {
            Intent iShare = new Intent(Intent.ACTION_SEND);
            iShare.setType("text/plain");
            iShare.putExtra(Intent.EXTRA_TEXT,"Download this Amazing App, https://play.google.com/store/apps/details?id=notepad.note.notas.notes.notizen");
            startActivity(Intent.createChooser(iShare, "Share via"));
        });

    }
}