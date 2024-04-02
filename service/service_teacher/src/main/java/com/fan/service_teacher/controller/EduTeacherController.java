package com.fan.service_teacher.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.common.R;
import com.fan.service_teacher.domain.EduTeacher;
import com.fan.service_teacher.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduTeacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/list")
    public R list(){
        List<EduTeacher> list = eduTeacherService.list();
        return R.ok().data("item", list);
    }

    @GetMapping("/page/{current}/{size}")
    public R page(@PathVariable("current") Integer current, @PathVariable("size") Integer size){
        Page<EduTeacher> page = new Page<>(current, size);
        Page<EduTeacher> eduTeacherPage = eduTeacherService.page(page);
        Map map = new HashMap();
        map.put("total", eduTeacherPage.getTotal());
        map.put("current", eduTeacherPage.getCurrent());
        map.put("size", eduTeacherPage.getSize());
        map.put("item", eduTeacherPage.getRecords());
        return R.ok().data(map);
    }
}
