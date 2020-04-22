package com.shisizu.service;

import com.shisizu.domain.Admin;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-11-19:01
 */
@Service
public interface AdminService {
    Admin selectAdmin(String admName, String admPassword);
}
