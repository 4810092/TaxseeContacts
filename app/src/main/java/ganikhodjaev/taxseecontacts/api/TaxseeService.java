package ganikhodjaev.taxseecontacts.api;

import ganikhodjaev.taxseecontacts.content.Authorization;
import ganikhodjaev.taxseecontacts.content.Department;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Khasan Ganikhodjaev
 */
public interface TaxseeService {

    @GET("Contacts.svc/Hello")
    Single<Authorization> authorize(@Query("login") String login, @Query("password") String password);


    @GET("Contacts.svc/GetAll")
    Single<Department> departments(@Query("login") String login, @Query("password") String password);


}
