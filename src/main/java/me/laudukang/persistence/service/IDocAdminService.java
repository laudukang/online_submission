package me.laudukang.persistence.service;

import me.laudukang.persistence.model.OsDocAdmin;
import me.laudukang.persistence.model.OsDocAdminPK;
import me.laudukang.spring.domain.OsDocAdminDomain;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2016/2/25
 * <p>Time: 18:13
 * <p>Version: 1.0
 */
public interface IDocAdminService {
    void save(OsDocAdmin osDocAdmin);

    void deleteById(OsDocAdminPK osDocAdminPK);

    void update(OsDocAdmin osDocAdmin);

    OsDocAdminDomain findOneByDocId(int id);

}