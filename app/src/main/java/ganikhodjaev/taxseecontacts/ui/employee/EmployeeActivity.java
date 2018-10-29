package ganikhodjaev.taxseecontacts.ui.employee;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

import ganikhodjaev.taxseecontacts.R;
import ganikhodjaev.taxseecontacts.content.Employee;
import ganikhodjaev.taxseecontacts.databinding.ActivityEmployeeBinding;

/**
 * @author Khasan Ganikhodjaev
 */
public class EmployeeActivity extends AppCompatActivity {

    private final static String keyEmployee = "employee";

    public static void start(Activity activity, Employee employee) {

        Intent intent = new Intent(activity, EmployeeActivity.class);

        intent.putExtra(keyEmployee, employee);

        activity.startActivity(intent);

    }


    private Employee employee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        Serializable serializableEmpl = getIntent().getSerializableExtra(keyEmployee);
        if (serializableEmpl instanceof Employee)
            employee = (Employee) serializableEmpl;

        ActivityEmployeeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_employee);
        binding.setEmployee(employee);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
