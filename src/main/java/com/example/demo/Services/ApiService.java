
package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;

public class ApiService {
    @Autowired
    ChildRepo repository;
    public List<Child>getSort(String field)
    {
         return repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    public List<Child>setPages(@PathVariable int offset,@PathVariable int pageSize)
    {
        Page<Child>page=repository.findAll(PageRequest.of(offset, pageSize));
        return page.getContent();
    }

    public Page<Child> pageFields(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
        Pageable page = PageRequest.of(offset, pagesize, Sort.Direction.ASC,field);
        return repository.findAll(page);
    }
}
