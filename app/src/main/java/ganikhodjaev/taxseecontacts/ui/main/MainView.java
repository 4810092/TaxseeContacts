package ganikhodjaev.taxseecontacts.ui.main;

import ganikhodjaev.taxseecontacts.content.Department;
import ganikhodjaev.taxseecontacts.content.Employee;
import ganikhodjaev.taxseecontacts.ui.base.LoadingView;

/**
 * @author Khasan Ganikhodjaev
 */
public interface MainView extends LoadingView {
    void setData(Department department);

    void openEmployeeDetails(Employee employee);

    void openAuthActivity();
}
