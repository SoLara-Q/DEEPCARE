package com.deepcare.common.api;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class CrudController<T> {
    protected abstract IService<T> service();

    @GetMapping
    public ApiResponse<List<T>> list() {
        return ApiResponse.ok(service().list());
    }

    @GetMapping("/{id}")
    public ApiResponse<T> get(@PathVariable Long id) {
        T entity = service().getById(id);
        return entity == null ? ApiResponse.fail("记录不存在") : ApiResponse.ok(entity);
    }

    @PostMapping
    public ApiResponse<T> create(@RequestBody T entity) {
        service().save(entity);
        return ApiResponse.ok(entity);
    }

    @PutMapping("/{id}")
    public ApiResponse<T> update(@PathVariable Long id, @RequestBody T entity) {
        BeanWrapper wrapper = new BeanWrapperImpl(entity);
        if (wrapper.isWritableProperty("id")) {
            wrapper.setPropertyValue("id", id);
        }
        service().updateById(entity);
        return ApiResponse.ok(service().getById(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service().removeById(id);
        return ApiResponse.ok(null);
    }
}
