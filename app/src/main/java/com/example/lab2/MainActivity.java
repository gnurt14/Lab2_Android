package com.example.lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> listContact;
    Adapter customAdapter;
    ListView listViewContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listContact = new ArrayList<>();
        listContact.add(new Contact(1, "Nguyen Huu Trung", "01234", false));
        listContact.add(new Contact(1, "Nguyen Huu Trung2", "0123456454", false));
        listContact.add(new Contact(1, "Nguyen Huu Trung3", "0123656", false));

        customAdapter = new Adapter(listContact);
        listViewContact = findViewById(R.id.listContact);
        listViewContact.setAdapter(customAdapter);

        findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo danh sách để lưu các Contact được chọn
                final List<Contact> selectedContacts = new ArrayList<>();

                // Lặp qua danh sách Contact để xác định các Contact đã được chọn
                for (Contact contact : listContact) {
                    if (contact.isStatus()) {
                        selectedContacts.add(contact);
                    }
                }

                // Nếu không có Contact nào được chọn, hiển thị thông báo
                if (selectedContacts.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn ít nhất một Contact để xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hiển thị hộp thoại xác nhận trước khi xóa
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa các Contact đã chọn?");

                builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xóa các Contact được chọn
                        for (Contact contact : selectedContacts) {
                            listContact.remove(contact);
                        }
                        // Cập nhật giao diện sau khi xóa
                        customAdapter.notifyDataSetChanged();
                        // Đặt lại trạng thái của các checkbox về false
                        for (Contact contact : listContact) {
                            contact.setStatus(false);
                        }
                        Toast.makeText(MainActivity.this, "Đã xóa các Contact được chọn.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Đóng hộp thoại nếu người dùng chọn hủy bỏ
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        findViewById(R.id.btnThemMoi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivity(intent);
            }
        });
    }
}