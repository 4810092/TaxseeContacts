package ganikhodjaev.taxseecontacts.ui.main;

import ganikhodjaev.taxseecontacts.api.ApiFactory;
import ganikhodjaev.taxseecontacts.content.Employee;
import ganikhodjaev.taxseecontacts.utils.PreferenceUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Khasan Ganikhodjaev
 */
class MainPresenter {
    private MainView mainView;
    private CompositeDisposable disposable = new CompositeDisposable();

    MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    void init() {

        mainView.showLoading();

        disposable.add(ApiFactory.getTaxseeService()
                .departments(PreferenceUtils.getLogin(), PreferenceUtils.getPassword())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(department -> {
                    mainView.hideLoading();
                    mainView.setData(department);
                }, throwable -> mainView.hideLoading()));

    }

    void onDestroy() {
        disposable.dispose();
    }

    void onEmployeeClick(Employee employee) {
        mainView.openEmployeeDetails(employee);
    }

    void onLogoutClick() {
        PreferenceUtils.removePassword();

        mainView.openAuthActivity();
    }
}
