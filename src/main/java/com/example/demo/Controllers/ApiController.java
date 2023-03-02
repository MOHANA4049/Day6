package com.example.demo.Controllers;

import java.util.List;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;
import com.example.demo.Services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
    @Autowired
    ChildRepo serviceRepository;
    @Autowired
    ApiService service;
    @PostMapping("/")
    public Child create(@PathVariable Child t)
    {
        return serviceRepository.save(t);
    }
    @GetMapping("{field}")
    public List<Child>childSortList(@PathVariable String field)
    {
       return service.getSort(field);
    }
    @GetMapping("/{offset}/{pagesize}")
    public List<Child>childWithPagination(@PathVariable int offset,@PathVariable int pagesize)
    {
        return service.setPages(offset,pagesize);
    }
    @GetMapping("/{offset}/{pagesize}/{field}")
    public Page<Child> pageField(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
        return service.pageFields(offset,pagesize,field);
    }
}