package com.aws.codestar.projecttemplates.repository;
 
import com.aws.codestar.projecttemplates.entity.User;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
 
 
@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
 
	List<User> findByName(String name);
        List<User> findByMobile(String mobile);
}