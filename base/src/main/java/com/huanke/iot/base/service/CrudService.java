package com.huanke.iot.base.service;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.persistence.DataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.huanke.iot.base.persistence.BaseEntity.DEL_FLAG_NORMAL;

/**
 * 描述:
 * Service基础类
 *
 * @author onlymark
 * @create 2018-09-07 下午6:05
 */
public class CrudService<D extends CrudDao<T>, T extends DataEntity> extends BaseService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String tableName;
    @Autowired
    protected D dao;

    /**
     * 清除缓存，由各实现服务自己实现
     */
    protected void clearCache(T entity) {}

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(Integer id) {
        return dao.get(id);
    }

    public List<T> findList(T entity) {
        return dao.findList(new Page<T>(entity));
    }

    public List<T> findList(T entity, int maxResult) {
        return dao.findList(new Page<T>(entity, 0, maxResult));
    }

    public List<T> findList(Page<T> page) {
        return dao.findList(page);
    }

    /**
     * 查询分页数据
     * @return
     */
    public Page<T> findPage(T entity) {
        return findPage(new Page<>(entity));
    }
    /**
     * 查询分页数据
     * @param page 分页对象
     * @return
     */
    public Page<T> findPage(Page<T> page) {
        long count = dao.count(page);
        page.setCount(count);
        if (count == 0) {
            page.setData(new ArrayList<T>());
        } else {
            page.setData(dao.findList(page));
        }
        return page;
    }

    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    public void save(T entity) {
        if (entity.isNewRecord()) {
            this.preInsert(entity);
            dao.insert(entity);
        }else{
            this.preUpdate(entity);
            dao.update(entity);
        }
        clearCache(entity);
    }

    /**
     * 更新前处理
     * @param entity
     */
    protected void preUpdate(T entity) {}

    /**
     * 插入前处理
     * @param entity
     */
    protected void preInsert(T entity) {
        entity.setIsDelete(DEL_FLAG_NORMAL);
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(new Date());
        }
    }

    /**
     * 删除数据
     * @param entity
     */
    public void delete(T entity) {
        if (entity != null && entity.getId() != null) {
            dao.delete(entity.getId());
            clearCache(entity);
        }
    }

    public void batchSave(List<T> entitys) {
        for (int i = 0; i < entitys.size();) {
            doBatchSave(entitys, i, (i += 500) >= entitys.size() ? entitys.size() : i);
        }
    }

    protected void doBatchSave(List<T> entitys, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            save(entitys.get(i));
        }
    }

    protected List<T> toList(List<T> entitys, int startIndex, int endIndex) {
        List<T> newList = new ArrayList<>(endIndex - startIndex);
        for (int i = startIndex; i < endIndex; i++) {
            T entity = entitys.get(i);
            if (entity.isNewRecord()) {
                this.preInsert(entity);
            } else {
                this.preUpdate(entity);
            }
            newList.add(entity);
        }
        return newList;
    }
}