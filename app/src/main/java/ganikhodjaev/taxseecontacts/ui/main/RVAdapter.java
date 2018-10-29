package ganikhodjaev.taxseecontacts.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ganikhodjaev.taxseecontacts.content.Department;
import ganikhodjaev.taxseecontacts.content.Employee;
import ganikhodjaev.taxseecontacts.databinding.ItemDepartmentBinding;
import ganikhodjaev.taxseecontacts.databinding.ItemEmployeeBinding;

/**
 * @author Khasan Ganikhodjaev
 */
public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Department department;
    private MainPresenter mPresenter;

    public RVAdapter(Department department, MainPresenter mPresenter) {
        this.department = department;
        this.mPresenter = mPresenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                ItemDepartmentBinding departmentBinding =
                        ItemDepartmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new DepartmentVH(departmentBinding);
            default:
                ItemEmployeeBinding employeeBinding =
                        ItemEmployeeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

                return new EmployeeVH(employeeBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DepartmentVH)
            onBindDepartmentVH((DepartmentVH) holder, position);

        if (holder instanceof EmployeeVH)
            onBindEmployeeVH((EmployeeVH) holder, position);

    }

    private void onBindEmployeeVH(EmployeeVH employeeVH, int position) {

        Employee employee = department.getEmployees().get(position);

        employeeVH.bind(employee);

        employeeVH.itemView.setOnClickListener(v -> mPresenter.onEmployeeClick(employee));

    }

    private void onBindDepartmentVH(DepartmentVH departmentVH, int position) {

        Department dep = department.getDepartments().get(position);
        departmentVH.bind(dep);

        LinearLayoutManager llm = new LinearLayoutManager(departmentVH.itemView.getContext(), LinearLayoutManager.VERTICAL, false);
        departmentVH.binding.departmentList.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(dep, mPresenter);
        departmentVH.binding.departmentList.setAdapter(adapter);
    }

    @Override
    public int getItemViewType(int position) {
        if (department.getDepartments() != null) return 0;
        if (department.getEmployees() != null) return 1;
        return 2;
    }

    @Override
    public int getItemCount() {
        if (department.getDepartments() != null) return department.getDepartments().size();
        if (department.getEmployees() != null) return department.getEmployees().size();
        return 0;
    }

    class DepartmentVH extends RecyclerView.ViewHolder {
        private final ItemDepartmentBinding binding;


        DepartmentVH(ItemDepartmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Department department) {
            binding.setDepartment(department);
            binding.executePendingBindings();
        }

    }

    class EmployeeVH extends RecyclerView.ViewHolder {
        private final ItemEmployeeBinding binding;

        EmployeeVH(ItemEmployeeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Employee employee) {
            binding.setEmployee(employee);
            binding.executePendingBindings();
        }
    }
}
