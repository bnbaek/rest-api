package net.openu.core.domain.account;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByCode(String code);
}
