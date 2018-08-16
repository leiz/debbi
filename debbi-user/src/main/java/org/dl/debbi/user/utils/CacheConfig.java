package org.dl.debbi.user.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.dl.debbi.user.account.domain.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

import static org.dl.debbi.user.account.utils.AccountHelper.MOCK_CERTIFICATE;
import static org.dl.debbi.user.account.utils.AccountHelper.PRINCIPAL_PREFIX;

@Configuration
public class CacheConfig {

    // 预置账号缓存

    @Bean("accountCache")
    public LoadingCache<Long, Account> accountCache() {
        return CacheBuilder.newBuilder().maximumSize(1000)
                .build(new CacheLoader<>() {
                    @Override
                    public Account load(Long id) {
                        Account a = new Account();
                        a.id = id;
                        a.principal = PRINCIPAL_PREFIX + id;
                        a.certificate = MOCK_CERTIFICATE;
                        a.created = new Date();
                        return a;
                    }
                });
    }
}
