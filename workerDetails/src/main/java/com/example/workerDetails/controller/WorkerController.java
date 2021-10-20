package com.example.workerDetails.controller;

import com.example.workerDetails.baseResponse.BaseResponse;
import com.example.workerDetails.dto.WorkerDTO;
import com.example.workerDetails.model.Department;
import com.example.workerDetails.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerServiece;

    @PostMapping("/add")
    public BaseResponse add(@RequestBody WorkerDTO workerDTO) {
        return workerServiece.add(workerDTO);
    }

    @GetMapping("/getAll")
    public List<Department> list(){
        return workerServiece.listAll();
    }

    @DeleteMapping("/deleteAll")
    public BaseResponse deleted( ){
        return workerServiece.deleted();
    }

    @PutMapping("/Update")
    public BaseResponse updateDetail(@RequestBody WorkerDTO workerDTO) {
        return workerServiece.updatedetail(workerDTO);
    }
    @GetMapping("/workerById/{id}")
    public Department findWorkerById(@PathVariable int id){
        return workerServiece.getWorkerById(id);
    }
}
