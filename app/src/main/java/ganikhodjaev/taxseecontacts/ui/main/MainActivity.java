package ganikhodjaev.taxseecontacts.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ganikhodjaev.taxseecontacts.R;
import ganikhodjaev.taxseecontacts.content.Department;
import ganikhodjaev.taxseecontacts.content.Employee;
import ganikhodjaev.taxseecontacts.databinding.ActivityMainBinding;
import ganikhodjaev.taxseecontacts.ui.auth.AuthActivity;
import ganikhodjaev.taxseecontacts.ui.employee.EmployeeActivity;

/**
 * @author Khasan Ganikhodjaev
 */
public class MainActivity extends AppCompatActivity implements MainView {


    LinearLayoutManager llm;
    RVAdapter adapter;

    private MainPresenter mPresenter;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);

        mPresenter = new MainPresenter(this);
        mPresenter.init();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                mPresenter.onLogoutClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void openAuthActivity() {
        AuthActivity.start(this);
        finish();
    }

    @Override
    public void setData(Department department) {
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.list.setLayoutManager(llm);

        adapter = new RVAdapter(department, mPresenter);
        binding.list.setAdapter(adapter);
    }

    @Override
    public void openEmployeeDetails(Employee employee) {
        EmployeeActivity.start(this, employee);
    }

    @Override
    public void showLoading() {
        binding.pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.pb.setVisibility(View.GONE);
    }


    public void lockActions(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
